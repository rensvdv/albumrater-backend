package com.album.albumrater.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDTO {
    public int id;
    public String title;
    public String artist;
    private String releaseDate;
    private String albumLink;
    private String albumArt;
    private int totalTracks;
}
