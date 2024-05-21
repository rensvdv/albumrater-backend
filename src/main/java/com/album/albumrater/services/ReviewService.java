package com.album.albumrater.services;

import com.album.albumrater.logic.Review;
import com.album.albumrater.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {


    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviewsFromAlbum(int albumId) {
        return reviewRepository.findAllByAlbumId(albumId);
    }

    public boolean createReview(Review review) {
        boolean success = false;
        Review reviewResult = reviewRepository.save(review);

        if(reviewResult.getId() > 0) {
            success = true;
        }
        return success;
    }
}
