package com.whiteroadtojava.backend.request;

import java.util.List;

import lombok.Data;

@Data
public class RecipeUpdateRequest {

        private String title;
        private String instuctions;
        private String prepTime;
        private String cookTime;
        private String category;
        private String description;
        private String cuisine;
        private List<String> ingredients;


        
}
