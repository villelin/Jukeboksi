package blockbusters.jukeboksi;

import lejos.hardware.Button;
import lejos.hardware.Sound;

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
	
	public void startPlaying()
	{
		playing = true;
		current_song.restart();
	}
	
	public boolean isPlaying()
	{
		return playing;
	}
	
	public void stopPlaying()
	{
		playing = false;
		Button.LEDPattern(0);
	}
	
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
	
	public void incVolume()
	{
		volume += 10;
		if (volume > 100)
			volume = 100;
		Sound.setVolume(volume);
	}
	
	public void decVolume()
	{
		volume -= 10;
		if (volume < 0)
			volume = 0;
		Sound.setVolume(volume);
	}
	
	public String getSongName()
	{
		if (current_song != null)
			return current_song.getSongName();
		else
			return "";
	}
	
	public String getArtistName()
	{
		if (current_song != null)
			return current_song.getArtistName();
		else
			return "";
	}
	
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
