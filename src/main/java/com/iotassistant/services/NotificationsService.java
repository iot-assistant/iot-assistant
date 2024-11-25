package com.iotassistant.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iotassistant.models.devices.Device;
import com.iotassistant.models.notifications.DeviceOfflineNotification;
import com.iotassistant.models.notifications.GpsRuleNotification;
import com.iotassistant.models.notifications.Notification;
import com.iotassistant.models.notifications.NotificationTypeEnum;
import com.iotassistant.models.notifications.SendNotificationService;
import com.iotassistant.models.notifications.SensorRuleCameraNotification;
import com.iotassistant.models.notifications.SensorRuleNotification;
import com.iotassistant.repositories.NotificationsRepository;

@Service
@Transactional
public class NotificationsService {
	
	private static NotificationsService instance;

	@Autowired
	private NotificationsRepository notificationsRepository;
	
	@Autowired
	private SendNotificationTelegramService telegramNotificationHandler;
	
	@PostConstruct
	private void registerInstance() {
		instance = this;
	} 
	
	public static NotificationsService getInstance() {
		return instance;
	}
	
	public void deleteNotificationById(int id) {
		notificationsRepository.deleteNotificationById(Integer.valueOf(id));
		
	}


	private SendNotificationService getSendNotificationService(NotificationTypeEnum notificationType) {
		assert(notificationType == NotificationTypeEnum.TELEGRAM);
		return telegramNotificationHandler;		
	}

    public Notification getNotificationById(int id) {
       return notificationsRepository.findNotificationById(id);

    }

	public List<String> getAvailableNotificationTypes() {
		return NotificationTypeEnum.getAvailableNotificationTypes();
	}

	public SendNotificationService getAvailableNotificationHandler() {
			return telegramNotificationHandler;	
	}


	public void deleteAllNotifications() {
		notificationsRepository.deleteAllNotifications();	
	}

	public List<Notification> getAllNotifications() {
		return notificationsRepository.findAllNotifications();
	}


	public byte[] getCameraSensorRuleAttachment(int id) {
		SensorRuleCameraNotification sensorRuleCameraNotification = notificationsRepository.findCameraSensorRuleNotificationById(id);
		return sensorRuleCameraNotification.getPicture();
	}


	public DeviceOfflineNotification getLastOfflineNotification(Device device) {
		List<DeviceOfflineNotification> offlineNotifications = notificationsRepository.findOfflineNotificationsByOrderByIdDesc();
		for (DeviceOfflineNotification offlineNotification : offlineNotifications) {
			if (offlineNotification.getDeviceName().equals(device.getName())) {
				return offlineNotification;
			}
		}
		return null;	
	}
	
	public void sendNotification(NotificationTypeEnum notificationType, Notification notification) {
		if (notificationType != NotificationTypeEnum.NONE) {
			notificationsRepository.saveNotification(notification);
			getSendNotificationService(notificationType).send(notification);
		}
	}

	public List<SensorRuleNotification> getSensorRulesNotificationsByIdDesc() {
		return notificationsRepository.findAllSensorRulesNotificationsByOrderByIdDesc();
	}
	
	public List<GpsRuleNotification> getGpsRulesNotificationsByIdDesc() {
		return notificationsRepository.findAllGpsRulesNotificationsByOrderByIdDesc();
	}


}
