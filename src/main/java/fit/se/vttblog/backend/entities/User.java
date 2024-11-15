package fit.se.vttblog.backend.entities;

import fit.se.vttblog.backend.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
   @Id
   @Column(name = "id", nullable = false, length = 24)
   private String id;

   @Column(name = "username", nullable = false, length = 50)
   private String userName;

   @Column(name = "fullname")
   private String fullName;

   private int age;

   private int gender;

   @Column(nullable = false, unique = true)
   private String email;

   @Column(nullable = false)
   private String password;

   private String bio;

   private String avatar;

   @Column(name = "created_at")
   private Instant createdAt;

   @Column(name = "deleted_at")
   private Instant deletedAt;

   @Enumerated(EnumType.STRING)
   private UserRole role;

   @OneToMany(mappedBy = "user")
   private Set<Payment> payments;
}