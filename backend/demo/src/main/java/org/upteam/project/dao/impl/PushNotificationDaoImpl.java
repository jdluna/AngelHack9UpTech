package org.upteam.project.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.upteam.project.dao.AbstractDao;
import org.upteam.project.dao.PushNotificationDao;
import org.upteam.project.domain.PushNotification;

@Transactional
@Repository("pushNotificationDao")
public class PushNotificationDaoImpl extends AbstractDao implements PushNotificationDao {
	
	@Override
	public PushNotification findById(long id) {
		Criteria criteria = getSession().createCriteria(PushNotification.class);
        criteria.add(Restrictions.eq("id", id));
		return (PushNotification) criteria.uniqueResult();
	}
	
	@Override
	public PushNotification findByIdentificador(String identificador) {
		Criteria criteria = getSession().createCriteria(PushNotification.class);
        criteria.add(Restrictions.eq("identificador",identificador));
        criteria.addOrder(Order.desc("fechaRegistro"));
		criteria.setMaxResults(1);
        return (PushNotification) criteria.uniqueResult();
	}

	@Override
	public void savePushNotification(PushNotification pushNotification) {
		persist(pushNotification);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PushNotification> findAllPushNotifications() {
		Criteria criteria = getSession().createCriteria(PushNotification.class);
        return (List<PushNotification>) criteria.list();
	}

}
