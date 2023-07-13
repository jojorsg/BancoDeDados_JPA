package br.com.db.test.basic.order;

import br.com.db.infra.DAO;
import br.com.db.model.basic.ItemOrdered;
import br.com.db.model.basic.OrderEntity;
import br.com.db.model.basic.Product;

public class NewOrder {

    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>();

        OrderEntity order = new OrderEntity();
        Product product = new Product("Geladeira", 2789.99);
        ItemOrdered item = new ItemOrdered(order, product, 10);

        dao.openTransaction()
                .include(product)
                .include(order)
                .include(item)
                .closeTransaction()
                .close();
    }
}
