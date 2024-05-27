package com.album.albumrater.unittest.service;

import com.album.albumrater.logic.Album;
import com.album.albumrater.logic.Review;
import com.album.albumrater.services.ReviewService;
import com.album.albumrater.unittest.repo.AlbumRepoMock;
import com.album.albumrater.unittest.repo.ReviewRepoMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Tag("UnitTest")
public class ReviewServiceTest {

    private ReviewService reviewService;
    private ReviewRepoMock reviewRepoMock;
    private AlbumRepoMock albumRepoMock;

    @BeforeEach
    void setup() throws Exception{
        this.reviewRepoMock = new ReviewRepoMock();
        this.albumRepoMock = new AlbumRepoMock();
        this.reviewService = new ReviewService(reviewRepoMock, albumRepoMock);

    }

    @Test
    public void createReviewTest(){
        Album album = new Album();
        album.setId(1);
        Review review = new Review(4, album, "reviewtext", 8);

        boolean result = this.reviewService.createReview(review);

        Assertions.assertThat(review).isNotNull();
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void getReviewByAlbumIdTest(){
        int albumId = 1;

        List<Review> reviews = this.reviewService.getAllReviewsFromAlbum(albumId);

        for (Review review : reviews) {
            Assertions.assertThat(review).isNotNull();
            Assertions.assertThat(review.getAlbum().getId()).isEqualTo(albumId);
        }
    }
}
