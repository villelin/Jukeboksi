package blockbusters.jukeboksi;

public class Trololol extends MusicTrack
{
	private static final int BEAT = 125;	// biitin pituus = 125 ms
	
	public static int[][] notedata =
	{
		{E4,	BEAT-5,		BEAT},
		{G4,	BEAT-5,		BEAT},
		{A4,	BEAT-5,		BEAT},
		{C5,	BEAT-5,		BEAT},
		{B4,	(BEAT*2)-5,	BEAT*2},
		{B4,	BEAT-5,		BEAT},
		{G4,	BEAT-5,		BEAT},
		{A4,	(BEAT*2)-5,	BEAT*2},
		{A4,	BEAT-5,		BEAT},
		{E4,	BEAT-5,		BEAT},
		{G4,	(BEAT*4)-5,	BEAT*4},
		{C4,	BEAT-5,		BEAT},
		{D4,	BEAT-5,		BEAT},
		{E4,	BEAT-5,		BEAT},
		{F4,	BEAT-5,		BEAT},
		{E4,	(BEAT*4)-5,	BEAT*12},
		{E4,	BEAT-5,		BEAT},
		{G4,	BEAT-5,		BEAT},
		{A4,	BEAT-5,		BEAT},
		{C5,	BEAT-5,		BEAT},
		{B4,	(BEAT*2)-5,	BEAT*2},
		{B4,	BEAT-5,		BEAT},
		{G4,	BEAT-5,		BEAT},
		{A4,	(BEAT*2)-5,	BEAT*2},
		{A4,	BEAT-5,		BEAT},
		{E4,	BEAT-5,		BEAT},
		{G4,	(BEAT*4)-5,	BEAT*4},
		{E4,	BEAT-5,		BEAT},
		{G4,	BEAT-5,		BEAT},
		{A4,	BEAT-5,		BEAT},
		{B4,	BEAT-5,		BEAT},
		{C5,	(BEAT*4)-5,	BEAT*12},
	};
	
	public Trololol()
	{
		song_name = "I am very glad, as I'm\nfinally returning back home";
		artist_name = "Eduard Khil";
		num_loops = 3;
		notes = notedata;
	}
}
