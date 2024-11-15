package fit.se.vttblog.frontend.controllers;

import fit.se.vttblog.backend.dtos.CreateUserDto;
import fit.se.vttblog.backend.dtos.UserDto;
import fit.se.vttblog.backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Controller
@RequestMapping("/users")
public class UserController {
   @Autowired
   private UserService userService;


   @GetMapping("/{id}")
   public ModelAndView getUserById(@PathVariable("id") String id) {
      ModelAndView mav = new ModelAndView("user");
      mav.addObject("user", userService.getUser(id));
      return mav;
   }

   @PostMapping("/")
   public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUserDto userDto) {
      return ResponseEntity.ok(userService.createUser(userDto));
   }
}
