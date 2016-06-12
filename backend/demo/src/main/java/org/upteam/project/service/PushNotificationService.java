package org.upteam.project.service;

import java.util.List;

import org.upteam.project.domain.PushNotification;

public interface PushNotificationService {
	PushNotification findById(long id);
    
	PushNotification findByIdentificador(String identificador);
     
    void savePushNotification(PushNotification pushNotification);
 
    List<PushNotification> findAllPushNotifications(); 
}
