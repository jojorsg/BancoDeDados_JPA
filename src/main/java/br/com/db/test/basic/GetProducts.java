package br.com.db.test.basic;

import br.com.db.infra.ProductDAO;
import br.com.db.model.basic.Product;

import java.util.List;

public class GetProducts {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.obtainAll();

        for(Product product: products) {
            String message = "ID: " + product.getId() + ", Nome: " + product.getName() + ", Preço: " + product.getPrice();
            System.out.println(message);
        }

        double priceTotal = products.stream()
                .map(p -> p.getPrice())
                .reduce(0.0, (t, p) -> t + p)
                .doubleValue();
        System.out.println("O valor total é R$ " + priceTotal);

        dao.close();
    }
}
