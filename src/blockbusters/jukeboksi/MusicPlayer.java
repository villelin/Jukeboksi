package blockbusters.jukeboksi;

import lejos.hardware.Button;
import lejos.hardware.Sound;

/**
 * MusicPlayer soittaa MusicTrack-luokkien määrittelemää nuottidataa.
 * Luokka pyörii omassa säikeessään.
 * 
 * @author Ville Linde
 * @version 1.0
 */

public class MusicPlayer extends Thread
{
	private MusicTrack[] songs;
	private MusicTrack current_song;
	
	private boolean playing;
	private int volume;
	
	public MusicPlayer()
	{
		songs = new MusicTrack[6];
		songs[0] = new Mario();
		songs[1] = new Zelda();
		songs[2] = new Tetris();
		songs[3] = new JohnCena();
		songs[4] = new EpicSax();
		songs[5] = new Trololol();
		
		current_song = songs[0];
		playing = false;
		volume = 10;
	}
	
	/**
	 *  Aloittaa kappaleen soittamisen
	 */
	public void startPlaying()
	{
		playing = true;
		current_song.restart();
	}
	
	/**
	 * Kertoo onko kappale soimassa
	 * 
	 * @return true, jos kappale soi, muuten false.
	 */
	public boolean isPlaying()
	{
		return playing;
	}
	
	/**
	 * Lopettaa kappaleen soittamisen
	 */
	public void stopPlaying()
	{
		playing = false;
		Button.LEDPattern(0);
	}
	
	/**
	 * Vaihtaa soitettavan kappaleen haluttuun kappaleeseen
	 * 
	 * @param song Soitettavan kappaleen indeksi
	 */
	public void changeSong(int song)
	{
		if (song >= 0 && song < songs.length)
		{
			current_song = songs[song];
			current_song.restart();
			playing = false;
			Button.LEDPattern(0);
		}
	}
	
	/**
	 * Nostaa äänenvoimakkuutta. Jos voimakkuus on jo 100, voimakkuus ei muutu.
	 */
	public void incVolume(int amount)
	{
		volume += amount;
		if (volume > 100)
			volume = 100;
		Sound.setVolume(volume);
	}
	
	/**
	 * Pienentää äänenvoimakkuutta. Jos voimakkuus on 0, voimakkuus ei muutu. 
	 */
	public void decVolume(int amount)
	{
		volume -= amount;
		if (volume < 0)
			volume = 0;
		Sound.setVolume(volume);
	}
	
	/**
	 * Palauttaa tällä hetkellä valitun kappaleen nimen
	 * 
	 * @return Kappaleen nimi
	 */
	public String getSongName()
	{
		if (current_song != null)
			return current_song.getSongName();
		else
			return "";
	}
	
	/**
	 * Palauttaa tällä hetkellä valitun kappaleen esittäjän
	 * 
	 * @return Kappaleen esittäjä
	 */
	public String getArtistName()
	{
		if (current_song != null)
			return current_song.getArtistName();
		else
			return "";
	}
	
	/**
	 * Suoritussilmukka, toistaa musiikkia.
	 */
	public void run()
	{
		Sound.setVolume(volume);
		
		int led = 0;
		
		while (true)
		{
			try {
				if (playing)
				{
					int[] notedata = current_song.getNote();
				
					int freq = notedata[0];
					int note_duration = notedata[1];
					int note_plus_pause = notedata[2];
	
					Sound.playNote(Sound.XYLOPHONE, freq, note_duration);
				
					Sound.pause(note_plus_pause - note_duration);
				
					current_song.advance();
					
					Button.LEDPattern((led % 3) + 1);
					led++;
					
					if (current_song.isAtEnd())
					{
						stopPlaying();
					}
				}
				sleep(1);
			}
			catch (InterruptedException e)
			{
				return;
			}
		}
	}
}
