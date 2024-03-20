package ntnu.idatt2105.henritsa.webcalculator.expression.service;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import java.util.List;
import java.util.stream.Collectors;
import ntnu.idatt2105.henritsa.webcalculator.expression.dto.ExpressionDto;
import ntnu.idatt2105.henritsa.webcalculator.expression.dto.ExpressionResponseDto;
import ntnu.idatt2105.henritsa.webcalculator.expression.model.Expression;
import ntnu.idatt2105.henritsa.webcalculator.expression.repository.ExpressionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {
  Logger logger = LoggerFactory.getLogger(ExpressionService.class);

  private final DoubleEvaluator eval = new DoubleEvaluator();

  private final ExpressionRepository expressionRepository;
  private final ExpressionMapper expressionMapper;

  public ExpressionService(ExpressionRepository expressionRepository, ExpressionMapper expressionMapper) {
    this.expressionRepository = expressionRepository;
    this.expressionMapper = expressionMapper;
  }

  public List<Expression> calculateAnswer(Expression expression) {
    logger.info("Got expression: " + expression);
    logger.info("Expression value: " + expression.getExpression());

    Double result = eval.evaluate(expression.getExpression());

    logger.info("Expression eval: " + result);

    expression.setAnswer(result.toString());

    logger.info("Set expression answer");
    logger.info("Updated expression: " + expression);

    return List.of(expression);
  }

  public List<ExpressionResponseDto> getExpressions() {
    return this.expressionRepository.findAll()
        .stream()
        .map(expressionMapper::toExpressionResponseDto)
        .collect(Collectors.toList());
  }

  public ExpressionResponseDto saveExpression(ExpressionDto dto) {
    Expression expression = expressionMapper.toExpression(dto);
    Expression savedExpression = expressionRepository.save(expression);
    return expressionMapper.toExpressionResponseDto(savedExpression);
  }
}
