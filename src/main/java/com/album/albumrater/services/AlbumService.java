package com.album.albumrater.services;

import com.album.albumrater.logic.Album;
import com.album.albumrater.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public void createAlbum(Album album) {
        albumRepository.save(album);
    }

}
