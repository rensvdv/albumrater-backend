package com.album.albumrater.mappers;

import com.album.albumrater.dto.ReviewDTO;
import com.album.albumrater.logic.Album;
import com.album.albumrater.logic.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        Album album = new Album();
        album.setId(reviewDTO.getAlbumId());
        review.setId(reviewDTO.getId());
        review.setAlbum(album);
        review.setReview(reviewDTO.getReview());
        review.setScore(reviewDTO.getScore());
        return review;
    }

    public ReviewDTO toReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setAlbumId(review.getAlbum().getId());
        reviewDTO.setReview(review.getReview());
        reviewDTO.setScore(review.getScore());
        return reviewDTO;
    }
}
