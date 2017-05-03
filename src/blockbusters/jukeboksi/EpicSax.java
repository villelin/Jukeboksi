package blockbusters.jukeboksi;

public class EpicSax extends MusicTrack
{
	private static final int BEAT = 125;	// biitin pituus = 125 ms
	
	public static int[][] notedata =
	{
		{ AS5,	(BEAT*4)-5,	BEAT*8 },
		{ AS5,	(BEAT*2)-5,	BEAT*2 },
		{ AS5,	BEAT-5,		BEAT },
		{ AS5,	BEAT-5,		BEAT },
		{ GS5,	BEAT-5,		BEAT*2 },
		{ AS5,	(BEAT*2)-5,	BEAT*2 },
		{ AS5,	(BEAT*4)-5,	BEAT*8 },
		{ AS5,	(BEAT*2)-5,	BEAT*2 },
		{ AS5,	BEAT-5,		BEAT, },
		{ AS5,	BEAT-5,		BEAT, },
		{ GS5,	BEAT-5,		BEAT*2 },
		{ AS5,	(BEAT*2)-5,	BEAT*2 },
		{ AS5,	(BEAT*4)-5,	BEAT*6 },
		{ CS6,	(BEAT*4)-5,	BEAT*4 },
		{ AS5,	(BEAT*4)-5,	BEAT*4 },
		{ GS5,	(BEAT*4)-5,	BEAT*4 },
		{ FS5,	(BEAT*4)-5,	BEAT*4	},
		{ DS5,	(BEAT*2)-5,	BEAT*2 },
		{ DS5,	(BEAT*2)-5,	BEAT*2 },
		{ F5,	(BEAT*2)-5,	BEAT*2 },
		{ FS5,	(BEAT*2)-5,	BEAT*2 },
		{ DS5,	(BEAT*2)-5,	BEAT*2 },
	};
	
	public EpicSax()
	{
		song_name = "Epic Sax Guy";
		artist_name = "Sergey Stepanov";
		num_loops = 4;
		notes = notedata;
	}
}
