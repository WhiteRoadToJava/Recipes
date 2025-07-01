package com.example.cocks_recipe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recipes")
public class Recipe {
   @Id
        private String id;
        private String title;
        private String instuction;
        private String description;
        private String prepTime;
        private String cookTime;
        private String category;
        private String cuisine;

        @Field("ingredients")
        private List<String> ingredients;
        private int likeCount;
        private double avarageRating;
        private int totalReviews;

        @DBRef
        @Field("user_id")
        private User user;

        @DBRef
        private List<Review> reviews;

        @DBRef
        private List<Like> likes;

        @DBRef
        private List<Image> images;
}