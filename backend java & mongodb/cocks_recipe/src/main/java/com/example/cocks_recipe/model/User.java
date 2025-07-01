package com.example.cocks_recipe.model;

import java.util.List;
import java.util.Set;

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
public class User {
      @Id
        private String id;
        private String username;

        @DBRef
        @Field("recipe_id")
        private Set<Recipe> recipes;

        @DBRef
        @Field("review_id")
        private List<Review> reviews;

        public User(String username){
                this.username = username;
        }


}