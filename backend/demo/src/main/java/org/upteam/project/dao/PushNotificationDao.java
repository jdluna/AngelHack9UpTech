package org.upteam.project.dao;

import java.util.List;

import org.upteam.project.domain.PushNotification;

public interface PushNotificationDao {
	PushNotification findById(long id);
    
	PushNotification findByIdentificador(String identificador);
     
    void savePushNotification(PushNotification pushNotification);
 
    List<PushNotification> findAllPushNotifications(); 

}
