package com.mourad.inversion_controle;

import com.mourad.inversion_controle.api.CalculationResponse;
import com.mourad.inversion_controle.api.StatusResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "dao.type=local",
                "dao.local.value=12",
                "business.multiplier=2"
        }
)
class CalculationControllerIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void calculationEndpointReturnsExpectedResult() {
        CalculationResponse response = restTemplate.getForObject("/api/v1/calculation", CalculationResponse.class);
        assertEquals(24.0, response.result());
    }

    @Test
    void healthEndpointReturnsUp() {
        StatusResponse response = restTemplate.getForObject("/api/v1/health", StatusResponse.class);
        assertEquals("UP", response.status());
    }
}
