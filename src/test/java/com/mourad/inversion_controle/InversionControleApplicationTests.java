package com.mourad.inversion_controle;

import com.mourad.inversion_controle.metier.IMetier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InversionControleApplicationTests {
    @Autowired
    private IMetier metier;

    @Test
    void contextLoads() {
    }

    @Test
    void calculUsesDaoValue() {
        assertEquals(20.0, metier.calcul());
    }

}
