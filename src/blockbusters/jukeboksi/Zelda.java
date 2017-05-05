/**
 * M‰‰ritt‰‰ "The Legend of Zelda - Overworld" kappaleen.
 * @author Ville Linde
 * @version 1.0
 */

package blockbusters.jukeboksi;

public class Zelda extends MusicTrack
{
	private static final int BEAT = 125;	// biitin pituus = 125 ms
	private static final int BEAT_ONEHALF = (int)(BEAT * 1.5);
	private static final int BEAT_NINEHALF = (int)(BEAT * 9.5);
	
	public static int[][] notedata =
	{
		{ F5,		BEAT-5,			BEAT },
		{ F5,		BEAT-5,			BEAT },
		{ F5,		BEAT-5,			BEAT*2 },
		{ F5,		BEAT-5,			BEAT },
		{ F5,		BEAT-5,			BEAT },
		{ F5,		BEAT-5,			BEAT*2 },
		{ F5,		BEAT-5,			BEAT },
		{ F5,		BEAT-5,			BEAT },
		{ F5,		BEAT-5,			BEAT*2 },
		{ F5,		BEAT-5,			BEAT*2 },
		
		{ AS5,		(BEAT*3)-5,		(BEAT*4) },
		{ F5,		(BEAT*6)-5,		(BEAT*7) },
		{ AS5,		BEAT-5,			BEAT },
		{ AS5,		BEAT-5,			BEAT },
		{ C6,		BEAT-5,			BEAT },
		{ D6,		BEAT-5,			BEAT },
		{ DS6,		BEAT-5,			BEAT },
		{ F6,		(BEAT*8)-5,		(BEAT*12) },
		{ F6,		BEAT-5,			BEAT_ONEHALF },
		{ FS6,		BEAT-5,			BEAT_ONEHALF },
		{ GS6,		BEAT-5,			BEAT_ONEHALF },
		{ AS6,		(BEAT*9)-5,		BEAT_NINEHALF },
		{ AS6,		BEAT-5,			BEAT_ONEHALF },
		{ AS6,		BEAT-5,			BEAT_ONEHALF },
		{ AS6,		BEAT-5,			BEAT_ONEHALF },
		{ GS6,		BEAT-5,			BEAT_ONEHALF },
		{ FS6,		BEAT-5,			BEAT_ONEHALF },
		{ GS6,		BEAT-5,			BEAT*3 },
		{ FS6,		BEAT-5,			BEAT_ONEHALF },
		{ F6,		(BEAT*8)-5,		BEAT*8 },
		{ F6,		(BEAT*4)-5,		BEAT*4 },
		{ DS6,		(BEAT*2)-5,		BEAT*2 },
		{ DS6,		BEAT-5,			BEAT },
		{ F6,		BEAT-5,			BEAT },
		{ FS6,		(BEAT*8)-5,		(BEAT*8) },
		{ F6,		(BEAT*2)-5,		BEAT*2 },
		{ DS6,		(BEAT*2)-5,		BEAT*2 },
		{ CS6,		(BEAT*2)-5,		BEAT*2 },
		{ CS6,		BEAT-5,			BEAT },
		{ DS6,		BEAT-5,			BEAT },
		{ F6,		(BEAT*8)-5,		BEAT*8 },
		{ DS6,		(BEAT*2)-5,		BEAT*2 },
		{ CS6,		(BEAT*2)-5,		BEAT*2 },
		{ C6,		(BEAT*2)-5,		BEAT*2 },
		{ C6,		BEAT-5,			BEAT },
		{ D6,		BEAT-5,			BEAT },
		{ E6,		(BEAT*8)-5,		(BEAT*8) },
		{ G6,		(BEAT*4)-5,		(BEAT*4) },
		{ F6,		BEAT-5,			BEAT },
	};
	
	public Zelda()
	{
		song_name = "Overworld";
		artist_name = "Legend of Zelda";
		num_loops = 2;
		notes = notedata;
	}
}
