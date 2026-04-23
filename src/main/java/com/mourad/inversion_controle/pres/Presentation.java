package com.mourad.inversion_controle.pres;

import com.mourad.inversion_controle.metier.IMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Presentation implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Presentation.class);
    private final IMetier metier;

    public Presentation(IMetier metier) {
        this.metier = metier;
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Resultat metier = {}", metier.calcul());
    }
}
