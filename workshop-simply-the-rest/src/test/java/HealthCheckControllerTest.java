import controller.HealthCheckController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HealthCheckControllerTest {

    private static final String HEALTHY = "Up & Running";

    @Test
    void isHealthy() {
        // Arrange
        HealthCheckController healthCheckController = new HealthCheckController();

        // Act
        String healthy = healthCheckController.healthy();

        // Assert
        Assertions.assertEquals(HEALTHY, healthy);
    }

}
