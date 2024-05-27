package com.album.albumrater.services;

import com.album.albumrater.logic.Review;
import com.album.albumrater.repositories.AlbumRepository;
import com.album.albumrater.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {


    private final ReviewRepository reviewRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, AlbumRepository albumRepository) {
        this.reviewRepository = reviewRepository;
        this.albumRepository = albumRepository;
    }

    public List<Review> getAllReviewsFromAlbum(int albumId) {
        return reviewRepository.findAllByAlbumId(albumId);
    }

    public boolean createReview(Review review) {
        boolean success = false;

        if (albumRepository.existsById(review.getAlbum().getId())) {
            Review savedReview = reviewRepository.save(review);
            success = true;
        }
        return success;
    }
}
