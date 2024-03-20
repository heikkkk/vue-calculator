package ntnu.idatt2105.henritsa.webcalculator.user.controller;

import java.util.List;
import ntnu.idatt2105.henritsa.webcalculator.user.dto.UserDto;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;
import ntnu.idatt2105.henritsa.webcalculator.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public UserDto createUser(
      @RequestBody UserDto dto
  ) {
      return this.userService.createUser(dto);
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(
      @RequestBody UserDto dto
      ) {
          if (userService.userExists(dto)) {
            return ResponseEntity.ok("Loin successful");
          } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                body("Invalid username or password");
          }
  }

  @GetMapping("/users")
  public List<UserDto> findAllUsers() {
    return this.userService.findAllUsers();
  }
}
