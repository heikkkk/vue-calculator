package ntnu.idatt2105.henritsa.webcalculator.expression.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;

@Entity
public class Expression{
  @Id
  @GeneratedValue
  private Long id;

  private String expression;

  private String answer;

  @ManyToOne
  @JoinColumn(
      name = "user_id"
  )
  @JsonBackReference
  private User _user;

  public Expression(){}

  public Expression(String expression) {
    this.expression = expression;
  }

  public String getExpression() {
    return expression;
  }

  public String getAnswer(){
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return _user;
  }

  public void setUser(User _user) {
    this._user = _user;
  }

  @Override
  public String toString() {
    return "Expression{" +
        "expression='" + expression + '\'' +
        ", answer='" + answer + '\'' +
        '}';
  }
}
