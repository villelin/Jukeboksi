package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * Jukeboksi toimii viestinv√§litt√§j√§n√§ ja yhdist√§√§ muut luokat.
 * 
 * @author Joona Ikonen
 * @version 1.0
 */

public class JukeBoksi {

	/**
	 * IR-sensori kaukos‰‰timen lukemista varten.
	 */
	private EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S3);
	/**
	 * V‰risensori levyn lukemista varten.
	 */
	private EV3ColorSensor discReader = new EV3ColorSensor(SensorPort.S4);
	/**
	 * V‰risensori kolikontunnistamiseen.
	 */
	private EV3ColorSensor coinSensor = new EV3ColorSensor(SensorPort.S2);
	/**
	 * Vasen ajomoottori.
	 */
	private EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	/**
	 * Oikea ajomoottori.
	 */
	private EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	/**
	 * Levy‰ pyˆritt‰v‰ moottori.
	 */
	private EV3MediumRegulatedMotor discMotor = new EV3MediumRegulatedMotor(MotorPort.D);

	/**
	 * Kolikoiden m‰‰r‰ jukeboksissa.
	 */
	private int coinCount;
	/**
	 * Krediittien m‰‰r‰ jukeboksissa.
	 */
	private int creditCount;
	/**
	 * Kappaleen nimi.
	 */
	private String songName;
	/**
	 * Kappaleen artisti.
	 */
	private String songArtist;

	/**
	 * Screen-luokan olio n‰ytˆn hallintaa varten.
	 */
	private Screen screen;
	/**
	 * Remote-luokan olio k‰ytt‰j‰n komentoja varten.
	 */
	private Remote remote;
	/**
	 * MusicPlayer-luokan olio musiikintoistoa varten.
	 */
	private MusicPlayer music;
	/**
	 * CoinCounter-luokan olio kolikko- ja krediittilaskentaan.
	 */
	private CoinCounter coin;
	/**
	 * DiscReader-luokan olio levyn pyˆritt‰mist‰ varten.
	 */
	private DiscReader discPlayer;
	/**
	 * Drive-luokan olio ajomoottoreiden hallintaa varten.
	 */
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
	 * Jukeboksin syd√§n. K√§sittelee saapuvat komennot ja hallitsee muita luokkia
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
			if (creditChange != creditCount) { //onko krediittitilanne muuttunut
				creditChange = creditCount;

				if (lastPage == 1) { //Jos kappale ei ole soimassa
					screen.songSelect(songArtist, songName);
					screen.creditAmount(creditCount);
				} else {				// // Jos kappale soi
					screen.songPlaying(songArtist, songName);
					screen.creditAmount(creditCount);
				}
			}
			if (!music.isPlaying()){ // palataan biisinvalintaruutuun, jos musiikki ei soi
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
			case 3: // Remote topright, musiikin pys√§ytys
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
				driver.turnLeft();
				break;
			case 10: // Remotedrive bottomleft
				driver.backward();
				break;
			case 11: // Remotedrive topright
				driver.turnRight();
				break;
			case 12: // Remotedrive bottomright
				driver.stop();
				break;
			case 13: // Remotedrive topleft + topright
				driver.forward();
				break;
			case 14: // Remotedrive bottomleft + bottomright
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
