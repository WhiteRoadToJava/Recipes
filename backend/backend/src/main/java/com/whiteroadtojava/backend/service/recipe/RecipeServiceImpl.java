package com.whiteroadtojava.backend.service.recipe;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.whiteroadtojava.backend.modul.Recipe;
import com.whiteroadtojava.backend.repository.RecipeRepository;
import com.whiteroadtojava.backend.request.CreateRecipeRequest;
import com.whiteroadtojava.backend.request.RecipeUpdateRequest;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
        private final RecipeRepository recipeRepsitory;

        @Override
        public Recipe createRecipe(CreateRecipeRequest request) {
                return null;
        }
        @Override
        public Recipe updaRecipe(RecipeUpdateRequest request, Long recipeId) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'updaRecipe'");
        }

        @Override
        public List<Recipe> getAllRecipes() {
                return recipeRepsitory.findAll();

        }

        @Override
        public Recipe getRecipeById(Long id) {
                return recipeRepsitory.findById(id).orElseThrow(() -> new EntityNotFoundException("Recipe not Found."));
        }

        

        @Override
        public void deleteRecipe(Long id) {
                recipeRepsitory.deleteById(id);
        }

        @Override
        public Set<String> getAllRecipesCategories() {
                return recipeRepsitory.findAll()
                                .stream()
                                .map(Recipe::getCategory).collect(Collectors.toSet());
        }

        @Override
        public Set<String> getAllRecipesCuisine() {
                 return recipeRepsitory.findAll()
                                .stream()
                                .map(Recipe:: getCuisine).collect(Collectors.toSet());
        }

}