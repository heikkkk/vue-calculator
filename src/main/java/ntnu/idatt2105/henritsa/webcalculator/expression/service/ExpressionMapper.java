package ntnu.idatt2105.henritsa.webcalculator.expression.service;

import ntnu.idatt2105.henritsa.webcalculator.expression.dto.ExpressionDto;
import ntnu.idatt2105.henritsa.webcalculator.expression.dto.ExpressionResponseDto;
import ntnu.idatt2105.henritsa.webcalculator.expression.model.Expression;
import ntnu.idatt2105.henritsa.webcalculator.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class ExpressionMapper {

  public Expression toExpression(ExpressionDto dto) {
    Expression expression = new Expression();
    expression.setExpression(dto.expression());
    expression.setAnswer(dto.answer());
    User user = new User();
    user.setId(dto.userId());
    expression.setUser(user);
    return expression;
  }

  public ExpressionResponseDto toExpressionResponseDto(Expression expression) {
    return new ExpressionResponseDto(
        expression.getAnswer());
  }
}
