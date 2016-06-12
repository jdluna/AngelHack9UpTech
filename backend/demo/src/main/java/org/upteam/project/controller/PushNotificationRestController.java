package org.upteam.project.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.upteam.project.domain.PushNotification;
import org.upteam.project.service.PushNotificationService;
import org.upteam.project.util.Log;

@RestController
public class PushNotificationRestController {
	private static @Log Logger LOG;
	
	@Autowired
	PushNotificationService pushNotificationService;

	@RequestMapping(value = "/api/", method = RequestMethod.GET)
	public ResponseEntity<List<PushNotification>> listAllPushNotifications() {
		LOG.info("Enter to PushNotificationRestController.listAllPushNotifications()");
		List<PushNotification> pushNotifications = pushNotificationService.findAllPushNotifications();
		return new ResponseEntity<List<PushNotification>>(pushNotifications, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PushNotification> getPushNotificationById(@PathVariable("id") long id) {
		LOG.info("Enter to PushNotificationRestController.getPushNotificationById()");
		LOG.info("Fetching PushNotification with id " + id);
        PushNotification pushNotification = pushNotificationService.findById(id);
        if (pushNotification == null) {
        	LOG.info("PushNotification with id " + id + " not found");
            return new ResponseEntity<PushNotification>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PushNotification>(pushNotification, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/identificador/{identificador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PushNotification> getPushNotificationByIdentificador(@PathVariable("identificador") String identificador) {
		LOG.info("Enter to PushNotificationRestController.getPushNotificationByIdentificador()");
		LOG.info("Fetching PushNotification with identificador " + identificador);
        PushNotification pushNotification = pushNotificationService.findByIdentificador(identificador);
        if (pushNotification == null) {
        	LOG.info("PushNotifications with identificador " + identificador + " not found");
            return new ResponseEntity<PushNotification>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PushNotification>(pushNotification, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPushNotification(@RequestBody PushNotification pushNotification, UriComponentsBuilder ucBuilder) {
		LOG.info("Enter to PushNotificationRestController.createPushNotification()");
        Date now = new Date();
        pushNotification.setFechaRegistro(new Timestamp(now.getTime()));
        pushNotificationService.savePushNotification(pushNotification);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/{id}").buildAndExpand(pushNotification.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
