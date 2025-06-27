package com.whiteroadtojava.backend.service.recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.whiteroadtojava.backend.modul.Recipe;
import com.whiteroadtojava.backend.modul.User;
import com.whiteroadtojava.backend.repository.RecipeRepository;
import com.whiteroadtojava.backend.repository.UserRepository;
import com.whiteroadtojava.backend.request.CreateRecipeRequest;
import com.whiteroadtojava.backend.request.RecipeUpdateRequest;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
        private final RecipeRepository recipeRepsitory;
        private final UserRepository userRepository;

        @Override
        public Recipe createRecipe(CreateRecipeRequest request) {
                if (request == null || request.getUser() == null) {
                                throw new IllegalArgumentException("Invalid request or user.");
                }
                User user = Optional.ofNullable(userRepository.findByUsername(request.getUser().getUsername())).map(existingUser -> {
                        existingUser.getRecipe().add(request.getRecipe());
                        return existingUser;
                }).orElseGet(() -> {
                        User newUser = new User(request.getUser().getUsername());
                        userRepository.save(newUser);
                        return newUser;
                });

                Recipe recipe = RecipeService.creaRecipe(request, user);
                return recipeRepsitory.save(recipe);
        }

        @Override
        public Recipe updateRecipe(RecipeUpdateRequest request, Long recipeId) {
                Recipe recipe = getRecipeById(recipeId);
                Recipe theRecipe = RecipeService.updateRecipe(recipe, request);
                return recipeRepsitory.save(theRecipe);
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
                                .map(Recipe::getCuisine).collect(Collectors.toSet());
        }

}