package skyshop.service;

import org.springframework.stereotype.Service;
import skyshop.model.basket.BasketItem;
import skyshop.model.basket.ProductBasket;
import skyshop.model.basket.UserBasket;
import skyshop.model.product.Product;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID id) {
        Product product = storageService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Продукт с id " + id + " не найден"));

        productBasket.addProduct(product.getId());
    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = productBasket.getProducts().entrySet().stream()
                .map(entry -> {
                    Product product = storageService.getProductById(entry.getKey())
                            .orElseThrow(() -> new IllegalArgumentException("Продукт не найден"));
                    return new BasketItem(product, entry.getValue());
                })
                .collect(Collectors.toList());

        return new UserBasket(items);
    }
}
