package com.album.albumrater.logic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;

    public String review;
    public int score;
}
