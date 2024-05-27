package com.album.albumrater.integrationtest;

import com.album.albumrater.dto.ReviewDTO;
import com.album.albumrater.logic.Album;
import com.album.albumrater.logic.Review;
import com.album.albumrater.repositories.AlbumRepository;
import com.album.albumrater.services.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlbumRepository albumRepository;

    @Mock
    private ReviewService reviewService;


    @BeforeEach
    public void setup() {
        albumRepository.deleteAll();

        Album album = new Album();
        album.setTitle("Test Album");
        albumRepository.save(album);

    }

    /* @Test
    public void testGetReviewsFromAlbum_ReturnsNoContent() throws Exception {
        // Arrange
        when(reviewService.getAllReviewsFromAlbum(1)).thenReturn(new ArrayList<>());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reviews/1")
                        .accept(MediaType.APPLICATION_JSON) // Set Accept header
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    /* @Test
    public void testGetReviewsFromAlbum_ReturnsReviews() throws Exception {
        // Arrange
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(1, 1, "Geweldig album", 8));
        reviews.add(new Review(2, 1, "Wel een oke album", 4));
        when(reviewService.getAllReviewsFromAlbum(1)).thenReturn(reviews);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reviews/1")
                        .accept(MediaType.APPLICATION_JSON) // Set Accept header
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].comment").value("Geweldig album"))
                .andExpect(jsonPath("$[0].rating").value(8))
                .andExpect(jsonPath("$[1].comment").value("Wel een oke album"))
                .andExpect(jsonPath("$[1].rating").value(4));
    }*/

    @Test
    public void testAddReview_ReturnsCreated() throws Exception {
        // Arrange
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReview("Nice album");
        reviewDTO.setAlbumId(1);
        reviewDTO.setScore(9);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews")
                        .content(asJsonString(reviewDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Utility method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

