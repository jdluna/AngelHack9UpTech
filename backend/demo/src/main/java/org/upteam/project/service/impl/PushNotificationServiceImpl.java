package org.upteam.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upteam.project.dao.PushNotificationDao;
import org.upteam.project.domain.PushNotification;
import org.upteam.project.service.PushNotificationService;

@Service("pushNotificationService")
@Transactional
public class PushNotificationServiceImpl implements PushNotificationService {
	@Autowired
	private PushNotificationDao pushNotificationDao;
	
	@Override
	public PushNotification findById(long id) {
		return pushNotificationDao.findById(id);
	}

	@Override
	public PushNotification findByIdentificador(String identificador) {
		return pushNotificationDao.findByIdentificador(identificador);
	}

	@Override
	public void savePushNotification(PushNotification pushNotification) {
		pushNotificationDao.savePushNotification(pushNotification);
	}

	@Override
	public List<PushNotification> findAllPushNotifications() {
		return pushNotificationDao.findAllPushNotifications();
	}

}
