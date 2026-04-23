package com.mourad.inversion_controle.ex1;

import com.mourad.inversion_controle.dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "dao.type", havingValue = "ws")
public class DaoWebServiceImpl implements IDao {
    private final double wsValue;

    public DaoWebServiceImpl(@Value("${dao.ws.value:15}") double wsValue) {
        this.wsValue = wsValue;
    }

    @Override
    public double getData() {
        return wsValue;
    }
}
