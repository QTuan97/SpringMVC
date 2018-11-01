package com.something.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class User implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String name;

    @Min(18)
    private int age;

    private String phonenumber;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String phonenumber = user.getPhonenumber();
        ValidationUtils.rejectIfEmpty(errors, "phonenumber", "number.empty");
        if (phonenumber.length()>11 || phonenumber.length()<10){
            errors.rejectValue("phonenumber", "number.length");
        }
        if (!phonenumber.startsWith("0")){
            errors.rejectValue("phonenumber", "number.startsWith");
        }
        if (!phonenumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phonenumber", "number.matches");
        }
        String useremail = user.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (!useremail.matches("^\\w{5,}@\\w+\\.(com|edu|gov)$")){
            errors.rejectValue("email","email.wronginput");
        }
    }
}
