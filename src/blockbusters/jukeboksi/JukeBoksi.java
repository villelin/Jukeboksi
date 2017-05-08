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
 * @version 1.0
 */

public class JukeBoksi {

	private EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
	private EV3ColorSensor discReader = new EV3ColorSensor(SensorPort.S4);
	private EV3ColorSensor coinSensor = new EV3ColorSensor(SensorPort.S2);
	private EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	private EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	private EV3MediumRegulatedMotor discMotor = new EV3MediumRegulatedMotor(MotorPort.D);

	private int coinCount;
	private int creditCount;
	private String songName;
	private String songArtist;

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

	/**
	 * Jukeboksin sydän. Käsittelee saapuvat komennot ja hallitsee muita luokkia
	 */
	public void Player() {

		boolean start = true;

		music.start();
		coin.start();
		remote.start();
		// driver.start();

		int lastPage = 1;
		int creditChange = creditCount;

		songArtist = music.getArtistName();
		songName = music.getSongName();
		creditCount = coin.getCredits();
			
		screen.songSelect(songArtist, songName);
		screen.creditAmount(creditCount);

		while (start) {

			creditCount = coin.getCredits();
			if (creditChange != creditCount) {
				creditChange = creditCount;

				if (lastPage == 1) {
					screen.songSelect(songArtist, songName);
					screen.creditAmount(creditCount);
				} else {
					screen.songPlaying(songArtist, songName);
					screen.creditAmount(creditCount);
				}
			}
			if (!music.isPlaying()){
				screen.songSelect(songArtist, songName);
				screen.creditAmount(creditCount);
			}
			

			switch (remote.getRemoteCommand()) {
			case 1: // Remote topleft
				music.incVolume(10);
				break;
			case 2: // Remote bottomleft
				music.decVolume(20);
				break;
			case 3: // Remote topright, musiikin pysäytys
				music.stopPlaying();
				break;
			case 4: // Remote bottomright, saldo
				coinCount = coin.getCoins();
				screen.showSaldo(coinCount);
				break;
			case 5: // LEFT-Button
				if (music.isPlaying()) {
					break;
				} else {
					discPlayer.lastSong();
					music.changeSong(discPlayer.getSongID());
					creditCount = coin.getCredits();
					songArtist = music.getArtistName();
					songName = music.getSongName();
					lastPage = 1;
					screen.songSelect(songArtist, songName);
					screen.creditAmount(creditCount);
					break;
				}

			case 6: // RIGHT-Button
				if (music.isPlaying()) {
					break;
				} else {
					discPlayer.nextSong();
					music.changeSong(discPlayer.getSongID());
					creditCount = coin.getCredits();
					songArtist = music.getArtistName();
					songName = music.getSongName();
					lastPage = 1;
					screen.songSelect(songArtist, songName);
					screen.creditAmount(creditCount);
					break;
				}

			case 7: // ENTER-button
				if (music.isPlaying()) {
					break;
				} else {
					if (coin.useCredits()) {
						music.startPlaying();
						creditCount = coin.getCredits();
						lastPage = 2;
						screen.songPlaying(songArtist, songName);
						screen.creditAmount(creditCount);
					} else {
						screen.noCredits();
					}
				}
				break;
			case 8:
				start = false;
				break;
			case 9: // Remotedrive topleft
				// driver.driveleftmotor
				driver.turnLeft();
				break;
			case 10: // Remotedrive bottomleft
				// driver.driverightmotor
				driver.backward();
				break;
			case 11: // Remotedrive topright
				// driver.drive JOTAIN
				driver.turnRight();
				break;
			case 12: // Remotedrive bottomright
				// driver.drive JOTAIN
				driver.stop();
				break;
			case 13: // Remotedrive topleft + topright
				// driver.drive ETEENPÄIN?
				driver.forward();
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
