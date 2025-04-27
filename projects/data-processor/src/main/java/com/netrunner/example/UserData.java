package com.netrunner.example;

import com.netrunner.annotations.*;
import com.netrunner.transformers.*;
import java.util.Date;

@DataProcessor(
    value = "userProcessor",
    version = "1.0",
    mode = DataProcessor.ProcessingMode.ASYNC
)
public class UserData {
    @Validate(
        pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
        message = "Email inválido"
    )
    private String email;
    
    @Transform(transformer = EncryptTransformer.class)
    @Validate(required = true, minLength = 8)
    private String password;
    
    @Transform(
        transformer = DateFormatTransformer.class,
        params = "yyyy-MM-dd"
    )
    private Date birthDate;
    
    @Persist(strategy = "JDBC", async = true)
    private UserProfile profile;

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}