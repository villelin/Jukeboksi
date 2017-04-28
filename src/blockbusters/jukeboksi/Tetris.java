package blockbusters.jukeboksi;

public class Tetris extends MusicTrack
{
	private static final int BEAT = 85;		// biitin pituus = 85 ms
	
	public static int[][] notedata = 
	{
		{E6,	BEAT-5,		BEAT*4},
		{B5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT},
		{D6,	BEAT-5,		BEAT},
		{C6,	BEAT-5,		BEAT*2},
		{B5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*4},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{D6,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{B5,	BEAT-5,		BEAT*4},
		{B5,	BEAT-5,		BEAT},
		{B5,	BEAT-5,		BEAT},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*4},
		{E6,	BEAT-5,		BEAT*4},
		{C6,	BEAT-5,		BEAT*4},
		{A5,	BEAT-5,		BEAT*4},
		{A5,	BEAT-5,		BEAT*8},
		{D6,	BEAT-5,		BEAT*4},
		{D6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{A6,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{E6,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{D6,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{B5,	BEAT-5,		BEAT*4},
		{B5,	BEAT-5,		BEAT},
		{B5,	BEAT-5,		BEAT},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*4},
		{E6,	BEAT-5,		BEAT*4},
		{C6,	BEAT-5,		BEAT*4},
		{A5,	BEAT-5,		BEAT*4},
		{A5,	BEAT-5,		BEAT*8},
	};
	
	public int[] getNote()
	{
		return notedata[current_note];
	}
}
