package fit.se.vttblog.backend.services;

import fit.se.vttblog.backend.dtos.CreateUserDto;
import fit.se.vttblog.backend.dtos.UserDto;
import fit.se.vttblog.backend.entities.User;
import fit.se.vttblog.backend.enums.UserRole;
import fit.se.vttblog.backend.exceptions.AppException;
import fit.se.vttblog.backend.mappers.UserMapper;
import fit.se.vttblog.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 31/10/24
 */
@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private UserMapper userMapper;


   public UserDto createUser(CreateUserDto createUserDto) {
      boolean emailExist = userRepository.existsUserByEmail(createUserDto.email());
      boolean usernameExist = userRepository.existsUserByUserName(createUserDto.userName());
      if (emailExist) {
         throw new AppException(404, "Email đã được sử dụng");
      }
      if (usernameExist) {
         throw new AppException(404, "Username đã được sử dụng");
      }
      if (createUserDto.role().equals(UserRole.ADMINISTRATOR.name())) {
         throw new AppException(404, "Tạm thời không thể tạo tài khoản admin");
      }

      User user = userMapper.createUserToUser(createUserDto);
      User save = userRepository.save(user);
      return userMapper.userToUserDto(save);
   }

   public UserDto updateUser(UserDto userDto) {
      User user = userMapper.userDtoToUser(userDto);
      User save = userRepository.save(user);
      return userMapper.userToUserDto(save);
   }

   public boolean deleteUser(String id) {
      User user = userRepository.findById(id).orElse(null);
      if (user != null) {
         return userRepository.delete(id);
      }
      return false;
   }

   public UserDto getUser(String id) {
      Optional<User> user = userRepository.findById(id);
      if (user.isPresent()) {
         return userMapper.userToUserDto(user.get());
      }
      throw new AppException(404, "User không tồn tại");
   }

}
