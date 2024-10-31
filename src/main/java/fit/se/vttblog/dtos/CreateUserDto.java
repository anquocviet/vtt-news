package fit.se.vttblog.dtos;

import fit.se.vttblog.entities.User;
import fit.se.vttblog.enums.UserRole;
import fit.se.vttblog.exceptions.AppException;
import fit.se.vttblog.services.CypherService;
import fit.se.vttblog.validators.EnumValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

/**
 * DTO for {@link User}
 */
public record CreateUserDto(
      String id,

      @NotEmpty(message = "Username không được để trống")
      String userName,

      @NotEmpty(message = "Họ tên không được để trống")
      String fullName,

      @Min(value = 16, message = "Tuổi phải lớn hơn hoặc bằng 18")
      @Max(value = 100, message = "Tuổi phải nhỏ hơn hoặc bằng 100")
      int age,

      @Min(value = -1, message = "Giới tính không hợp lệ")
      @Max(value = 1, message = "Giới tính không hợp lệ")
      int gender,

      @Email(message = "Email không hợp lệ")
      String email,

      @NotEmpty(message = "Thiếu password")
      @Min(value = 6, message = "Password phải có ít nhất 6 ký tự")
      String password,

      Instant createdAt,

      @EnumValidator(
            enumClazz = UserRole.class,
            message = "Role không hợp lệ"
      )
      String role
) implements Serializable {
   @Override
   public String id() {
      return new ObjectId().toHexString();
   }

   @Override
   public Instant createdAt() {
      return Instant.now();
   }

   @Override
   public String password() {
      Optional<String> saltOpt = CypherService.generateSalt(512);
      if (saltOpt.isEmpty()) {
         throw new AppException(500, "Internal error");
      }
      Optional<String> passEncrypt = CypherService.hashPassword(password, saltOpt.get());
      if (passEncrypt.isEmpty()) {
         throw new AppException(500, "Internal error");
      }
      return passEncrypt.get();
   }
}