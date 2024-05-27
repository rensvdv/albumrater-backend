package com.album.albumrater.unittest.repo;

import com.album.albumrater.logic.Album;
import com.album.albumrater.logic.Review;
import com.album.albumrater.repositories.AlbumRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AlbumRepoMock implements AlbumRepository {

    public ArrayList<Album> albums;

    public AlbumRepoMock(){
        albums = new ArrayList<>();
        Album album = new Album(1, "Title", "Artist", "", "", "", 10, new ArrayList<>() );
        Album album2 = new Album(2, "Title2", "Artist", "", "", "", 8, new ArrayList<>() );
        Album album3 = new Album(3, "Title3", "Artist2", "", "", "", 5, new ArrayList<>() );
        albums.add(album);
        albums.add(album2);
        albums.add(album3);
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends Album> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Album> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Album> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Album getOne(Integer integer) {
        return null;
    }

    @Override
    public Album getById(Integer integer) {
        return null;
    }

    @Override
    public Album getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Album> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Album> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Album> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Album> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Album> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Album> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Album, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Album> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Album> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Album> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        boolean exists = false;
        for (Album album : this.albums) {
            if (album.getId() == integer) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    @Override
    public List<Album> findAll() {
        return List.of();
    }

    @Override
    public List<Album> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Album entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Album> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Album> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Album> findAll(Pageable pageable) {
        return null;
    }
}
