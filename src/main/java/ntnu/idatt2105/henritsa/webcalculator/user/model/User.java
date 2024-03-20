package ntnu.idatt2105.henritsa.webcalculator.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ntnu.idatt2105.henritsa.webcalculator.expression.model.Expression;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "_user"
)
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Long id;
  @Column(unique=true)
  private String name;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(
      mappedBy = "_user"
  )
  @JsonManagedReference
  private List<Expression> expressions;

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + name + '\'' +
        ", password='" + password + '\'' +
        ", expressions=" + expressions +
        '}';
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
