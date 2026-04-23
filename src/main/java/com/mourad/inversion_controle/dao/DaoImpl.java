package com.mourad.inversion_controle.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "dao.type", havingValue = "local", matchIfMissing = true)
public class DaoImpl implements IDao {
    private final double localValue;

    public DaoImpl(@Value("${dao.local.value:10}") double localValue) {
        this.localValue = localValue;
    }

    @Override
    public double getData() {
        return localValue;
    }
}
