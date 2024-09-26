package product;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import java.util.ArrayList;

public class ProductController {
    private ArrayList<ProductModel> products;

    public String create(ProductModel payload) {
        try {
            if (payload.getPriceInCents() <= 0)
                throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
            products.add(payload);
            return String.format("Produto % adicionado.", payload.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public ArrayList<ProductModel> read() {
        return products;
    }

    public int retrievePrice(String barCode) {
        try {
            ProductModel foundProduct = products.stream().filter(product -> product.getBarCode() == barCode).findFirst().orElse(null);
            if (foundProduct == null)
                throw new NotFoundException(String.format("Product % not found.", barCode));
            return foundProduct.getPriceInCents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
