package com.example.cocks_recipe.service.recipe;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.model.User;
import com.example.cocks_recipe.repository.RecipeRepository;
import com.example.cocks_recipe.repository.UserRepository;
import com.example.cocks_recipe.request.CreateRecipeRequest;
import com.example.cocks_recipe.request.RecipeUpdateRequest;


@Service 
@RequiredArgsConstructor
public class RecipeServiceImpl  {

        private final RecipeRepository recipeRepsitory;
        private final UserRepository userRepository;
/* 
        @Override
        public Recipe createRecipe(CreateRecipeRequest request) {
                if (request == null || request.getUser() == null) {
                                throw new IllegalArgumentException("Invalid request or user.");
                }
                User user = Optional.ofNullable(userRepository.findByUsername(request.getUser().getUsername())).map(existingUser -> {
                        existingUser.getRecipes().add(request.getRecipe());
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
        public Recipe updateRecipe(RecipeUpdateRequest request, String recipeId) {
                Recipe recipe = getRecipeById(recipeId);
                Recipe theRecipe = RecipeService.updateRecipe(recipe, request);
                return recipeRepsitory.save(theRecipe);
        }

        @Override
        public List<Recipe> getAllRecipes() {
                return recipeRepsitory.findAll();

        }

        @Override
        public Recipe getRecipeById(String id) {
                return recipeRepsitory.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + id));   
        }

        @Override
        public void deleteRecipe(String id) {
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
                                */
}