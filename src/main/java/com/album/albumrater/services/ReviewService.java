package com.album.albumrater.services;

import com.album.albumrater.logic.Review;
import com.album.albumrater.mappers.ReviewMapper;
import com.album.albumrater.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviewsFromAlbum(int albumId) {
        return reviewRepository.findAllByAlbumId(albumId);
    }

    public void createReview(Review review) {
        reviewRepository.save(review);
    }
}
