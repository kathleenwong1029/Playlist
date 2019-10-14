/**
* The Song class represents a song in the playlist.
*
*
* @author Kathleen Wong
*    email : kathleen.wong.1@stonybrook.edu
*    CSE 214 : Homework 2
*    R08 : TA Felix Rieg-Baumhauer
*    Stony Brook ID: 112859743
**/

public class Song {
  private String name; // title of song
  private String artist; //arist of song
  private String album; //album name for song
  private int length; //length is seconds of song

  /**
  * Instanties a song.
  **/
  public Song(){
  }

  /**
  * Creates a Song with variables.
  * @param _name
  *    The name of the song.
  * @param _artist
  *    The artist of the song.
  * @param _album
  *    The album of the song.
  * @param _length
  *    The length in seconds of the song.
  **/
  public Song(String _name, String _artist, String _album, int _length){
    name = _name;
    artist = _artist;
    album = _album;
    length = _length;
  }

  /**
  * Gets the name of the song.
  * @return song name
  */
  public String getName(){
    return name;
  }

  /**
  * Gets the artist of the song.
  * @return song artist
  */
  public String getArtist(){
    return artist;
  }

  /**
  * Gets the album of the song.
  * @return album name
  */
  public String getAlbum(){
    return album;
  }

  /**
  * Gets the length of the song.
  * @return song length
  */
  public int getLength(){
    return length;
  }

  /**
  * Adds song's name
  * @param _name
  *    The name of the song.
  **/
  public void setName(String _name){
    name = _name;
  }

  /**
  * Adds song's artist
  * @param _artist
  *    The artistof the song.
  **/
  public void setArtist(String _artist){
    artist = _artist;
  }

  /**
  * Adds song's album
  * @param _album
  *    The album of the song.
  **/
  public void setAlbum(String _album){
    album = _album;
  }

  /**
  * Adds song's length
  * @param _length
  *    The length of the song.
  **/
  public void setLength(int _length){
    length = _length;
  }

  /**
  * Stringifies a Song.
  * @return
  *   Returns a stringified version of a Song.
  **/
  public String toString(){
    return String.format(String.format("%-25s%-25s%-25s%-10s", name, artist,
    album, Integer.toString(length)));
  }

}
