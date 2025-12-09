package tech.suji.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.suji.model.User;
	
// JpaRepository<EntityClass, IdType>
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // --- 1. Query Derivation Methods ---

    /**
     * Finds a User by their username.
     * Spring generates the query: SELECT u FROM User u WHERE u.username = ?1
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a User by their email.
     * Spring generates the query: SELECT u FROM User u WHERE u.email = ?1
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds users whose creation date is after a given timestamp.
     * Spring generates the query based on the 'After' keyword.
     */
    List<User> findByCreatedAtAfter(LocalDateTime date);

    /**
     * Finds users whose username contains the search term (case-insensitive).
     * Spring generates a query using the LIKE operator (e.g., WHERE u.username LIKE %?1%).
     */
    List<User> findByUsernameContainingIgnoreCase(String partialUsername);

    // --- 2. Existence Checks ---

    /**
     * Checks if a user with the given username already exists.
     * This is optimized to return a boolean instead of fetching the entire entity.
     */
    boolean existsByUsername(String username);

    /**
     * Checks if a user with the given email already exists.
     */
    boolean existsByEmail(String email);
    
    // --- Standard Methods Inherited from JpaRepository ---
    
    // save(entity): Saves and updates an entity.
    // findById(id): Retrieves an entity by ID (returns Optional).
    // findAll(): Retrieves all entities (often used with pagination).
    // count(): Returns the total number of entities.
    // delete(entity): Deletes the given entity.
}