package com.album.albumrater.mappers;

import com.album.albumrater.dto.AlbumDTO;
import com.album.albumrater.logic.Album;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {

    public AlbumDTO toAlbumDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(album.getId());
        albumDTO.setTitle(album.getTitle());
        albumDTO.setArtist(album.getArtist());
        albumDTO.setAlbumArt(album.getAlbumArt());
        albumDTO.setAlbumLink(album.getAlbumLink());
        albumDTO.setReleaseDate(album.getReleaseDate());
        return albumDTO;
    }

    public Album toAlbum(AlbumDTO albumDTO) {
        Album album = new Album(albumDTO.getId(), albumDTO.getTitle(), albumDTO.getArtist(), albumDTO.getReleaseDate(), albumDTO.getAlbumLink(), albumDTO.getAlbumArt(), albumDTO.getTotalTracks());
        return album;
    }
}
