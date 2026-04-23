package com.mourad.inversion_controle.pres;

import com.mourad.inversion_controle.metier.IMetier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Presentation implements CommandLineRunner {
    private final IMetier metier;

    public Presentation(IMetier metier) {
        this.metier = metier;
    }

    @Override
    public void run(String... args) {
        double result = metier.calcul();
        System.out.println("Resultat metier = " + result);
    }
}
