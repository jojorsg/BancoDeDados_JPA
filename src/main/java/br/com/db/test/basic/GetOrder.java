package br.com.db.test.basic;

import br.com.db.infra.DAO;
import br.com.db.model.basic.ItemOrdered;
import br.com.db.model.basic.OrderEntity;

public class GetOrder {

    public static void main(String[] args) {

        DAO< OrderEntity> dao = new DAO<>(OrderEntity.class);

        OrderEntity order = dao.getByID(1L);

        for(ItemOrdered item : order.getItems()) {
            System.out.println(item.getAmount());
            System.out.println(item.getProduct().getName());
        }

        dao.close();
    }
}
