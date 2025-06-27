package com.whiteroadtojava.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiteroadtojava.backend.modul.Recipe;
import com.whiteroadtojava.backend.request.CreateRecipeRequest;
import com.whiteroadtojava.backend.request.RecipeUpdateRequest;
import com.whiteroadtojava.backend.service.recipe.RecipeService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;





@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
        private final RecipeService recipeService;

        @PostMapping()
        public ResponseEntity<Recipe> createRecipe(CreateRecipeRequest request) {
                return ResponseEntity.status(200).body(recipeService.createRecipe(request));
        }
        @PutMapping("/{recIpeid}/update")
        public ResponseEntity<Recipe> updateRecipe(@RequestBody RecipeUpdateRequest request, @PathVariable Long id) {
                return ResponseEntity.status(200).body(recipeService.updateRecipe(request, id));
        }

        @DeleteMapping("/{recipeId}/delete")
        public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
                recipeService.deleteRecipe(id);
                return ResponseEntity.status(204).build();
        }

        @GetMapping()
        public ResponseEntity<List<Recipe>> getAllReecipes() {
                return ResponseEntity.status(200).body(recipeService.getAllRecipes());
        }
        

        @GetMapping("/{recipeId}/recipe")
        public ResponseEntity<Recipe> getRecipe(Long id) {
                return ResponseEntity.status(200).body(recipeService.getRecipeById(id));
        }

        @GetMapping("/categories")
        public ResponseEntity<Set<String>> getAllRecipesCategories() {
                return ResponseEntity.ok(recipeService.getAllRecipesCategories());
        }

        @GetMapping("/cuisines")
        public ResponseEntity<Set<String>> getAllRecipesCuisine() {
                return ResponseEntity.ok(recipeService.getAllRecipesCuisine());
        }
        

}