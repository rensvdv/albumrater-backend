package com.album.albumrater.services;

import com.album.albumrater.logic.Album;
import com.album.albumrater.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(int id) {
        return albumRepository.findById(id).orElse(null);
    }

    public void createAlbum(Album album) {
        albumRepository.save(album);
    }

    public boolean updateAlbum(Album album) {
        boolean success = false;
        if (albumRepository.existsById(album.getId())) {
            albumRepository.save(album);
            success = true;
        }
        return success;
    }


    public boolean deleteAlbum(int id) {
        boolean success = false;
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            success = true;
        }
        return success;
    }

}
