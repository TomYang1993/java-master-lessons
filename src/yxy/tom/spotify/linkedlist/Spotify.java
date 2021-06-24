package yxy.tom.spotify.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Spotify {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Song> playlist;
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSongToAlbum("Stormbringer", 4.6);
        album.addSongToAlbum("Love don't mean a thing", 4.22);
        album.addSongToAlbum("Holy man", 4.3);
        album.addSongToAlbum("Hold on", 5.6);
        album.addSongToAlbum("Lady double dealer", 3.21);
        album.addSongToAlbum("You can't do it right", 6.23);
        album.addSongToAlbum("High ball shooter", 4.27);
        album.addSongToAlbum("The gypsy", 4.2);
        album.addSongToAlbum("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSongToAlbum("For those about to rock", 5.44);
        album.addSongToAlbum("I put the finger on you", 3.25);
        album.addSongToAlbum("Lets go", 3.45);
        album.addSongToAlbum("Inject the venom", 3.33);
        album.addSongToAlbum("Snowballed", 4.51);
        album.addSongToAlbum("Evil walks", 3.45);
        album.addSongToAlbum("C.O.D.", 5.25);
        album.addSongToAlbum("Breaking the rules", 5.32);
        album.addSongToAlbum("Night of the long knives", 5.12);
        albums.add(album);

        playlist = new LinkedList<Song>();
        albums.get(0).addSongToPlaylist("You can't do it right", playlist);
        albums.get(0).addSongToPlaylist("Holy man", playlist);
        albums.get(0).addSongToPlaylist("Speed king", playlist);  // Does not exist
        albums.get(0).addSongToPlaylist(9, playlist);
        albums.get(1).addSongToPlaylist(8, playlist);
        albums.get(1).addSongToPlaylist(3, playlist);
        albums.get(1).addSongToPlaylist(2, playlist);
        albums.get(1).addSongToPlaylist(24, playlist);  // There is no track 24

        play();

    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To forward the song.");
        System.out.println("\t 2 - To backwards the song.");
        System.out.println("\t 3 - To replay the song.");
        System.out.println("\t 4 - To remove a song from the list.");
        System.out.println("\t 5 - To list all the songs in the playlist.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void listSongs() {
        System.out.print("The songs below as insert orders: ");
        ListIterator<Song> songList = playlist.listIterator();
        while(songList.hasNext()){
            System.out.println(songList.next().toString());
        }
    }

    public static void play() {
        ListIterator<Song> songList = playlist.listIterator();
        if(playlist.isEmpty()){
            System.out.println("The playlist has no songs.");
        }else{
            System.out.println("Now playing is: " + songList.next().toString());
        }

        boolean quit = false;
        boolean forward = true;

        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: " );
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    if(!forward){
                        songList.next();
                        forward = true;
                    }
                    if(songList.hasNext()){
                        System.out.println("now playing is: " + songList.next().toString());
                    }else{
                        System.out.println("you have reached the end of the list");
                    }
                    break;
                case 2:
                    if(forward){
                        songList.previous();
                        forward = false;
                    }
                    if(songList.hasPrevious()){
                        System.out.println("now playing is: " + songList.previous().toString());
                    }else{
                        System.out.println("you have reached the beginning of the list");
                    }
                    break;
                case 3:
                    if(forward){
                        System.out.println("now playing is: " + songList.previous().toString());
                        forward = false;
                    }else{
                        System.out.println("now playing is: " + songList.next().toString());
                        forward = true;
                    }
                    break;
                case 4:
                    if(playlist.size() > 0){
                        songList.remove();
                        if(songList.hasPrevious()){
                            System.out.println("now playing is: " + songList.previous().toString());
                        }else if(songList.hasNext()){
                            System.out.println("now playing is: " + songList.next().toString());
                        }
                    }
                    break;
                case 5:
                    listSongs();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

}
