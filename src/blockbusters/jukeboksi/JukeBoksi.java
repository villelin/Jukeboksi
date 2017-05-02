package blockbusters.jukeboksi;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class JukeBoksi {

	EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
	Screen screen = new Screen();
	Remote remote = new Remote(irSensor);
	
	
	
	
}
