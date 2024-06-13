package com.album.albumrater.controllers;

import com.album.albumrater.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private AlbumRepository albumRepository;

    @PostMapping("/reset")
    public ResponseEntity<Void> resetDatabase() {
        //Wordt gebruikt bij end to end testing
        albumRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}

