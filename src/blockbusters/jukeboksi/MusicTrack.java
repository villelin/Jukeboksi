package blockbusters.jukeboksi;

public abstract class MusicTrack
{
	protected static final int AS3 = 233;
	protected static final int C4 = 261;
	protected static final int D4 = 293;
	protected static final int E4 = 329;
	protected static final int F4 = 349;
	protected static final int G4 = 392;
	protected static final int A4 = 440;
	protected static final int B4 = 493;
	protected static final int C5 = 523;
	protected static final int DS5 = 622;
	protected static final int F5 = 698;
	protected static final int FS5 = 739;
	protected static final int G5 = 784;
	protected static final int GS5 = 830;
	protected static final int A5 = 880;
	protected static final int AS5 = 932;
	protected static final int B5 = 987;
	protected static final int C6 = 1046;
	protected static final int CS6 = 1108;
	protected static final int D6 = 1174;
	protected static final int DS6 = 1244;
	protected static final int E6 = 1318;
	protected static final int F6 = 1397;
	protected static final int FS6 = 1480;
	protected static final int G6 = 1567;
	protected static final int GS6 = 1661;
	protected static final int A6 = 1760;
	protected static final int AS6 = 1864;
	
	protected int current_note;
	protected String song_name;
	protected String artist_name;
	
	public MusicTrack()
	{
		current_note = 0;
		song_name = "Unknown Track";
		artist_name = "Unknown Artist";
	}
	
	public abstract int[] getNote();
	
	public void advance()
	{
		current_note++;
	}
	
	public void restart()
	{
		current_note = 0;
	}
	
	public String getSongName()
	{
		return song_name;
	}
	
	public String getArtistName()
	{
		return artist_name;
	}
};
