package fit.se.vttblog.repositories;

import fit.se.vttblog.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String>, CrudRepository<User, String> {
   @Query("update User u set u.deletedAt = instant where u.id = ?1")
   @Modifying
   boolean delete(String id);

   boolean existsUserByEmail(@Email(message = "Email không hợp lệ") String email);

   boolean existsUserByUserName(@NotEmpty(message = "Thiếu username") String userName);
}