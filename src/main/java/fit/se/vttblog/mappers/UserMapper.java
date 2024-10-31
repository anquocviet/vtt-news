package fit.se.vttblog.mappers;

import fit.se.vttblog.dtos.CreateUserDto;
import fit.se.vttblog.dtos.UserDto;
import fit.se.vttblog.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper  {
   UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

   User createUserToUser(CreateUserDto userDto);

   UserDto userToUserDto(User user);

   User userDtoToUser(UserDto userDto);
}
