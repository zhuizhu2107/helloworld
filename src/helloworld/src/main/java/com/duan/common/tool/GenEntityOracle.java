package com.duan.common.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

/**
 * oracle数据表生成实体工具类
 */
public class GenEntityOracle {
	
	private String packageOutPath = "com.duan.bean";// 指定实体生成所在包的路径
	private String authorName = "ddp";// 作者名字
	private String schemaName="citicsutil";//schema名称
	private String[] colnames; // 列名数组
	private String[] colTypes; // 列名类型数组
	private int[] colSizes; // 列名大小数组
	private boolean f_util = false; // 是否需要导入包java.util.*
	private boolean f_sql = false; // 是否需要导入包java.sql.*
	
	private boolean f_temporal=false;//是否需要导入时间戳相关包
	
	
	private static Properties prop=null;
    private Connection con = null;
    private Statement pStemt = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;
    
    
	static{
		prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据指定的表名生成实体
	 * @param tableName 表名 
	 */
	public void genEntity(String tableName){
		System.out.println("*****************************开始执行任务********************************");
		int size = 0;
		String sql = "SELECT * FROM " + tableName;
		
		try {
			rs = pStemt.executeQuery(sql);
			rsmd = rs.getMetaData();
            size = rsmd.getColumnCount();
            colnames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            for (int i = 0; i < size; i++) {
                colnames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
 
                if (colTypes[i].equalsIgnoreCase("date")
                        || colTypes[i].equalsIgnoreCase("timestamp")) {
                    f_util = true;
                }
                if (colTypes[i].equalsIgnoreCase("blob")
                        || colTypes[i].equalsIgnoreCase("char")) {
                    f_sql = true;
                }
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }
           
            System.out.println("*****************************规范化表名********************************");
			String normTableName = normTableName(tableName);
			
			System.out.println("*****************************获取单张数据库表注释********************************");
			String tableComment = getTableComment(tableName);
			
			System.out.println("*****************************获取单张数据库表的所有列信息********************************");
			StringBuffer tempSb = getColsInfo(tableName);
			
			System.out.println("*****************************生成JavaBean文件********************************");
			genFile(normTableName,getSb(tableName,normTableName, tableComment, tempSb));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("*****************************执行任务结束********************************");
	}

	/**
	 * 生成JavaBean文件
	 *
	 * @param content
	 */
	private void genFile(String tableName, StringBuffer content) {
		try {
			File directory = new File("");
			String outputPath = directory.getAbsolutePath() + "/src/main/java/" + this.packageOutPath.replace(".", "/") + "/"
					+ tableName + ".java";
			FileWriter fw = new FileWriter(outputPath);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect();
		}
	}

	/**
	 * 构建StringBuffer缓存
	 *
	 * @param tableName
	 * @param tableComment
	 * @param colSb
	 * @return
	 */
	private StringBuffer getSb(String tableName,String normTableName, String tableComment, StringBuffer colSb) {
		StringBuffer sb = new StringBuffer();
		sb.append("package " + this.packageOutPath + ";\r\n");
		sb.append("\n");
		// 判断是否导入工具包
		sb.append("import java.io.Serializable;\n");
		if (f_util) {
			sb.append("import java.util.Date;\r\n");
			sb.append("\n");
		}
		if (f_sql) {
			sb.append("import java.sql.*;\r\n");
			sb.append("\n");
		}
		
		sb.append("import javax.persistence.Column;\r\n");
		sb.append("import javax.persistence.Entity;\r\n");
		sb.append("import javax.persistence.Id;\r\n");
		sb.append("import javax.persistence.Table;\r\n");
		if(f_temporal){
			sb.append("import javax.persistence.Temporal;\r\n");
			sb.append("import javax.persistence.TemporalType;\r\n");
		}
		
		sb.append("\r\n");
		// 注释部分
		sb.append("/**\r\n");
		sb.append("* " + normTableName + " 实体类(" + tableComment + ")\r\n");
		sb.append("* " + new Date() + "\r\n");
		sb.append("* @author " + this.authorName + "\r\n");
		sb.append("*/ \r");
		
		//关联注释内容
		sb.append("@Entity\r\n");
		sb.append("@Table(name=\""+tableName+"\",schema=\""+schemaName+"\")\r\n");
		
		// 实体部分
		sb.append("public class " + normTableName + " implements Serializable{\r\n");
		sb.append("\tprivate static final long serialVersionUID = "+new Date().getTime()+"L;\r\n");
		sb.append(colSb);
		sb.append("}");
		return sb;
	}

	/**
	 * 获取单张数据库表的所有列信息
	 *
	 * @param tableName
	 */
	private StringBuffer getColsInfo(String tableName) {
		StringBuffer temp = new StringBuffer();
		
		//获取该表的主键
		String id=getTablePrimary(tableName);
		
		/**画字段部分内容**/
		for (int i = 0; i < colnames.length; i++) {
			temp.append("\t/**"+getColComment(tableName, colnames[i])+"**/\r\n");
			temp.append("\tprivate "+getColsType(colTypes[i])+" "+normColName(colnames[i])+";\r\n");
			temp.append("\r\n");
		}

		/**画setter和getter方法部分内容**/
		for (int i = 0; i < colnames.length; i++) {
			String constraints="";
			/**getter方法部分**/
			if(id.equals(colnames[i])){//主键
				temp.append("\t@Id\r");
				if(colTypes[i].equals("VARCHAR2")){
					constraints="name=\""+colnames[i]+"\",nullable=false,length="+colSizes[i];
				}else{
					constraints="name=\""+colnames[i]+"\",nullable=false";
				}
			}else{//普通字段
				if(colTypes[i].equals("VARCHAR2")){
					constraints="name=\""+colnames[i]+"\",length="+colSizes[i];
				}else if(colTypes[i].equals("TIMESTAMP")){
					temp.append("\t@Temporal(TemporalType.TIMESTAMP)\r");
					constraints="name=\""+colnames[i]+"\"";
					f_temporal=true;
				}else{
					constraints="name=\""+colnames[i]+"\"";
				}
			}
			
			temp.append("\t@Column("+constraints+")\r");
			temp.append("\n\tpublic "+getColsType(colTypes[i])+" get"+normTableName(colnames[i])+"() {\r\n");
			temp.append("\t    return "+normColName(colnames[i])+";\r\n");
			temp.append("\t}\r");

			/**setter方法部分**/
			temp.append("\n\tpublic void set"+normTableName(colnames[i])+"("+getColsType(colTypes[i])+" "+normColName(colnames[i])+") {\r\n");
			temp.append("\t    this."+normColName(colnames[i])+"="+normColName(colnames[i])+";\r\n");
			temp.append("\t}\r");
			
			temp.append("\n\n");
			
		}		
		
		return temp;
	}

	private String getTablePrimary(String tableName) {
		String str = "";
		String sql = "select a.column_name from user_cons_columns a, user_constraints b "
				+ "where a.constraint_name = b.constraint_name and b.constraint_type = 'P' and a.table_name = '"+tableName.toUpperCase()+"'";
		try {
			rs = pStemt.executeQuery(sql);
			while (rs.next()) {
				str = rs.getString("column_name");
				if (null != str && str.indexOf("\r\n") != -1) {
					str = str.replace("\r\n", "");
				}
				if (null != str && str.indexOf("\n") != -1) {
					str = str.replace("\n", "");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 获取列注释
	 *
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	private String getColComment(String tableName, String columnName) {
		String str = "";
		String sql = "select comments from USER_COL_COMMENTS where table_name= '" + tableName + "' and column_name= '"
				+ columnName + "'";
		try {
			rs = pStemt.executeQuery(sql);
			while (rs.next()) {
				str = rs.getString("comments");
				if (null != str && str.indexOf("\r\n") != -1) {
					str = str.replace("\r\n", "");
				}
				if (null != str && str.indexOf("\n") != -1) {
					str = str.replace("\n", "");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 获取列类型
	 *
	 * @param sqlType
	 * @return
	 */
	private String getColsType(String sqlType) {
		if (sqlType.equalsIgnoreCase("binary_double")) {
			return "double";
		} else if (sqlType.equalsIgnoreCase("binary_float")) {
			return "float";
		} else if (sqlType.equalsIgnoreCase("blob")) {
			return "byte[]";
		} else if (sqlType.equalsIgnoreCase("blob")) {
			return "byte[]";
		} else if (sqlType.equalsIgnoreCase("char") || sqlType.equalsIgnoreCase("nvarchar2")
				|| sqlType.equalsIgnoreCase("varchar2")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("date") || sqlType.equalsIgnoreCase("timestamp")
				|| sqlType.equalsIgnoreCase("timestamp with local time zone")
				|| sqlType.equalsIgnoreCase("timestamp with time zone")) {
			return "Date";
		} else if (sqlType.equalsIgnoreCase("number")) {
			return "Long";
		}
		return "String";
	}

	/**
	 * 获取单张数据库表注释
	 *
	 * @param tableName
	 * @return
	 */
	private String getTableComment(String tableName) {
		String str = "";
		String sql = "select * from user_tab_comments where table_name = '" + tableName + "'";
		try {
			rs = pStemt.executeQuery(sql);
			while (rs.next()) {
				str = rs.getString("comments");
				if (null != str && str.indexOf("\r\n") != -1) {
					str = str.replace("\r\n", "");
				}
				if (null != str && str.indexOf("\n") != -1) {
					str = str.replace("\n", "");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 规范类名
	 * @param tableName
	 * @return
	 */
	private String normTableName(String tableName) {
		tableName=tableName.toLowerCase();
		if(tableName.indexOf("_")!=-1){
			String newTableName="";
			String[] strArr=tableName.split("_");
			for (String str : strArr) {
				newTableName+=StringUtils.captureName(str);
			}
			
			tableName=newTableName;
		}else{
			tableName=StringUtils.captureName(tableName.toLowerCase());
		}
		
		return tableName;
	}
	
	/**
	 * 规范变量名
	 * @param tableName
	 * @return
	 */
	private String normColName(String colName) {
		colName=colName.toLowerCase();
		if(colName.indexOf("_")!=-1){
			String newTableName="";
			String[] strArr=colName.split("_");
			for (String str : strArr) {
				newTableName+=StringUtils.captureName(str);
			}
			
			colName=StringUtils.lowerName(newTableName);
		}
		
		return colName;
	}	
	

	/**
	 * 构造方法，初始化资源
	 */
	public GenEntityOracle(){
		try {
            Class.forName(prop.getProperty("jdbc.driver"));
            con = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
            pStemt = (Statement) con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    /**
     * 释放资源
     */
    private void closeConnect() {
        try {
            if (con != null) {
                con.close();
                con = null;
            }
            if (pStemt != null) {
                pStemt.close();
                pStemt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
    
    /**
     * oracle数据表生成实体工具类执行入口
     */
    public static void main(String[] args) {
    	GenEntityOracle test=new GenEntityOracle();
    	test.genEntity("TEST_SYS_CONFIG");
	}
	
}
