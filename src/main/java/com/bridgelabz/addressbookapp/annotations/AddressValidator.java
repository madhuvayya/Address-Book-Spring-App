package com.bridgelabz.addressbookapp.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressValidator implements ConstraintValidator<Address, String> {
    @Override
    public void initialize(Address constraintAnnotation) { }

    @Override
    public boolean isValid(String address, ConstraintValidatorContext context) {
        String[] words = address.split(",");
        if (words.length < 2) return false;
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9-.:/]{3,}$");
        int count = 0;
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) { count++; }
        }
        return count == words.length;
    }
}
