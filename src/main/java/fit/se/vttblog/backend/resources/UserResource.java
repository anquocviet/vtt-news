package fit.se.vttblog.backend.resources;

import fit.se.vttblog.backend.dtos.CreateUserDto;
import fit.se.vttblog.backend.dtos.UserDto;
import fit.se.vttblog.backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: vie
 * @date: 3/11/24
 */
@RestController
@RequestMapping("/users")
public class UserResource {
   @Autowired
   private UserService userService;

   @GetMapping("/{id}")
   public ResponseEntity<UserDto> getUserById(@PathVariable("id") String id) {
      return ResponseEntity.ok(userService.getUser(id));
   }

   @PostMapping("/")
   public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUserDto userDto) {
      return ResponseEntity.ok(userService.createUser(userDto));
   }
}
