package blockbusters.jukeboksi;


import lejos.hardware.Sound;

public class MusicPlayer extends Thread
{
	private static final int AS3 = 233;
	private static final int C4 = 261;
	private static final int D4 = 293;
	private static final int E4 = 329;
	private static final int F4 = 349;
	private static final int G4 = 392;
	private static final int A4 = 440;
	private static final int B4 = 493;
	private static final int C5 = 523;
	private static final int DS5 = 622;
	private static final int F5 = 698;
	private static final int FS5 = 739;
	private static final int G5 = 784;
	private static final int GS5 = 830;
	private static final int A5 = 880;
	private static final int AS5 = 932;
	private static final int B5 = 987;
	private static final int C6 = 1046;
	private static final int CS6 = 1108;
	private static final int D6 = 1174;
	private static final int E6 = 1318;
	private static final int F6 = 1397;
	private static final int G6 = 1567;
	private static final int A6 = 1760;
	
	private static final int SAXBEAT = 125;
	private static final int CENABEAT = 170;
	private static final int TETRBEAT = 85;
	private static final int TROLBEAT = 125;
	
	public static int[][] trol =
	{
		{E4,	TROLBEAT-5,		TROLBEAT},
		{G4,	TROLBEAT-5,		TROLBEAT},
		{A4,	TROLBEAT-5,		TROLBEAT},
		{C5,	TROLBEAT-5,		TROLBEAT},
		{B4,	(TROLBEAT*2)-5,	TROLBEAT*2},
		{B4,	TROLBEAT-5,		TROLBEAT},
		{G4,	TROLBEAT-5,		TROLBEAT},
		{A4,	(TROLBEAT*2)-5,	TROLBEAT*2},
		{A4,	TROLBEAT-5,		TROLBEAT},
		{E4,	TROLBEAT-5,		TROLBEAT},
		{G4,	(TROLBEAT*4)-5,	TROLBEAT*4},
		{C4,	TROLBEAT-5,		TROLBEAT},
		{D4,	TROLBEAT-5,		TROLBEAT},
		{E4,	TROLBEAT-5,		TROLBEAT},
		{F4,	TROLBEAT-5,		TROLBEAT},
		{E4,	(TROLBEAT*4)-5,	TROLBEAT*12},
		{E4,	TROLBEAT-5,		TROLBEAT},
		{G4,	TROLBEAT-5,		TROLBEAT},
		{A4,	TROLBEAT-5,		TROLBEAT},
		{C5,	TROLBEAT-5,		TROLBEAT},
		{B4,	(TROLBEAT*2)-5,	TROLBEAT*2},
		{B4,	TROLBEAT-5,		TROLBEAT},
		{G4,	TROLBEAT-5,		TROLBEAT},
		{A4,	(TROLBEAT*2)-5,	TROLBEAT*2},
		{A4,	TROLBEAT-5,		TROLBEAT},
		{E4,	TROLBEAT-5,		TROLBEAT},
		{G4,	(TROLBEAT*4)-5,	TROLBEAT*4},
		{E4,	TROLBEAT-5,		TROLBEAT},
		{G4,	TROLBEAT-5,		TROLBEAT},
		{A4,	TROLBEAT-5,		TROLBEAT},
		{B4,	TROLBEAT-5,		TROLBEAT},
		{C5,	(TROLBEAT*4)-5,	TROLBEAT*12},
	};
	
	public static int[][] tetris = 
	{
		{E6,	TETRBEAT-5,		TETRBEAT*4},
		{B5,	TETRBEAT-5,		TETRBEAT*2},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{D6,	TETRBEAT-5,		TETRBEAT*2},
		{E6,	TETRBEAT-5,		TETRBEAT},
		{D6,	TETRBEAT-5,		TETRBEAT},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{B5,	TETRBEAT-5,		TETRBEAT*2},
		{A5,	TETRBEAT-5,		TETRBEAT*4},
		{A5,	TETRBEAT-5,		TETRBEAT*2},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{E6,	TETRBEAT-5,		TETRBEAT*4},
		{D6,	TETRBEAT-5,		TETRBEAT*2},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{B5,	TETRBEAT-5,		TETRBEAT*4},
		{B5,	TETRBEAT-5,		TETRBEAT},
		{B5,	TETRBEAT-5,		TETRBEAT},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{D6,	TETRBEAT-5,		TETRBEAT*4},
		{E6,	TETRBEAT-5,		TETRBEAT*4},
		{C6,	TETRBEAT-5,		TETRBEAT*4},
		{A5,	TETRBEAT-5,		TETRBEAT*4},
		{A5,	TETRBEAT-5,		TETRBEAT*8},
		{D6,	TETRBEAT-5,		TETRBEAT*4},
		{D6,	TETRBEAT-5,		TETRBEAT*2},
		{F6,	TETRBEAT-5,		TETRBEAT*2},
		{A6,	TETRBEAT-5,		TETRBEAT*4},
		{G6,	TETRBEAT-5,		TETRBEAT*2},
		{F6,	TETRBEAT-5,		TETRBEAT*2},
		{E6,	TETRBEAT-5,		TETRBEAT*4},
		{E6,	TETRBEAT-5,		TETRBEAT*2},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{E6,	TETRBEAT-5,		TETRBEAT*4},
		{D6,	TETRBEAT-5,		TETRBEAT*2},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{B5,	TETRBEAT-5,		TETRBEAT*4},
		{B5,	TETRBEAT-5,		TETRBEAT},
		{B5,	TETRBEAT-5,		TETRBEAT},
		{C6,	TETRBEAT-5,		TETRBEAT*2},
		{D6,	TETRBEAT-5,		TETRBEAT*4},
		{E6,	TETRBEAT-5,		TETRBEAT*4},
		{C6,	TETRBEAT-5,		TETRBEAT*4},
		{A5,	TETRBEAT-5,		TETRBEAT*4},
		{A5,	TETRBEAT-5,		TETRBEAT*8},
	};
	
	public static int[][] cena =
	{
		{D4,	CENABEAT-5,		CENABEAT*2},
		{G5,	CENABEAT-5,		CENABEAT*2},
		{A5,	CENABEAT-5,		CENABEAT},
		{F5,	CENABEAT-5,		CENABEAT*2},
		{G5,	CENABEAT-5,		CENABEAT*3},
		{AS3,	CENABEAT-5,		CENABEAT},
		{D4,	CENABEAT-5,		CENABEAT*2},
		{C4,	CENABEAT-5,		CENABEAT*3},
		
		{D4,	CENABEAT-5,		CENABEAT*2},
		{AS5,	CENABEAT-5,		CENABEAT*2},
		{A5,	CENABEAT-5,		CENABEAT},
		{F5,	CENABEAT-5,		CENABEAT*2},
		{G5,	CENABEAT-5,		CENABEAT*3},
		{AS3,	CENABEAT-5,		CENABEAT},
		{D4,	CENABEAT-5,		CENABEAT*2},
		{C4,	CENABEAT-5,		CENABEAT*3},
	};
	
	public static int[][] epicsax =
	{
		{ AS5,	(SAXBEAT*4)-5,	SAXBEAT*8 },		// A#6		1/16 + 1/16
		{ AS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// A#6		1/32
		{ AS5,	SAXBEAT-5,		SAXBEAT },			// A#6		1/64
		{ AS5,	SAXBEAT-5,		SAXBEAT },			// A#6		1/64
		{ GS5,	SAXBEAT-5,		SAXBEAT*2 },		// G#6		1/64
		{ AS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// A#6		1/32
		{ AS5,	(SAXBEAT*4)-5,	SAXBEAT*8 },		// A#6		1/16
		{ AS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// A#6		1/32
		{ AS5,	SAXBEAT-5,		SAXBEAT, },			// A#6		1/64
		{ AS5,	SAXBEAT-5,		SAXBEAT, },			// A#6		1/64
		{ GS5,	SAXBEAT-5,		SAXBEAT*2 },		// G#6		1/64
		{ AS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// A#6		1/32
		{ AS5,	(SAXBEAT*4)-5,	SAXBEAT*6 },		// A#6		1/16 + 1/32
		{ CS6,	(SAXBEAT*4)-5,	SAXBEAT*4 },		// C#7		1/16
		{ AS5,	(SAXBEAT*4)-5,	SAXBEAT*4 },		// A#6		1/16
		{ GS5,	(SAXBEAT*4)-5,	SAXBEAT*4 },		// G#6		1/16
		{ FS5,	(SAXBEAT*4)-5,	SAXBEAT*4	},		// F#6		1/16
		{ DS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// D#6		1/32
		{ DS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// D#6		1/32
		{ F5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// F6		1/32
		{ FS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// F#6		1/32
		{ DS5,	(SAXBEAT*2)-5,	SAXBEAT*2 },		// D#6		1/32
	};
	
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
		if (volume < 10)
			volume = 10;
		Sound.setVolume(volume);
	}
	
	public void run()
	{
		volume = 10;
		Sound.setVolume(10);
		
		int index = 0;
		running = true;
		
		musicnum = 0;
		nextmusic = 0;
		
		int[][] musicdata = cena;
		
		while (running)
		{
			if (nextmusic != musicnum)
			{
				switch (nextmusic)
				{
				case 0:
					musicdata = cena;
					break;
				case 1:
					musicdata = epicsax;
					break;
				case 2:
					musicdata = tetris;
					break;
				case 3:
					musicdata = trol;
					break;
				}
				musicnum = nextmusic;
				index = 0;
			}
			
			
			int i = index % musicdata.length;
			int freq = musicdata[i][0];
			int note_duration = musicdata[i][1];
			int note_plus_pause = musicdata[i][2];
			
			//Sound.playTone(freq, note_duration);
			Sound.playNote(Sound.XYLOPHONE, freq, note_duration);
			
			Sound.pause(note_plus_pause - note_duration);
			index++;
		}
	}
}
