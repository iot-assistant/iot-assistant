package com.iotassistant.models.rules;

public interface SensorRuleVisitor {
	
	public void visit(EnableRuleSensorRule enableRuleSensorRule);
	
	public void visit(TriggerActuatorSensorRule triggerActuatorSensorRule);

	public void visit(AlarmSensorRule alarmSensorRule);

	public void visit(CameraSensorRule cameraSensorRule);
	


}
