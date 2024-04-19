package com.album.albumrater.mappers;

import com.album.albumrater.dto.ReviewDTO;
import com.album.albumrater.logic.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toReview(ReviewDTO reviewDTO)  {
        Review review = new Review(reviewDTO.getId(), reviewDTO.getAlbumId(), reviewDTO.getReview(), reviewDTO.getScore());
        return review;
    }

    public ReviewDTO toReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setAlbumId(review.getAlbumId());
        reviewDTO.setReview(review.getReview());
        reviewDTO.setScore(review.getScore());
        return reviewDTO;
    }
}
