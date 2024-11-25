package com.iotassistant.models.devices.transductors;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.iotassistant.models.devices.DeviceInterface;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="sensorInterface_type")
@DiscriminatorValue("sensorInterface")
@Table(name="sensorInterface")
public abstract class SensorInterface extends DeviceInterface{
	

}
