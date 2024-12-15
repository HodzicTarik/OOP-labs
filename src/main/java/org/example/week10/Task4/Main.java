package org.example.week10.Task4;

import java.util.*;

class Song {
    String title;
    String artist;
    String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Genre: " + genre;
    }
}

class GenreFilterIterator implements Iterator<Song> {
    private final List<Song> playlist;
    private final String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).genre.equalsIgnoreCase(targetGenre)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return playlist.get(currentIndex++);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Song 1", "Artist 1", "Pop"));
        playlist.add(new Song("Song 2", "Artist 2", "Rock"));
        playlist.add(new Song("Song 3", "Artist 1", "Pop"));
        playlist.add(new Song("Song 4", "Artist 3", "Jazz"));

        GenreFilterIterator popSongsIterator = new GenreFilterIterator(playlist, "Pop");

        System.out.println("Songs with genre 'Pop':");
        while (popSongsIterator.hasNext()) {
            System.out.println(popSongsIterator.next());
        }
    }
}
