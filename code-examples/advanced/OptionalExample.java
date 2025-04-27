public class OptionalExample {
    // Creating Optionals
    Optional<String> empty = Optional.empty();
    Optional<String> present = Optional.of("Hello");
    Optional<String> nullable = Optional.ofNullable(getValue());
    
    // Using Optional
    public String findUserName(Long id) {
        return Optional.ofNullable(findUserById(id))
            .map(User::getName)
            .orElse("Unknown User");
    }
    
    public void demonstrateOptional() {
        Optional<User> user = findUser("john@example.com");
        
        // If present
        user.ifPresent(u -> sendEmail(u.getEmail()));
        
        // Or else
        User defaultUser = user.orElseGet(() -> new User("guest"));
        
        // Filter and map
        String displayName = user
            .filter(u -> u.getAge() >= 18)
            .map(User::getDisplayName)
            .orElse("Restricted User");
            
        // Or else throw
        User requiredUser = user
            .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}