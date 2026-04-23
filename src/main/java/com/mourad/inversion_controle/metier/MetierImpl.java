package com.mourad.inversion_controle.metier;

import com.mourad.inversion_controle.dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    private final IDao dao;
    private final double multiplier;

    public MetierImpl(IDao dao, @Value("${business.multiplier:2}") double multiplier) {
        this.dao = dao;
        this.multiplier = multiplier;
    }

    @Override
    public double calcul() {
        return dao.getData() * multiplier;
    }
}
