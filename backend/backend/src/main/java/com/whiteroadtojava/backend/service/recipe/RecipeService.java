package com.whiteroadtojava.backend.service.recipe;

import java.util.List;
import java.util.Set;

import com.whiteroadtojava.backend.modul.Recipe;
import com.whiteroadtojava.backend.modul.User;
import com.whiteroadtojava.backend.request.CreateRecipeRequest;
import com.whiteroadtojava.backend.request.RecipeUpdateRequest;

public interface RecipeService {

        Recipe createRecipe(CreateRecipeRequest request);

        List<Recipe> getAllRecipes();

        Recipe getRecipeById(Long id);

        Recipe updaRecipe(RecipeUpdateRequest request, Long recipeId);

        void deleteRecipe(Long id);

        Set<String> getAllRecipesCategories();

        Set<String> getAllRecipesCuisine();

        static Recipe creaRecipe(CreateRecipeRequest request, User user) {
                Recipe recipe = new Recipe();
                Recipe createRequerst = new Recipe();

                recipe.setTitle(createRequerst.getTitle());           
        }
}