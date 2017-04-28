package blockbusters.jukeboksi;

public abstract class MusicTrack
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
	
	protected int current_note;
	
	public MusicTrack()
	{
		current_note = 0;
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
};
