package com.album.albumrater.controllers;

import com.album.albumrater.dto.AlbumDTO;
import com.album.albumrater.logic.Album;
import com.album.albumrater.mappers.AlbumMapper;
import com.album.albumrater.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/albums")
public class AlbumController {

    private AlbumService albumService;
    private AlbumMapper albumMapper;

    @Autowired
    public AlbumController(AlbumService albumService, AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
        this.albumService = albumService;
    }

    @GetMapping()
    public ResponseEntity<List<AlbumDTO>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        List<AlbumDTO> albumDTOS = new ArrayList<>();

        for(Album album : albums) {
            AlbumDTO albumDTO = albumMapper.toAlbumDTO(album);
            albumDTOS.add(albumDTO);
        }
        return ResponseEntity.ok(albumDTOS);
    }

    @PostMapping()
    public ResponseEntity<String> addAlbum(@RequestBody AlbumDTO albumDTO) {
        Album album = albumMapper.toAlbum(albumDTO);
        albumService.createAlbum(album);
        return new ResponseEntity<>("Album Added", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateAlbum (@RequestBody AlbumDTO albumDTO) {
        Album album = albumMapper.toAlbum(albumDTO);
        boolean success = albumService.updateAlbum(album);

        if(success) {
            return new ResponseEntity<>("Album updated", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Album not updated", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable int id) {
        boolean success = albumService.deleteAlbum(id);

        if(success) {
            return new ResponseEntity<>("Album deleted", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Album not deleted", HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
