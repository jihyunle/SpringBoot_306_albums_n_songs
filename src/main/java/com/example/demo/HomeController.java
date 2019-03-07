package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    AlbumDirectory albumDirectory;

    @Autowired
    SongDirectory songDirectory;

    @RequestMapping("/")
    public String index(Model model){
        // create an album
        Album album = new Album("Christmas Carols", 1992, "Mariah Carey", "Pop Rock");
        // create a song
        Song song = new Song("All I Want for Christmas is you", 1, "Let my wish come true... baby all I want for Christmas is you", album);
        // add song to an empty list
        Set<Song> songs = new HashSet<>();
        songs.add(song);
        // add another song
        song = new Song("Let my love open the door", 10, "Let my love open the door, to your heart", album);
        songs.add(song);
        song = new Song("My heart will go on", 2, "Near, far, wherever you are... my heart will go on and on", album);
        songs.add(song);
        // add the list of songs to the album's song list
        album.setSongs(songs);
        // save the album to the db
        albumDirectory.save(album);
        // grab all the albums from the db and send them to template
        model.addAttribute("albums", albumDirectory.findAll());
        return "index";
    }
}
