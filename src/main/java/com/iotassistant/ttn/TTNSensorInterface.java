package com.iotassistant.ttn;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import com.iotassistant.models.devices.DeviceInterfaceVisitor;
import com.iotassistant.models.devices.transductors.SensorInterface;

@Entity
@DiscriminatorValue("sensorTTNInterface")
public class TTNSensorInterface extends SensorInterface implements TTNDeviceInterface{
	
	@Column(unique=true)
	@Pattern(regexp = "^[a-z0-9\\\\-]{3,50}$")
	private String deviceId;
	

	public TTNSensorInterface() {
		super();
	}

	public TTNSensorInterface( String deviceId) {
		super();
		this.deviceId = deviceId;

	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}



	@Override
	public void accept(DeviceInterfaceVisitor deviceInterfaceVisitor) {
		deviceInterfaceVisitor.visit(this);	
		
	}


}