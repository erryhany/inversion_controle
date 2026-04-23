package com.mourad.inversion_controle.api;

import com.mourad.inversion_controle.metier.IMetier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "${app.cors.allowed-origin:http://localhost:4200}")
public class CalculationController {
    private final IMetier metier;

    public CalculationController(IMetier metier) {
        this.metier = metier;
    }

    @GetMapping("/calculation")
    public CalculationResponse getCalculation() {
        return new CalculationResponse(metier.calcul());
    }

    @GetMapping("/health")
    public StatusResponse health() {
        return new StatusResponse("UP");
    }
}
