package com.album.albumrater.repositories;

import com.album.albumrater.logic.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
