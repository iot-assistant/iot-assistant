package com.iotassistant.models.rules;

import java.util.ArrayList;
import java.util.List;

public enum SensorRuleType {
	ENABLE_DISABLE_RULE ("Enable rule"),
	TRIGGER_ACTUATOR("Trigger actuator"),
	SENSOR_ALARM("Sensor alarm"),
	CAMERA("Take camera picture");
	
	private String string;

	SensorRuleType(String string) {
		this.string = string;
	}
	
	public static List<String> getAllInstances() {
		List<String> allInstancesStrings = new ArrayList<String>();
		for (SensorRuleType type : SensorRuleType.values()) {
			allInstancesStrings.add(type.getString());
		}
		return allInstancesStrings;
	}

	public String getString() {
		return string;
	}
	
	

}
