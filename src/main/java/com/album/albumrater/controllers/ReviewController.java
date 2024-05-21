package com.album.albumrater.controllers;

import com.album.albumrater.dto.AlbumDTO;
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

     


}
