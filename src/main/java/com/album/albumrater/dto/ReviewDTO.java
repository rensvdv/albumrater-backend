package com.album.albumrater.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
    public int id;
    public int albumId;
    public String review;
    public int score;
}
