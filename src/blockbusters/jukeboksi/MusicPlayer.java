package blockbusters.jukeboksi;


import lejos.hardware.Sound;

public class MusicPlayer extends Thread
{
	private MusicTrack[] music;
	
	private boolean running;
	private int volume;
	
	private int musicnum;
	private int nextmusic;
	
	public void stop_playing()
	{
		running = false;
	}
	
	public void change_music(int music)
	{
		if (music != musicnum)
		{
			nextmusic = music;
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
	
	public void run()
	{
		music = new MusicTrack[5];
		music[0] = new Zelda();
		music[1] = new Tetris();
		music[2] = new JohnCena();
		music[3] = new EpicSax();
		music[4] = new Trololol();
		
		MusicTrack current_music = null;
		
		volume = 10;
		Sound.setVolume(10);
		
		running = true;
		
		musicnum = 0;
		nextmusic = 0;
		
		current_music = music[0];
		
		while (running)
		{
			if (nextmusic != musicnum)
			{
				if (nextmusic >= 0 && nextmusic <= 4)
				{
					current_music = music[nextmusic];
					current_music.restart();
					musicnum = nextmusic;
				}
			}
			
			int[] notedata = current_music.getNote();
			
			int freq = notedata[0];
			int note_duration = notedata[1];
			int note_plus_pause = notedata[2];
			
			//Sound.playTone(freq, note_duration);
			Sound.playNote(Sound.XYLOPHONE, freq, note_duration);
			
			Sound.pause(note_plus_pause - note_duration);
			
			current_music.advance();
		}
	}
}
