package tech.suji.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.suji.model.User;
import tech.suji.service.UserRepository;

@RestController
@RequestMapping("/api/users") // Base path for all methods in this controller
public class UserController {

    // 1. Autowire the Repository
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // --- 2. Define the GET Endpoint ---
    
    /**
     * Handles GET requests to /api/users
     * Returns a JSON list of all User entities.
     * @return List of all User objects
     */
    @GetMapping 
    public List<User> getAllUsers() {
        // JpaRepository provides the findAll() method implementation automatically.
        // Spring handles converting the List<User> to a JSON array response.
        return userRepository.findAll();
    }
}