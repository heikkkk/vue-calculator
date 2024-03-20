package ntnu.idatt2105.henritsa.webcalculator.auth;

import lombok.RequiredArgsConstructor;
import ntnu.idatt2105.henritsa.webcalculator.config.JwtService;
import ntnu.idatt2105.henritsa.webcalculator.user.model.Role;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;
import ntnu.idatt2105.henritsa.webcalculator.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .name(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );
    var user = userRepository.findUserByName(request.getUsername())
        .orElseThrow(); //TODO handle exception
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
