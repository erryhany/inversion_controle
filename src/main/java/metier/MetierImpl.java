package com.mourad.inversion_controle.metier;

import com.mourad.inversion_controle.dao.IDao;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    private final IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getData() * 2;
    }
}
