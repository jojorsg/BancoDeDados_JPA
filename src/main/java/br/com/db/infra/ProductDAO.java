package br.com.db.infra;

import br.com.db.model.basic.Product;

public class ProductDAO extends DAO<Product> {

    public ProductDAO() {
        super(Product.class);
    }
}
