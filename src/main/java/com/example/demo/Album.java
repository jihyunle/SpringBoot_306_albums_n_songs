/* each album can have many songs, so use @OneToMany
* this is a java Bean so we need @Entity
*/

/*Persistence = saving things
* API = set of functions to do the job
* Persistence API = set of functions to store data to db
* Java Persistence API = set of functions to store data to db using java*/

/*CascadeTypeALL = persistence will propagate(cascaade) all EntitiyManager operations
* to relating entities*/
package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String artist;
    private int year;
    private String genre;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Song> songs;

    public Album(){

    }

    public Album(String title, int year, String artist, String genre) {
        this.title = title;
        this.setYear(year); // this allows for data validation
        this.artist = artist;
        this.genre = genre;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 2019){
            this.year = year;
        } else {
            this.year = 0;
        }

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
