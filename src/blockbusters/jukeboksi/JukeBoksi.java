package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

public class JukeBoksi {

	EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
	EV3ColorSensor discReader = new EV3ColorSensor(SensorPort.S4);
	EV3ColorSensor coinSensor = new EV3ColorSensor(SensorPort.S2);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3MediumRegulatedMotor discMotor = new EV3MediumRegulatedMotor(MotorPort.D);

	public static String artistName;
	public static String songName;
	
	private Screen screen;
	private Remote remote;
	private MusicPlayer music;
	private CoinCounter coin;
	private DiscReader discPlayer;
	private Drive driver;
	
	public JukeBoksi(){
		screen = new Screen();
		remote = new Remote(irSensor);
		music = new MusicPlayer();
		coin = new CoinCounter(coinSensor);
		discPlayer = new DiscReader(discReader, discMotor);
		driver = new Drive(leftMotor, rightMotor);
	}

	public void aja() {

		
		artistName = music.getArtistName();
		songName = music.getSongName();
		screen.showPage(1);
		
		while (true) {
			
			switch (remote.getRemoteCommand()) {
			case 1: // Remote topleft
				music.incVolume();
				break;
			case 2: // Remote bottomleft
				music.decVolume();
				break;
			case 3: // Remote topright, musiikin pysäytys
				music.stop_playing();
				break;
			case 4: // Remote bottomright, saldo
				screen.showPage(9);
				break;
			case 5: // LEFT-Button
				/* if(music.isPlaying()){
				 * break;
				 * }
				 * else{
				 * discPlayer.lastSong(); 
				 * artistName = music.getArtistName();
				 * songName = music.getSongname(); 
				 * screen.showPage(1);
				 * break;
				 * }
				 * 
				 */
			case 6: // RIGHT-Button
				/* if(music.isPlaying()){
				 * break;
				 * }
				 * else{
				 * discPlayer.nextSong(); 
				 * artistName = music.getArtistName();
				 * songName = music.getSongname(); 
				 * screen.showPage(1);
				 * break;
				 * }
				 * 
				 */
			case 7:
				music.incVolume();
				break;
			case 8:
				music.decVolume();
				break;
			case 9:
				/*
				 * Enter-näppäin Biisin aloitus, jos krediittejä on 
				 * Tanssi? Mikä metodi?
				 * 
				 */
			}
			Delay.msDelay(50);
		}

	}
}
