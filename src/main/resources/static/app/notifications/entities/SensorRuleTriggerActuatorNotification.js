class SensorRuleTriggerActuatorNotification extends SensorRuleNotification{
	
	
	constructor(id, sensorRule, sensorValue, date) {
		super(id, sensorRule, sensorValue, date);
	}

	toString() {
		var text = "Trigger actuator Sensor Rule " + super.toString();
		text += " Actuator Name : " + this.sensorRule.getActuatorName();
		text += " Actuator Property : " + this.sensorRule.getActuatorPropertyName();
		var setValue = this.sensorRule.getActuatorSetValue();
		if (this.sensorRule.getActuatorProperty().isBinary()) {
			setValue = this.sensorRule.getActuatorSetValue() == "true" ? 'Active' : 'Inactive';
		}
		text += " Actuator set Value : " + setValue;
		return text;
	}

	
}