package ntnu.idatt2105.henritsa.webcalculator.expression.dto;

public record ExpressionDto(
    String expression,
    String answer,
    Long userId
) {

}
