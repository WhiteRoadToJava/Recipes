package com.example.cocks_recipe.request;

import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.model.User;

import lombok.Data;

@Data
public class CreateRecipeRequest {
        private Recipe recipe;
        private User user;

}