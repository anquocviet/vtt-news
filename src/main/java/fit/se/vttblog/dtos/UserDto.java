package fit.se.vttblog.dtos;

import fit.se.vttblog.enums.UserRole;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link fit.se.vttblog.entities.User}
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