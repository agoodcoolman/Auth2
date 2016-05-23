package com.police.modle.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.police.modle.User;
import com.police.modle.dao.UserDao;
import com.police.modle.dao.impl.utils.UserCloumToBean;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	
	public User getUser(String userid) {
		Session openSession = this.sessionFactory.openSession();
		String hql = "select * from user where userId = :userid"; // :±ðÃû
		Query query = openSession.createQuery(hql).setParameter("userid", userid);
		List<User> list = query.setResultTransformer(new UserCloumToBean(User.class)).list();
		
		return list.get(0);
	}

	public void saveUser(User user) {
		Session openSession = this.sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		
		openSession.save(user);
		beginTransaction.commit();
		openSession.flush();
		openSession.evict(user);
		openSession.close();

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User login(String email, String password) {
		Session openSession = this.sessionFactory.openSession();
		
		/*String hql = "select * from user where email=? and password=?";
		Query query = openSession.createSQLQuery(hql).setParameter(0, email).setParameter(1, password);*/
		Criteria criteria = openSession.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = criteria.list();
		if (list.size() == 0) {
			return null;
		}
		openSession.close();
		return list.get(0);
	}

	public void updateUseToken(Long id, String token) {
		Session openSession = this.sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		Query updatequery = openSession.createSQLQuery("update user u set u.token = ? where id = ?")
				.setParameter(0, token)
				.setParameter(1, id);
		
		updatequery.executeUpdate();
		beginTransaction.commit();
		openSession.close();
	}

	
}
