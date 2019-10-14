/**
* The SongNode serves as a wrapper node for the Song objects.
*
* @author Kathleen Wong
*    email : kathleen.wong.1@stonybrook.edu
*    CSE 214 : Homework 2
*    R08 : TA Felix Rieg-Baumhauer
*    Stony Brook ID: 112859743
**/

public class SongNode{

  private Song data; //song represented by the SongNode
  private SongNode prev, next; //the previous and next SongNodes

  /**
  * Instanties a SongNode.
  **/
  public SongNode(){
  }

  /**
  * Creates a SongNode with variables.
  * @param _data
  *    The song represented by the SongNode.
  * @param _prev
  *    The previous SongNode.
  * @param _next
  *    The next SongNode.
  **/
  public SongNode(Song _data, SongNode _prev, SongNode _next){
    data = _data;
    prev = _prev;
    next = _next;
  }

  /**
  * Gets the song represented by the SongNode.
  * @return the song represented by the SongNode.
  */
  public Song getData(){
    return data;
  }

  /**
  * Gets the song represented by the previous SongNode.
  * @return the song represented by previous SongNode
  */
  public SongNode getPrev(){
    return prev;
  }

  /**
  * Gets the song represented by the next SongNode.
  * @return the song represented by the nextSongNode
  */
  public SongNode getNext(){
    return next;
  }

  /**
  * Adds song represented by the current SongNode.
  * @param newData
  *    The new Song.
  **/
  public void setData(Song newData ){
    data = newData;
  }

  /**
  * Adds song represented by the previous SongNode.
  * @param newPrev
  *    The new Song
  **/
  public void setPrev(SongNode newPrev){
    prev = newPrev;
  }

  /**
  * Adds song represented by the next SongNode.
  * @param newNext
  *    The new Song
  **/
  public void setNext(SongNode newNext){
    next = newNext;
  }
}
