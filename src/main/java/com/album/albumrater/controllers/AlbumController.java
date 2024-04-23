package com.album.albumrater.controllers;

import com.album.albumrater.dto.AlbumDTO;
import com.album.albumrater.dto.SpotifyData;
import com.album.albumrater.logic.Album;
import com.album.albumrater.mappers.AlbumMapper;
import com.album.albumrater.services.AlbumService;
import com.album.albumrater.services.SpotifyAPI;
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

    private SpotifyAPI spotifyAPI;

    @Autowired
    public AlbumController(AlbumService albumService, AlbumMapper albumMapper, SpotifyAPI spotifyAPI) {
        this.albumMapper = albumMapper;
        this.albumService = albumService;
        this.spotifyAPI = spotifyAPI;
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

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> getAlbumById(@PathVariable int id) {
        Album album = this.albumService.getAlbumById(id);

        if(album != null) {
            AlbumDTO albumDTO = this.albumMapper.toAlbumDTO(album);
            return ResponseEntity.ok(albumDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
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
    @PostMapping("/save")
    public ResponseEntity<String> spotifyAPI(@RequestBody SpotifyData spotifyData)
    {
        boolean success = this.spotifyAPI.getAlbumsFromArtistWithSpotify(spotifyData.artist, spotifyData.accessToken);

        if(success) {
            return new ResponseEntity<>("Album added", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Album not added", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
