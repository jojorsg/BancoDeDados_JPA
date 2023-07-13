package br.com.db.test.basic.product;

import br.com.db.infra.DAO;
import br.com.db.model.basic.Product;

public class NewProduct {

    public static void main(String[] args) {

        Product product = new Product("Monitor", 798.55);

        DAO< Product> dao = new DAO<>(Product.class);
        dao.openTransaction().include(product).closeTransaction().close();

        System.out.println("O produto foi adicionado com sucesso e seu ID é: " + product.getId());
    }
}
