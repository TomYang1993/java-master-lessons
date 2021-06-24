package yxy.tom.spotify.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private ArrayList<Song> songs;
    private String name;
    private String artist;

    public Album(String name, String artist) {
        this.songs = new ArrayList<Song>();
        this.name = name;
        this.artist = artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public void addSongToAlbum(String title, double duration) {
        if(findSong(title) != null){
            System.out.println("the song is already in.");

        }else{
            Song newSong = new Song(title, duration);
            this.songs.add(newSong);
            System.out.println("the song has been added: " + newSong.toString());
        }
    }

    public void addSongToPlaylist(String title, LinkedList<Song> playlist){
        Song selectedSong = findSong(title);
        if(findSong(title) == null){
            System.out.println("the song doesn't exist");
        }else{
            playlist.add(selectedSong);
            System.out.println("the song has been added to the playlist.");
        }
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    private Song findSong(String title) {
        for(Song song:songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

}
