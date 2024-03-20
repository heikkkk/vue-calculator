package ntnu.idatt2105.henritsa.webcalculator.user.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import ntnu.idatt2105.henritsa.webcalculator.user.dto.UserDto;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;
import ntnu.idatt2105.henritsa.webcalculator.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public UserDto createUser(UserDto dto) {
    User user = userMapper.toUser(dto);
    userRepository.save(user);
    return dto;
  }

  public List<UserDto> findAllUsers() {
    return userRepository.findAll()
        .stream()
        .map(userMapper::toUserDto)
        .collect(Collectors.toList());
  }

  public boolean userExists(UserDto dto) {
    Optional<User> user = userRepository.findUserByName(dto.username());
    return user.isPresent() && user.get().getPassword().equals(dto.password());
  }
}
