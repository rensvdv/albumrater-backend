package com.album.albumrater.unittest.repo;

import com.album.albumrater.logic.Album;
import com.album.albumrater.logic.Review;
import com.album.albumrater.repositories.ReviewRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ReviewRepoTest implements ReviewRepository {

    public ArrayList<Review> reviews;

    public ReviewRepoTest(){
        reviews = new ArrayList<>();
        Album album = new Album(1, "Title", "Artist", "", "", "", 10 );
        Review review = new Review(1, 1, "review", 8);
        Review review2 = new Review(2, 1, "review2", 6);
        Review review3 = new Review(3, 1, "review3", 10);
        reviews.add(review);
        reviews.add(review2);
        reviews.add(review3);
    }

    @Override
    public List<Review> findAllByAlbumId(int albumId) {
        List<Review> reviewsByAlbumId = new ArrayList<>();
        for(int i = 0; i < reviews.size(); i++){
            if(reviews.get(i).getAlbumId() == albumId){
                reviewsByAlbumId.add(reviews.get(i));
            }
        }
        return reviewsByAlbumId;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Review> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Review> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Review> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Review getOne(Integer integer) {
        return null;
    }

    @Override
    public Review getById(Integer integer) {
        return null;
    }

    @Override
    public Review getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Review> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Review> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Review> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Review> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Review> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Review> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Review, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Review> S save(S entity) {
        reviews.add(entity);
        entity.setId(reviews.size()+1);
        return entity;
    }

    @Override
    public <S extends Review> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Review> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Review> findAll() {
        return List.of();
    }

    @Override
    public List<Review> findAllById(Iterable<Integer> integers) {
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
    public void delete(Review entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Review> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Review> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return null;
    }
}
