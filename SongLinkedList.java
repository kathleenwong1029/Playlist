/**
* The SongLinkedList class uses a Doubly-Linked List to create a playlist
* using SongNode as nodes.
*
* @author Kathleen Wong
*    email : kathleen.wong.1@stonybrook.edu
*    CSE 214 : Homework 2
*    R08 : TA Felix Rieg-Baumhauer
*    Stony Brook ID: 112859743
**/

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SongLinkedList{

  private SongNode head, tail, cursor; //head, tail, cursor pointer nodes
  private int size; //how many songs in playlist


  /**
  * Instanties a SongLinkedList by setting all pointers null
  **/
  public SongLinkedList(){
    head = null;
    tail = null;
    cursor = null;
    size = 0;
  }

  /**
  * Gets the head of the linked list
  * @return head node
  */
  public SongNode getHead(){
    return head;
  }

  /**
  * Gets the tail of the linked list
  * @return tail node
  */
  public SongNode getTail(){
    return tail;
  }

  /**
  * Gets the cursor of the linked list
  * @return cursor node
  */
  public SongNode getCursor(){
    return cursor;
  }

  /**
  * Gets the size of the linked list
  * @return number of songs
  */
  public int getSize(){
    return size;
  }

  /**
  * Assigns head pointer
  * @param newHead
  *    The new head node.
  **/
  public void setHead(SongNode newHead){
    head = newHead;
  }

  /**
  * Assigns tail pointer
  * @param newTail
  *    The new tail node.
  **/
  public void setTail(SongNode newTail){
    tail = newTail;
  }

  /**
  * Assigns cursor pointer
  * @param newCursor
  *    The new cursor node.
  **/
  public void setCursor(SongNode newCursor){
    cursor = newCursor;
  }

  /**
  * Sets list size
  * @param newSize
  *    The new size.
  **/
  public void setSize(int newSize){
    size = newSize;
  }

  /**
  * Plays a given song
  * @param song
  *    The name of the song you wan to play.
  * @exception IllegalArgumentException
  *    Indicates that the argument is illegal.
  * @exception UnsupportedAudioFileException
  *    Indicates that audio file is not .wav.
  * @exception LineUnavailableException
  *    Indicates that a line cannot be opened.
  * @exception IOException
  *    Indicates that I/O operation failed.
  **/
  public void play(String name) throws IllegalArgumentException , UnsupportedAudioFileException,
  LineUnavailableException , IOException{
    boolean songExists = false;
    SongNode temp = head;
    for(int i = 0; i<size; i++){
      if(temp.getData().getName().equalsIgnoreCase(name)){
        songExists = true;
        break;
      }
      temp = temp.getNext();
    }
    if(songExists){
      try {
        AudioInputStream AIS = AudioSystem.getAudioInputStream(new File(name + ".wav"));
        Clip c = AudioSystem.getClip();
        c.open(AIS);
        c.start();
        System.out.println("'" + name + "'" + " is now playing.");
      }
      catch (IllegalArgumentException e) {
      }
      catch(UnsupportedAudioFileException e){
      }
      catch(LineUnavailableException e){
      }
      catch(IOException e){
        System.out.println("Associated .wav file does not exist.");
      }
    }
    else{
      System.out.println("'" + name + "'" + " not found.");
    }
  }

  /**
  * Moves the cursor forward.
  * @exception NullPointerException
  *    Indicates that the playlist is empty.
  **/
  public void cursorForwards() throws NullPointerException {
    try{
      cursor.getData();
      if (!(cursor.getNext()==null)){
        cursor = cursor.getNext();
        System.out.println("Cursor moved to next song.");
      }
      else{
        System.out.println("Already at end of playlist.");
      }
    }
    catch(NullPointerException e){
      System.out.println("Playlist has no songs.");
    }
  }

  /**
  * Cursor Forwards used as a helper method without print statements.
  * @exception NullPointerException
  *    Indicates that the playlist is empty.
  **/
  public void cursorForwards2() throws NullPointerException {
    try{
      cursor.getData();
      if (!(cursor.getNext()==null)){
        cursor = cursor.getNext();
      }
    }
    catch(NullPointerException e){
      System.out.println("Playlist has no songs.");
    }
  }

  /**
  * Moves the cursor backwards.
  * @exception NullPointerException
  *    Indicates that the playlist is empty.
  **/
  public void cursorBackwards(){
    try{
      cursor.getData();
      if (!(cursor.getPrev()==null)){
        cursor = cursor.getPrev();
        System.out.println("Cursor moved to previous song.");
      }
      else{
        System.out.println("Already at beginnning of playlist.");
      }
    }
    catch(NullPointerException e){
      System.out.println("Playlist has no songs.");
    }
  }

  /**
  * Cursor Backwards used as a helper method without print statements.
  * @exception NullPointerException
  *    Indicates that the playlist is empty.
  **/
  public void cursorBackwards2(){
    try{
      cursor.getData();
      if (!(cursor.getPrev()==null)){
        cursor = cursor.getPrev();
      }
    }
    catch(NullPointerException e){
      System.out.println("Playlist has no songs.");
    }
  }

  /**
  * Plays a given song
  * @param song
  *    The name of the song you wan to play.
  * @exception IllegalArgumentException
  *    Indicates that the argument is illegal.
  **/
  public void insertAfterCursor(Song newSong) throws IllegalArgumentException{
    try{
      if(size == 0){
        addFront(newSong);
      }
      else if(cursor == tail){
        addLast(newSong);
        cursorForwards2();
      }
      else{
        SongNode adding = new SongNode(newSong,cursor,cursor.getNext());
        cursor.getNext().setPrev(adding);
        cursor.setNext(adding);
        cursorForwards2();
      }
      size++;
    }
    catch(IllegalArgumentException e){
      System.out.print("NewSong is null.");
    }

  }

  /**
  * Helper method ot add new Song to front of playlist.
  * @param song
  *    The name of the song you wan to add.
  **/
  public void addFront(Song newSong){
    head = new SongNode(newSong, null, null);
    tail = head;
    cursor = head;
  }

  /**
  * Helper method ot add new Song to end of playlist.
  * @param song
  *    The name of the song you wan to add.
  **/
  public void addLast(Song newSong){
    SongNode temp = new SongNode(newSong, tail, null);
    cursor.setNext(temp);
    tail.setNext(temp);
    if(size == 0){
      head.setNext(temp);
    }
    tail = temp;
  }

  /**
  * Helper method ot remove a Song at front of playlist.
  * @param song
  *    The name of the song you wan to remove.
  **/
  public Song removeFirst(){
    Song removed = head.getData();
    head = head.getNext();
    head.setPrev(null);
    return removed;
  }

  /**
  * Helper method ot remove a Song at end of playlist.
  * @param song
  *    The name of the song you wan to remove.
  **/
  public Song removeLast(){
    Song removed = tail.getData();
    tail.getPrev().setNext(null);
    tail = tail.getPrev();
    return removed;
  }

  /**
  * Removes the song that cursor is pointing to.
  * @return
  *   Returns the removed song.
  **/
  public Song removeCursor(){
    Song removed = new Song();
    // try{
    if(size == 0){
      cursor.getData();
    }
    if(size == 1){
      removed = cursor.getData();
      head = tail = cursor = null;
    }
    else if(cursor == head){
      removed = removeFirst();
      cursorForwards2();
    }
    else if(cursor == tail){
      removed = removeLast();
      cursorBackwards2();
    }
    else{
      removed = cursor.getData();
      cursor.getPrev().setNext(cursor.getNext());
      cursor.getNext().setPrev(cursor.getPrev());
      cursorForwards2();
    }
    size--;
    return removed;
  }

  /**
  * Clears playlist.
  **/
  public void deleteAll(){
    cursor = head;
    while(!(cursor == null)){
      removeCursor();
    }
  }

  /**
  * Creates a random number.
  * @return
  *   Returns random number.
  **/
  public int randomNum() {
    Random rand = new Random();
    int num = 0;
    if(size == 0){
      throw new NullPointerException();
    }
    else{
      num = rand.nextInt(size);
    }
    return num;
  }

  /**
  * Returns a random song.
  * @return
  *   Returns a random song.
  **/
  public Song random() throws IllegalArgumentException , UnsupportedAudioFileException,
  LineUnavailableException , IOException{
    int num = randomNum();
    SongNode temp = head;
    for(int i = 0; i<num; i++){
      temp = temp.getNext();
    }
    System.out.println("Playing a random song...");
    play(temp.getData().getName());
    return temp.getData();
  }

  /**
  * Shuffles the playlist.
  **/
  public void shuffle(){
    try{
      SongNode cursorTemp = cursor;
      Song temp = cursor.getData();
      int j = 0;
      for(int i =0; i<size; i++){
        cursor = head;
        j = randomNum();
        for(int k =0; k< j;k++){
          cursor = cursor.getNext();
        }
        temp = removeCursor();
        cursor = head;
        j = randomNum();
        for(int l =0; l< j;l++){
          cursor = cursor.getNext();
        }
        insertAfterCursor(temp);
      }
      cursor = head;
      for( int a = 0; a < size; a++){
        if(cursor.getData() == cursorTemp.getData()){
          break;
        }
        else{
          cursor = cursor.getNext();
        }
      }
      System.out.println("Playlist shuffled.");
    }
    catch(NullPointerException e){
      System.out.println("Playlist has no songs.");
    }
  }

  /**
  * Prints out the playlist.
  **/
  public void printPlaylist(){
    System.out.println(toString());
  }

  /**
  * Stringifies Playlist
  * @return
  *   Returns playlist in string form.
  **/
  public String toString(){
    String retStr = "";
    SongNode temp = head;
    retStr += String.format("%-25s%-25s%-25s%-10s","Song","| Artist","| Album","| Length(s)")+"\n";
    String lines = "";
    for(int a = 0; a < 90; a++){
      lines += "-";
    }
    retStr += lines + "\n";
    for(int i = 0; i < size; i++){
      if(temp == cursor){
        retStr += temp.getData() + "<-"  + "\n";
      }
      else{
        retStr += temp.getData() + "\n";
      }
      if(!(temp == tail)){
        temp = temp.getNext();
      }
    }
    return retStr;
  }
}
