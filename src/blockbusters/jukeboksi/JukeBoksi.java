package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;

public class JukeBoksi {

	EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
	EV3ColorSensor discReader = new EV3ColorSensor(SensorPort.S4);
	EV3ColorSensor coinSensor = new EV3ColorSensor(SensorPort.S2);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3MediumRegulatedMotor discMotor = new EV3MediumRegulatedMotor(MotorPort.D);
	
	Screen screen = new Screen();
	Remote remote = new Remote(irSensor);
	MusicPlayer music = new MusicPlayer();
	CoinCounter coin = new CoinCounter(coinSensor);
	DiscReader discPlayer = new DiscReader(discReader, discMotor);
	Drive driver = new Drive(leftMotor, rightMotor);
	
	
	
	
	
	
	
	
}
