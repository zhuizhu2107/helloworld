package com.duan.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.duan.common.dao.BaseDao;
import com.duan.common.tool.DBUtils;

/**
 * 创建时间 2017年3月30日 作者 段大平 通用接口
 * HibernateUtil 工具类
 */
public abstract class BaseDaoHibernateImpl<T> implements BaseDao<T> {

	protected Class<T> entityClass;

	/**
	 * 默认构造方法 通过反射机制给T对象化
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoHibernateImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			this.entityClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
		} else {
			this.entityClass = null;
		}
	}
	
	@Override
	public Serializable saveEntity(T t) {
		return DBUtils.getCurrentSession().save(t);
	}

	@Override
	public int saveEntityList(List<T> list) {
		int count=0;
		if(list.size()>0){
			int len=list.size();
			for (int i = 0; i < len; i++) {
				T t=list.get(i);
				DBUtils.getCurrentSession().save(t);
				count++;
			}
		}
		
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityById(Serializable id) {
		T t=(T) DBUtils.getCurrentSession().get(entityClass, id);
		return t;
	}

	@Override
	public T getEntityByHqlProperty(String column, String value) {
		String HQL="select t from "+entityClass.getSimpleName()+" t where t."+column+"=?";
		@SuppressWarnings("unchecked")
		List<T> list=(List<T>)DBUtils.getCurrentSession().createQuery(HQL)
																				  .setParameter(0, value)
																				  .list();
		return (list==null||list.size()==0)?null:list.get(0);
	}
	
	@Override
	public T getEntityBySqlProperty(String tableName, String colName, String colValue) {
		String SQL="select {t.*} from "+tableName+" t where t."+colName+"=?";
		@SuppressWarnings("unchecked")
		List<T> list=(List<T>)DBUtils.getCurrentSession().createSQLQuery(SQL)
																				  .addEntity("t", entityClass)
																				  .setParameter(0, colValue)
																				  .list();
		return (list==null||list.size()==0)?null:list.get(0);
	}

	@Override
	public T getEntityByHqlWhere(String sqlWhere,Object[] values, org.hibernate.type.Type[] types) {
		String HQL="select t from "+entityClass.getSimpleName()+" t where 1=1 "+sqlWhere;
		@SuppressWarnings("unchecked")
		List<T> list=(List<T>)DBUtils.getCurrentSession().createQuery(HQL)
																				  .setParameters(values,types)
																				  .list();
		return (list==null||list.size()==0)?null:list.get(0);
	}
	
	
	@Override
	public T getEntityBySqlWhere(String tableName, String sqlWhere, Object[] values, org.hibernate.type.Type[] types) {
		String SQL="select {t.*} from "+tableName+" t where 1=1 "+sqlWhere;
		@SuppressWarnings("unchecked")
		List<T> list=(List<T>)DBUtils.getCurrentSession().createSQLQuery(SQL)
																				  .addEntity("t", entityClass)
																				  .setParameters(values,types)
																				  .list();
		return (list==null||list.size()==0)?null:list.get(0);
	}	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////
	


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public T load(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String column, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String sqlWhere) {
		// TODO Auto-generated method stub
		return null;
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
