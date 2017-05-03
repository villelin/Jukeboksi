package blockbusters.jukeboksi;

public class JohnCena extends MusicTrack
{
	private static final int BEAT = 170;	// biitin pituus = 170 ms
	
	public static int[][] notedata =
	{
		{D4,	BEAT-5,		BEAT*2},
		{G5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT},
		{F5,	BEAT-5,		BEAT*2},
		{G5,	BEAT-5,		BEAT*3},
		{AS3,	BEAT-5,		BEAT},
		{D4,	BEAT-5,		BEAT*2},
		{C4,	BEAT-5,		BEAT*3},
			
		{D4,	BEAT-5,		BEAT*2},
		{AS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT},
		{F5,	BEAT-5,		BEAT*2},
		{G5,	BEAT-5,		BEAT*3},
		{AS3,	BEAT-5,		BEAT},
		{D4,	BEAT-5,		BEAT*2},
		{C4,	BEAT-5,		BEAT*3},
	};
	
	public JohnCena()
	{
		song_name = "The time is now";
		artist_name = "John Cena";
		num_loops = 8;
		notes = notedata;
	}
}
