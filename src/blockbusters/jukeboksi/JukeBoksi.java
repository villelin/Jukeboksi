package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * Jukeboksi toimii viestinvälittäjänä ja yhdistää muut luokat.
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
		// driver.start();

		int lastPage = 1;
		int creditChange = creditCount;
		artistName = music.getArtistName();
		songName = music.getSongName();
		screen.showPage(lastPage);

		while (start) {

			creditCount = coin.getCredits();
			if (creditChange != creditCount) {
				creditChange = creditCount;
				screen.showPage(lastPage);
			}

			switch (remote.getRemoteCommand()) {
			case 1: // Remote topleft
				music.incVolume();
				break;
			case 2: // Remote bottomleft
				music.decVolume();
				break;
			case 3: // Remote topright, musiikin pysäytys
				// if(music.isPlaying()){
				music.stopPlaying();
				// }
				// else{
				// music.startPlaying();
				// }
				break;
			case 4: // Remote bottomright, saldo
				coinCount = coin.getCoins();
				lastPage = 9;
				screen.showPage(lastPage);
				break;
			case 5: // LEFT-Button
				if (music.isPlaying()) {
					break;
				} else {
					discPlayer.lastSong();
					music.changeSong(discPlayer.getSongID());
					creditCount = coin.getCredits();
					artistName = music.getArtistName();
					songName = music.getSongName();
					lastPage = 1;
					screen.showPage(lastPage);
					break;
				}

			case 6: // RIGHT-Button
				if (music.isPlaying()) {
					break;
				} else {
					discPlayer.nextSong();
					music.changeSong(discPlayer.getSongID());
					creditCount = coin.getCredits();
					artistName = music.getArtistName();
					songName = music.getSongName();
					lastPage = 1;
					screen.showPage(lastPage);
					break;
				}

			case 7: // ENTER-button
				if (music.isPlaying()) {
					break;
				} else {
					if (coin.useCredits()) {
						music.startPlaying();
						creditCount = coin.getCredits();
						lastPage = 1;
						screen.showPage(lastPage);
						/*
						 * driver.dance(music.getSongName());
						 */
					} else {
						lastPage = 3;
						screen.showPage(lastPage);
					}
				}
				break;
			case 8:
				start = false;
				break;
			case 9: // Remotedrive topleft
				// driver.driveleftmotor
				break;
			case 10: // Remotedrive bottomleft
				// driver.driverightmotor
				break;
			case 11: // Remotedrive topright
				// driver.drive JOTAIN
				break;
			case 12: // Remotedrive bottomright
				// driver.drive JOTAIN
				break;
			case 13: // Remotedrive topleft + topright
				// driver.drive ETEENPÄIN?
				break;
			case 14: // Remotedrive bottomledt + bottomright
				// driver.drive TAAKSEPÄIN?
				break;
			}
			Delay.msDelay(50);
		}

		music.interrupt();
		coin.interrupt();
		remote.interrupt();
		// driver.interrupt();

		try {
			music.join();
			coin.join();
			remote.join();
			// driver.join();
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
