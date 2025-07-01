package com.example.cocks_recipe.request;

import java.util.List;

import lombok.Data;


@Data
public class RecipeUpdateRequest {
        private String title;
        private String instuction;
        private String prepTime;
        private String cookTime;
        private String description;
        private String category;
        private String cuisine;
        private List<String> ingredients;
}