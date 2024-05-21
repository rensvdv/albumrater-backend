package com.album.albumrater.controllers;

import com.album.albumrater.dto.ReviewDTO;
import com.album.albumrater.logic.Review;
import com.album.albumrater.mappers.ReviewMapper;
import com.album.albumrater.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsFromAlbum(@PathVariable int albumId) {
        List<Review> reviews = this.reviewService.getAllReviewsFromAlbum(albumId);

        if(reviews.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        } else {
            List<ReviewDTO> reviewDTOS = new ArrayList<>();

            for(Review review : reviews) {
                ReviewDTO reviewDTO = this.reviewMapper.toReviewDTO(review);
                reviewDTOS.add(reviewDTO);
            }
            return ResponseEntity.ok(reviewDTOS);
        }
    }

    @PostMapping()
    public ResponseEntity<String> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review review = this.reviewMapper.toReview(reviewDTO);
        this.reviewService.createReview(review);
        return new ResponseEntity<>("Review created", HttpStatus.CREATED);
    }


}