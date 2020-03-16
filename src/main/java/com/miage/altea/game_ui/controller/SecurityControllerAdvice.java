package com.miage.altea.game_ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.executable.ValidateOnExecution;
import java.security.Principal;

@ControllerAdvice
public class SecurityControllerAdvice {




    @ModelAttribute(value="user")
    Object principal(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}