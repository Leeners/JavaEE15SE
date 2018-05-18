package cn.edu.chzu.xxxy.se15.javaee.hibernate.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CustomerDAO {
	private static final Log log = LogFactory.getLog(CustomerDAO.class);
		
	public List findByHql(String hql) {
		log.debug("finding customers instance by hql");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query queryObject = session.createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by hql failed", re);
			throw re;
		} finally{
			session.close();
		}
	}

}
