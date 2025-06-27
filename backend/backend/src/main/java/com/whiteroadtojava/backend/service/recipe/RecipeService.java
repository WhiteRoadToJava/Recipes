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

        Recipe updateRecipe(RecipeUpdateRequest request, Long recipeId);

        void deleteRecipe(Long id);

        Set<String> getAllRecipesCategories();

        Set<String> getAllRecipesCuisine();

        static Recipe creaRecipe(CreateRecipeRequest request, User user) {
                Recipe recipe = new Recipe();
                Recipe createRequerst = new Recipe();
                recipe.setTitle(createRequerst.getTitle());
                recipe.setDescription(createRequerst.getDescription());
                recipe.setCategory(createRequerst.getCategory());
                recipe.setCuisine(createRequerst.getCuisine());
                recipe.setIngredients(createRequerst.getIngredients());
                recipe.setInstuction(createRequerst.getInstuction());
                recipe.setPrepTime(createRequerst.getPrepTime());
                recipe.setCookTime(createRequerst.getCookTime());
                recipe.setUser(createRequerst.getUser());
                return recipe;
        }

        static Recipe updateRecipe(Recipe existingRecipe, RecipeUpdateRequest request) {
                existingRecipe.setTitle(request.getTitle());
                existingRecipe.setDescription(request.getDescription());
                existingRecipe.setCategory(request.getCategory());
                existingRecipe.setCuisine(request.getCuisine());
                existingRecipe.setIngredients(request.getIngredients());
                existingRecipe.setInstuction(request.getInstuction());
                existingRecipe.setPrepTime(request.getPrepTime());
                existingRecipe.setCookTime(request.getCookTime());
                return existingRecipe;
        }

}