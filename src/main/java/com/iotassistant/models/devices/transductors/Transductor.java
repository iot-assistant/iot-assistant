package com.iotassistant.models.devices.transductors;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.iotassistant.models.devices.Device;
import com.iotassistant.models.devices.DeviceInterface;
import com.iotassistant.models.devices.WatchdogInterval;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="transductor_type")
@Table(name="transductor")
public abstract class Transductor extends Device{
	
	
	public Transductor() {
		super();
	}

	Transductor(String name, String description, WatchdogInterval watchdogInterval, DeviceInterface deviceInterface) {
		super(name, description, watchdogInterval, deviceInterface);
	}
	
	public abstract String getLastValueDate();
	
}
