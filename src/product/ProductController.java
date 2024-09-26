package product;

import java.util.ArrayList;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;

public class ProductController {
    private ArrayList<ProductModel> products;

    public String create(ProductModel payload) {
        if (payload.getPriceInCents() <= 0)
            throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
        products.add(payload);
        return String.format("Produto % adicionado.", payload.getName());
    }

    public ArrayList<ProductModel> read() {
        return products;
    }

    public int retrievePrice(String barCode) {
        ProductModel foundProduct = products.stream().filter(product -> product.getBarCode() == barCode).findFirst().orElse(null);
        if (foundProduct == null)
            throw new NotFoundException(String.format("Product % not found.", barCode));
        return foundProduct.getPriceInCents();
    }
}
