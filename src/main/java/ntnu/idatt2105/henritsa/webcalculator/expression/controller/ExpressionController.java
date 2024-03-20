package ntnu.idatt2105.henritsa.webcalculator.expression.controller;

import java.util.List;
import ntnu.idatt2105.henritsa.webcalculator.expression.dto.ExpressionDto;
import ntnu.idatt2105.henritsa.webcalculator.expression.dto.ExpressionResponseDto;
import ntnu.idatt2105.henritsa.webcalculator.expression.model.Expression;
import ntnu.idatt2105.henritsa.webcalculator.expression.service.ExpressionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/expressions")
public class ExpressionController {

  Logger logger = LoggerFactory.getLogger(ExpressionController.class);

  private final ExpressionService expressionService;

  public ExpressionController(ExpressionService expressionService) {
    this.expressionService = expressionService;
  }

  @PostMapping("/answer")
  @CrossOrigin(origins = "http://localhost:5173")
  public List<Expression> getAnswer(@RequestBody Expression expression) {
    logger.info("POST at /api/calculator/answer" + " with body: " + expression.getExpression());
    return this.expressionService.calculateAnswer(expression);
  }

  @PostMapping("/create")
  public ExpressionResponseDto saveExpression(
      @RequestBody ExpressionDto dto
  ) {
    return this.expressionService.saveExpression(dto);
  }

  @GetMapping("/expressions")
  public List<ExpressionResponseDto> getExpressions(){
    return this.expressionService.getExpressions();
  }
}

