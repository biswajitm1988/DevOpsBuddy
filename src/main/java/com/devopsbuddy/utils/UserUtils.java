package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;

import javax.servlet.http.HttpServletRequest;


public class UserUtils {

    /**
     * Non instantiable.
     */
    private UserUtils() {
        throw new AssertionError("Non instantiable");
    }

    /**
     * Creates a user with basic attributes set.
     * @param username The username.
     * @param email The email.
     * @return A User entity
     */
    public static User createBasicUser() {

        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("abc@xyz.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("123456789123");
        user.setCountry("GB");
        user.setEnabled(true);
        user.setDescription("A basic user");
        user.setProfileImageUrl("https://blabla.images.com/basicuser");

        return user;
    }

}