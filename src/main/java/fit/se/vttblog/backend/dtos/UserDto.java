package fit.se.vttblog.backend.dtos;

import fit.se.vttblog.backend.entities.User;
import fit.se.vttblog.backend.enums.UserRole;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link User}
 */
public record UserDto(
      String id,
      String userName,
      String fullName,
      int age,
      int gender,
      String email,
      String password,
      String bio,
      String avatar,
      Instant createdAt,
      UserRole role
) implements Serializable {
}