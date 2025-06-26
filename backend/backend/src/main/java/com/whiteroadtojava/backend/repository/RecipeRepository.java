package com.whiteroadtojava.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteroadtojava.backend.modul.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

        

}