package com.album.albumrater.logic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    private String title;
    private String artist;
    private String releaseDate;
    private String albumLink;
    private String albumArt;
    private int totalTracks;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
