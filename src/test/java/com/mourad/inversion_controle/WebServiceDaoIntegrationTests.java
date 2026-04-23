package com.mourad.inversion_controle;

import com.mourad.inversion_controle.metier.IMetier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "dao.type=ws",
        "dao.ws.value=25",
        "business.multiplier=3"
})
class WebServiceDaoIntegrationTests {
    @Autowired
    private IMetier metier;

    @Test
    void calculUsesWebServiceDaoWhenConfigured() {
        assertEquals(75.0, metier.calcul());
    }
}
