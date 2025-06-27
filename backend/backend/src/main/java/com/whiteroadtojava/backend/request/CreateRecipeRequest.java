package com.whiteroadtojava.backend.request;

import com.whiteroadtojava.backend.modul.Recipe;
import com.whiteroadtojava.backend.modul.User;

import lombok.Data;
@Data
public class CreateRecipeRequest {
        private Recipe recipe;
        private User user;
}
