package com.album.albumrater.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
}
