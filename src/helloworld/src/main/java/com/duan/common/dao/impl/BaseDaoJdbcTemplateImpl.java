package com.duan.common.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.duan.common.dao.BaseDao;

/**
 * 创建时间 2017年3月30日
 * 作者 段大平
 *通用接口
 */
public abstract class BaseDaoJdbcTemplateImpl<T>   implements BaseDao<T> {
	
    /** 设置一些操作的常量 */
    public static final String SQL_INSERT = "insert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_DELETE = "delete";
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	protected Class<T> entityClass;
	
	/**
	 * 默认构造方法
	 * 通过反射机制给T对象化
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoJdbcTemplateImpl() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("Dao实现类是：" + entityClass.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 组装SQL
	 * @param sqlFlag
	 * @return
	 */
	private  String makeSql(String sqlFlag) {
		StringBuffer sql = new StringBuffer();
		Field[] fields = entityClass.getDeclaredFields();
		if (sqlFlag.equals(SQL_INSERT)) {
			sql.append(" INSERT INTO " + entityClass.getSimpleName());
			sql.append("(");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true); // 暴力反射
				String column = fields[i].getName();
				sql.append(column).append(",");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(") VALUES (");
			for (int i = 0; fields != null && i < fields.length; i++) {
				sql.append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(")");
		} else if (sqlFlag.equals(SQL_UPDATE)) {
			sql.append(" UPDATE " + entityClass.getSimpleName() + " SET ");
			for (int i = 0; fields != null && i < fields.length; i++) {
				fields[i].setAccessible(true); // 暴力反射
				String column = fields[i].getName();
				if (column.equals("id")) { // id 代表主键
					continue;
				}
				sql.append(column).append("=").append("?,");
			}
			sql = sql.deleteCharAt(sql.length() - 1);
			sql.append(" WHERE id=?");
		} else if (sqlFlag.equals(SQL_DELETE)) {
			sql.append(" DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?");
		}
		System.out.println("SQL=" + sql);
		return sql.toString();

	} 
	

	/**
	 * 设置参数
	 * @param entity
	 * @param sqlFlag
	 * @return
	 */
	private Object[] setArgs(T entity, String sqlFlag) {
		Field[] fields = entityClass.getDeclaredFields();
		if (sqlFlag.equals(SQL_INSERT)) {
			Object[] args = new Object[fields.length];
			for (int i = 0; args != null && i < args.length; i++) {
				try {
					fields[i].setAccessible(true); // 暴力反射
					args[i] = fields[i].get(entity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return args;
		} else if (sqlFlag.equals(SQL_UPDATE)) {
			Object[] tempArr = new Object[fields.length];
			for (int i = 0; tempArr != null && i < tempArr.length; i++) {
				try {
					fields[i].setAccessible(true); // 暴力反射
					tempArr[i] = fields[i].get(entity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Object[] args = new Object[fields.length];
			System.arraycopy(tempArr, 1, args, 0, tempArr.length - 1); // 数组拷贝
			args[args.length - 1] = tempArr[0];
			return args;
		} else if (sqlFlag.equals(SQL_DELETE)) {
			Object[] args = new Object[1]; // 长度是1
			fields[0].setAccessible(true); // 暴力反射
			try {
				args[0] = fields[0].get(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return args;
		}
		return null;

	}

	
	/**
	 * 设置参数类型
	 * @param entity
	 * @param sqlFlag
	 * @return
	 */
	private int[] setArgTypes(T entity, String sqlFlag) {
		Field[] fields = entityClass.getDeclaredFields();
		if (sqlFlag.equals(SQL_INSERT)) {
			int[] argTypes = new int[fields.length];
			try {
				for (int i = 0; argTypes != null && i < argTypes.length; i++) {
					fields[i].setAccessible(true); // 暴力反射
					String type=fields[i].get(entity).getClass().getName();
					System.out.println("type的类型信息是："+type);
					if (type.equals("java.lang.String")) {
						argTypes[i] = Types.VARCHAR;
					} else if (type.equals("java.lang.Double")) {
						argTypes[i] = Types.DECIMAL;
					} else if (type.equals("java.lang.Integer")) {
						argTypes[i] = Types.INTEGER;
					} else if (type.equals("java.util.Date")) {
						argTypes[i] = Types.DATE;
					}else if(type.equals("java.lang.Long")){
						argTypes[i] = Types.BIGINT;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return argTypes;
		} else if (sqlFlag.equals(SQL_UPDATE)) {
			int[] tempArgTypes = new int[fields.length];
			int[] argTypes = new int[fields.length];
			try {
				for (int i = 0; tempArgTypes != null && i < tempArgTypes.length; i++) {
					fields[i].setAccessible(true); // 暴力反射
					if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
						tempArgTypes[i] = Types.VARCHAR;
					} else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
						tempArgTypes[i] = Types.DECIMAL;
					} else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
						tempArgTypes[i] = Types.INTEGER;
					} else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
						tempArgTypes[i] = Types.DATE;
					}
				}
				System.arraycopy(tempArgTypes, 1, argTypes, 0, tempArgTypes.length - 1); // 数组拷贝
				argTypes[argTypes.length - 1] = tempArgTypes[0];

			} catch (Exception e) {
				e.printStackTrace();
			}
			return argTypes;

		} else if (sqlFlag.equals(SQL_DELETE)) {
			int[] argTypes = new int[1]; // 长度是1
			try {
				fields[0].setAccessible(true); // 暴力反射
				if (fields[0].get(entity).getClass().getName().equals("java.lang.String")) {
					argTypes[0] = Types.VARCHAR;
				} else if (fields[0].get(entity).getClass().getName().equals("java.lang.Integer")) {
					argTypes[0] = Types.INTEGER;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return argTypes;
		}
		return null;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void save(T entity) {
        String sql = this.makeSql(SQL_INSERT);
        Object[] args = this.setArgs(entity, SQL_INSERT);
        int[] argTypes = this.setArgTypes(entity, SQL_INSERT);
        jdbcTemplate.update(sql.toString(), args, argTypes);
	}

	@Override
	public void save(List<T> t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void total() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}


	
}
