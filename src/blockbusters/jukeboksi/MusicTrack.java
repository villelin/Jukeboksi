package blockbusters.jukeboksi;

/**
 * MusicTrack on abstrakti luokka, joka määrittää musiikkikappaleen.
 * 
 * @author Ville Linde
 * @version 1.0
 */

public abstract class MusicTrack
{
	/**
	 * Nuottien äänentaajuuksien vakiot
	 */
	protected static final int C3 = 131;
	protected static final int CS3 = 139;
	protected static final int D3 = 147;
	protected static final int DS3 = 156;
	protected static final int E3 = 165;
	protected static final int F3 = 175;
	protected static final int FS3 = 185;
	protected static final int G3 = 196;
	protected static final int GS3 = 208;
	protected static final int A3 = 220;
	protected static final int AS3 = 233;
	protected static final int B3 = 247;
	protected static final int C4 = 261;
	protected static final int CS4 = 277;
	protected static final int D4 = 293;
	protected static final int DS4 = 311;
	protected static final int E4 = 329;
	protected static final int F4 = 349;
	protected static final int FS4 = 370;
	protected static final int G4 = 392;
	protected static final int GS4 = 415;
	protected static final int A4 = 440;
	protected static final int AS4 = 466;
	protected static final int B4 = 493;
	protected static final int C5 = 523;
	protected static final int CS5 = 554;
	protected static final int D5 = 587;
	protected static final int DS5 = 622;
	protected static final int E5 = 659;
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
	protected static final int C7 = 2093;
	
	/**
	 * Seuraavaksi luettava nuotti
	 */
	protected int current_note;
	
	/**
	 * Musiikkikappaleen nimi
	 */
	protected String song_name;
	
	/**
	 * Musiikkikappaleen esittäjä
	 */
	protected String artist_name;
	
	/**
	 * Montako kertaa musiikkikappale toistetaan
	 */
	protected int num_loops;
	
	/**
	 * Taulukko nuottitietoihin
	 */
	protected int[][] notes;
	
	public MusicTrack()
	{
		current_note = 0;
		song_name = "Unknown Track";
		artist_name = "Unknown Artist";
		num_loops = 1;
		notes = null;
	}
	
	/**
	 * Palauttaa soitettavan nuotin tiedot.
	 * 
	 * @return Nuotin tiedot taulukossa. Indeksi 0: nuotin korkeus. Indeksi 1: Nuotin pituus (millisekuntia). Indeksi 2: Aika seuraavaan nuottiin (millisekuntia).
	 */
	public int[] getNote()
	{
		return notes[current_note % notes.length];
	}
	
	/**
	 * Siirry seuraavaan nuottiin.
	 */
	public void advance()
	{
		current_note++;
	}
	
	/**
	 * Aloittaa kappaleen alusta.
	 */
	public void restart()
	{
		current_note = 0;
	}
	
	/**
	 * Kertoo onko kappaleen soitto lopussa.
	 * 
	 * @return true, jos kappale on lopussa, muuten false.
	 */
	public boolean isAtEnd()
	{
		if (current_note >= num_loops * notes.length)
			return true;
		else
			return false;
	}
	
	/**
	 * Palauttaa kappaleen nimen
	 * 
	 * @return Kappaleen nimi
	 */
	public String getSongName()
	{
		return song_name;
	}
	
	/**
	 * Palauttaa kappaleen esittäjän
	 * 
	 * @return Kappaleen esittäjä
	 */
	public String getArtistName()
	{
		return artist_name;
	}
};
