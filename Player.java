/**
* The Player class creates a playlist using the SongLinkedList class and Allows
* users to interact with it.
*
* @author Kathleen Wong
*    email : kathleen.wong.1@stonybrook.edu
*    CSE 214 : Homework 2
*    R08 : TA Felix Rieg-Baumhauer
*    Stony Brook ID: 112859743
**/

import java.util.Scanner;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
public class Player{

  /**
  * Prints out user menu.
  **/
  public static void printMenu(){
    System.out.println("(A)   Add Song to Playlist");
    System.out.println("(F)   Go to Next Song");
    System.out.println("(B)   Go to Previous Song");
    System.out.println("(R)   Remove Song from Playlist");
    System.out.println("(L)   Play a Song");
    System.out.println("(C)   Clear the Playlist");
    System.out.println("(S)   Shuffle Playlist");
    System.out.println("(Z)   Random Song");
    System.out.println("(P)   Print Playlist");
    System.out.println("(T)   Get the total amount of songs in the playlist");
    System.out.println("(Q)   Exit the playlist\n");
    System.out.print("Enter an option: ");
  }

  /**
  * Allows user to interact with the meny and playlist.
  * @param String[] args
  *    Command-line arguments.
  * @exception IllegalArgumentException
  *    Indicates that the argument is illegal.
  * @exception UnsupportedAudioFileException
  *    Indicates that audio file is not .wav.
  * @exception LineUnavailableException
  *    Indicates that a line cannot be opened.
  * @exception IOException
  *    Indicates that I/O operation failed.
  **/
  public static void main (String[] args) throws IllegalArgumentException ,
    UnsupportedAudioFileException, LineUnavailableException , IOException{

    SongLinkedList tunes = new SongLinkedList();
    String foo0 = " "; String foo1 = " "; String foo2 = " "; String foo3 = " "; int bar;
    Scanner sc = new Scanner(System.in);
    printMenu();

    while(sc.hasNext()){
      String line = sc.nextLine();

      if(line.equals("A")||line.equals("a")){
        boolean go = true;
        System.out.print("Enter song title: ");
        foo0 = sc.nextLine();
        if(foo0.equals("")){
          System.out.println("Song needs a title.");
          go = false;
        }
        if(go){
          System.out.print("Enter artist(s) of the song: ");
          foo1 = sc.nextLine();
        }
        if(foo1.equals("")){
          System.out.println("Song needs an artist.");
          go = false;
        }
        if(go){
          System.out.print("Enter album: ");
          foo2 = sc.nextLine();
        }
        if(foo2.equals("")){
          System.out.println("Song needs an album.");
          go = false;
        }
        if(go){
          System.out.print("Enter length (in seconds): ");
          foo3 = sc.nextLine();
        }
        if(foo3.equals("")){
          System.out.println("Song needs a length.");
          go = false;
        }
        try{
          if(go){
            bar = Integer.parseInt(foo3);
            Song jams = new Song(foo0, foo1, foo2, bar);
            tunes.insertAfterCursor(jams);
            System.out.println("'" + foo0 + "'" + " by " + foo1 + " is added to your playlist.");
          }
        }
        catch(NumberFormatException e){
          System.out.println("Not a valid input for length.");
        }
      }

      if(line.equals("F")||line.equals("f")){
        tunes.cursorForwards();
      }

      if(line.equals("B")||line.equals("b")){
        tunes.cursorBackwards();
      }

      if(line.equals("R")||line.equals("r")){
        try{
          Song removed = tunes.removeCursor();
          System.out.println(removed.getName()+ " by " + removed.getArtist() +
            " was removed from the playlist.");
        }
        catch(NullPointerException e){
          System.out.println("Playlist has no songs.");
        }
      }

      if(line.equals("L")||line.equals("l")){
        System.out.print("Enter name of song to play: ");
        foo0 = sc.nextLine();
        try{
          tunes.play(foo0);
        }
        catch (IllegalArgumentException e) {
        }
        catch(UnsupportedAudioFileException e){
        }
        catch(LineUnavailableException e){
        }
        catch(IOException e){
        }
      }

      if(line.equals("C")||line.equals("c")){
        tunes.deleteAll();
        System.out.println("Playlist cleared.");
      }

      if(line.equals("S")||line.equals("s")){
        tunes.shuffle();
      }

      if(line.equals("Z")||line.equals("z")){
        try{
          Song randomSong = tunes.random();
        }
        catch(NullPointerException e){
          System.out.println("There are no songs in the playlist.");
        }
      }

      if(line.equals("P")||line.equals("p")){
        tunes.printPlaylist();
      }

      if(line.equals("T")||line.equals("t")){
        bar = tunes.getSize();
        System.out.println("Your playlist contains " + bar + " songs.");
      }

      if(line.equals("Q")||line.equals("q")){
        System.out.println("Program terminated.");
        System.exit(0);
      }

      System.out.print("\n");
      printMenu();
    }
  }
}
