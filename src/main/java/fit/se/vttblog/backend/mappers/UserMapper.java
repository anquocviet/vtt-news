package fit.se.vttblog.backend.mappers;

import fit.se.vttblog.backend.dtos.CreateUserDto;
import fit.se.vttblog.backend.dtos.UserDto;
import fit.se.vttblog.backend.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper  {
   User createUserToUser(CreateUserDto userDto);

   UserDto userToUserDto(User user);

   User userDtoToUser(UserDto userDto);
}
