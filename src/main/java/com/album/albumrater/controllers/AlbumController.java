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
//@CrossOrigin(origins = "")
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
}
