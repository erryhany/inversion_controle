package com.mourad.inversion_controle.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements IDao {
    @Override
    public double getData() {
        return 10.0;
    }
}
