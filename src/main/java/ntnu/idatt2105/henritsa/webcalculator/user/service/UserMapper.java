package ntnu.idatt2105.henritsa.webcalculator.user.service;

import ntnu.idatt2105.henritsa.webcalculator.user.dto.UserDto;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
  public UserDto toUserDto(User user) {
    return new UserDto(user.getName(), user.getPassword());
  }

  public User toUser(UserDto dto) {
    User user = new User();
    user.setName(dto.username());
    user.setPassword(dto.password());
    return user;
  }

}
