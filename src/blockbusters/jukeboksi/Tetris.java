package blockbusters.jukeboksi;

/**
 * Määrittää "Korobeiniki (Russian Folk Song)" kappaleen.
 * @author Ville Linde
 * @version 1.0
 */

public class Tetris extends MusicTrack
{
	private static final int BEAT = 85;		// biitin pituus = 85 ms
	
	private static int[][] notedata = 
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
	
	public Tetris()
	{
		song_name = "Korobeiniki";
		artist_name = "(Russian Folk Song)";
		num_loops = 2;
		notes = notedata;
	}
}
