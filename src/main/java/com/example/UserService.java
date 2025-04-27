package com.example;

import com.framework.annotations.Component;
import com.framework.annotations.Inject;
import com.framework.annotations.Initialize;
import com.framework.aspects.Transactional;

@Component
public class UserService {
    @Inject
    private UserRepository userRepository;
    
    @Initialize(order = 1)
    public void setup() {
        System.out.println("Initializing UserService");
    }
    
    @Transactional
    public User findUser(Long id) {
        return userRepository.findById(id);
    }
}