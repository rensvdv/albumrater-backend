package com.album.albumrater.services;

import com.album.albumrater.logic.Album;
import com.album.albumrater.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Optional<Album> oldAlbumOpt = albumRepository.findById(album.getId());

        if (oldAlbumOpt.isPresent()) {
            Album oldAlbum = oldAlbumOpt.get();

            // Update the old album's fields with the new values
            oldAlbum.setTitle(album.getTitle());
            oldAlbum.setArtist(album.getArtist());
            oldAlbum.setReleaseDate(album.getReleaseDate());
            oldAlbum.setAlbumLink(album.getAlbumLink());
            oldAlbum.setAlbumArt(album.getAlbumArt());
            oldAlbum.setTotalTracks(album.getTotalTracks());

            // Ensure both collections are initialized to avoid null issues
            if (oldAlbum.getReviews() == null) {
                oldAlbum.setReviews(new ArrayList<>());
            }
            if (album.getReviews() != null) {
                oldAlbum.getReviews().clear();
                oldAlbum.getReviews().addAll(album.getReviews());
            }

            albumRepository.save(oldAlbum);
            return true;
        }
        return false;
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
