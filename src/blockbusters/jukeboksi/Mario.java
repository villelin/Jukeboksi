/**
 * M��ritt�� "Super Mario Bros - Theme" kappaleen.
 * @author Ville Linde
 * @version 1.0
 */

package blockbusters.jukeboksi;

public class Mario extends MusicTrack {
	private static final int BEAT = 80;	// biitin pituus = 80 ms
	
	public static int[][] notedata =
	{
		{E6,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{E6,	BEAT-5,		BEAT*4},
		{C6,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*8},
		{G5,	BEAT-5,		BEAT*8},
		{C6,	BEAT-5,		BEAT*6},
		{G5,	BEAT-5,		BEAT*6},
		{E5,	BEAT-5,		BEAT*6},
		{A5,	BEAT-5,		BEAT*4},
		{B5,	BEAT-5,		BEAT*4},
		{AS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*4},
		{G5,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*3},
		{G6,	BEAT-5,		BEAT*3},
		{A6,	BEAT-5,		BEAT*4},
		{F6,	BEAT-5,		BEAT*2},
		{G6,	BEAT-5,		BEAT*4},
		{E6,	BEAT-5,		BEAT*4},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{B5,	BEAT-5,		BEAT*6},
		{C6,	BEAT-5,		BEAT*6},
		{G5,	BEAT-5,		BEAT*6},
		{E5,	BEAT-5,		BEAT*6},
		{A5,	BEAT-5,		BEAT*4},
		{B5,	BEAT-5,		BEAT*4},
		{AS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*4},
		{G5,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*3},
		{G6,	BEAT-5,		BEAT*3},
		{A6,	BEAT-5,		BEAT*4},
		{F6,	BEAT-5,		BEAT*2},
		{G6,	BEAT-5,		BEAT*4},
		{E6,	BEAT-5,		BEAT*4},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{B5,	BEAT-5,		BEAT*6},
		{C4,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{FS6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{DS6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*2},
		{F4,	BEAT-5,		BEAT*2},
		{GS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{C4,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{FS6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{DS6,	BEAT-5,		BEAT*2},
		{G4,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{C7,	BEAT-5,		BEAT*4},
		{C7,	BEAT-5,		BEAT*2},
		{C7,	BEAT-5,		BEAT*4},
		{G4,	BEAT-5,		BEAT*4},
		{C4,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{FS6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{DS6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*2},
		{F4,	BEAT-5,		BEAT*2},
		{GS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{C4,	BEAT-5,		BEAT*4},
		{DS6,	BEAT-5,		BEAT*6},
		{D6,	BEAT-5,		BEAT*6},
		{C6,	BEAT-5,		BEAT*6},
		{G4,	BEAT-5,		BEAT*2},
		{G4,	BEAT-5,		BEAT*4},
		{C4,	BEAT-5,		BEAT*4},
		{C4,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{FS6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{DS6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*2},
		{F4,	BEAT-5,		BEAT*2},
		{GS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{C4,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{FS6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{DS6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{GS5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{C5,	BEAT-5,		BEAT*2},
		{A5,	BEAT-5,		BEAT*2},
		{C6,	BEAT-5,		BEAT*2},
		{D6,	BEAT-5,		BEAT*2},
		{C4,	BEAT-5,		BEAT*4},
		{G6,	BEAT-5,		BEAT*2},
		{FS6,	BEAT-5,		BEAT*2},
		{F6,	BEAT-5,		BEAT*2},
		{DS6,	BEAT-5,		BEAT*2},
		{G4,	BEAT-5,		BEAT*2},
		{E6,	BEAT-5,		BEAT*4},
		{C7,	BEAT-5,		BEAT*4},
		{C7,	BEAT-5,		BEAT*2},
		{C7,	BEAT-5,		BEAT*8},		
	};
	
	public Mario()
	{
		song_name = "Theme";
		artist_name = "Super Mario Bros";
		num_loops = 1;
		notes = notedata;
	}
}
