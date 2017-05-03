package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * Jukeboksi toimii viestinv‰litt‰j‰n‰ ja yhdist‰‰ muut luokat.
 * 
 * @author Joona Ikonen
 * @version 0.5
 */

public class JukeBoksi {

	EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
	EV3ColorSensor discReader = new EV3ColorSensor(SensorPort.S4);
	EV3ColorSensor coinSensor = new EV3ColorSensor(SensorPort.S2);
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	EV3MediumRegulatedMotor discMotor = new EV3MediumRegulatedMotor(MotorPort.D);

	public static String artistName;
	public static String songName;
	public static int coinCount;
	public static int creditCount;

	private Screen screen;
	private Remote remote;
	private MusicPlayer music;
	private CoinCounter coin;
	private DiscReader discPlayer;
	private Drive driver;

	public JukeBoksi() {
		screen = new Screen();
		remote = new Remote(irSensor);
		music = new MusicPlayer();
		coin = new CoinCounter(coinSensor);
		discPlayer = new DiscReader(discReader, discMotor);
		driver = new Drive(leftMotor, rightMotor);
	}

	public void Player() {

		boolean start = true;
	
		music.start();
		coin.start();
		remote.start();
		//driver.start();
		
		artistName = music.getArtistName();
		songName = music.getSongName();
		screen.showPage(1);
		
		while (start) {
			
			creditCount = coin.getCredits();
			switch (remote.getRemoteCommand()) {
			case 1: // Remote topleft
				music.incVolume();
				break;
			case 2: // Remote bottomleft
				music.decVolume();
				break;
			case 3: // Remote topright, musiikin pys‰ytys
				//if(music.isPlaying()){
					music.stopPlaying();
				//}
				//else{
				//	music.startPlaying();
				//}	
				break;
			case 4: // Remote bottomright, saldo
				coinCount = coin.getCoins();
				screen.showPage(9);
				break;
			case 5: // LEFT-Button
				 if(music.isPlaying()){
				 break;
				 }
				 else{
				 discPlayer.lastSong(); 
				 music.changeSong(discPlayer.getSongID());
				 creditCount = coin.getCredits();
				 artistName = music.getArtistName();
				 songName = music.getSongName(); 
				 screen.showPage(1);
				 break;
				 }
				 
				 
			case 6: // RIGHT-Button
				if(music.isPlaying()){
				break;
				}
				else{
				discPlayer.nextSong();
				music.changeSong(discPlayer.getSongID());
				creditCount = coin.getCredits();
				artistName = music.getArtistName();
				songName = music.getSongName(); 
				screen.showPage(1);
				break;
				}
				
				
			case 7: // UP-Button
				music.incVolume();
				break;
			case 8: // DOWN-button
				music.decVolume();
				break;
			case 9: // ENTER-button
				
				if(coin.useCredits()){
					music.startPlaying();
					creditCount = coin.getCredits();
					screen.showPage(1);
					/*
					 * driver.dance(music.getSongName());
					 */
				}
				else{
					screen.showPage(3);
				}
			case 10:
				start = false;
				break;
			}
			Delay.msDelay(50);
		}
		
		music.interrupt();
		coin.interrupt();
		remote.interrupt();
		//driver.interrupt();
		
		try {
			music.join();
			coin.join();
			remote.join();
			//driver.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		irSensor.close();
		discMotor.close();
		discReader.close();
		coinSensor.close();
		leftMotor.close();
		rightMotor.close();
		
		

	}
}
