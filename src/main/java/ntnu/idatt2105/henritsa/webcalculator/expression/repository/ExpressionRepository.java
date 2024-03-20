package ntnu.idatt2105.henritsa.webcalculator.expression.repository;

import ntnu.idatt2105.henritsa.webcalculator.expression.model.Expression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ExpressionRepository extends JpaRepository<Expression, Long> {
}
