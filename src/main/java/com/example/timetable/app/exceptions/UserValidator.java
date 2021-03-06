package com.example.timetable.app.exceptions;


import com.example.timetable.app.login.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserValidator implements ConstraintValidator<UserValidation, String> {
    @Autowired
    LoginDAO loginDAO;

    @Override
    public void initialize(UserValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
      boolean t = false;

        try {
            return !loginDAO.checkExistByName(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }
}
