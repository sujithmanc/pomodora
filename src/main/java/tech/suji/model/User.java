package tech.suji.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {
    // Defines the unique constraints from the database schema
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
@Data // Lombok: Generates getters, setters, toString, hashCode, and equals
@NoArgsConstructor // Lombok: Generates a constructor with no arguments
@AllArgsConstructor // Lombok: Generates a constructor with all arguments
public class User {

    // --- id (int(11) | NO | PRI | auto_increment) ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Maps to auto_increment
    private Integer id;

    // --- username (varchar(50) | NO | UNI) ---
    // unique constraint is handled at the class level via @Table(uniqueConstraints)
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    // --- email (varchar(100) | NO | UNI) ---
    // unique constraint is handled at the class level via @Table(uniqueConstraints)
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    // --- password (varchar(255) | NO) ---
    @Column(name = "password", nullable = false)
    private String password;

    // --- created_at (timestamp | NO | Default: current_timestamp()) ---
    @Column(name = "created_at", nullable = false, updatable = false)
    // Use PrePersist to set the timestamp when the entity is first persisted
    private LocalDateTime createdAt;

    // Set 'created_at' automatically upon persistence
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}