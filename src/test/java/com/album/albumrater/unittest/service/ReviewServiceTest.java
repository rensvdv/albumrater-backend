package com.album.albumrater.unittest.service;

import com.album.albumrater.logic.Review;
import com.album.albumrater.services.ReviewService;
import com.album.albumrater.unittest.repo.ReviewRepoTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Tag("UnitTest")
public class ReviewServiceTest {

    private ReviewService reviewService;
    private ReviewRepoTest reviewRepoTest;

    @BeforeEach
    void setup() throws Exception{
        this.reviewRepoTest = new ReviewRepoTest();
        this.reviewService = new ReviewService(reviewRepoTest);

    }

    @Test
    public void createReviewTest(){
        Review review = new Review(4, 1, "reviewtext", 8);

        boolean result = this.reviewService.createReview(review);

        Assert.isTrue(result, "");
    }

    @Test
    public void getReviewByAlbumIdTest(){
        int albumId = 1;

        List<Review> reviews = this.reviewService.getAllReviewsFromAlbum(1);

        for (Review review : reviews) {
            Assert.isTrue(review.getAlbumId() == albumId, "");
        }
    }
}
