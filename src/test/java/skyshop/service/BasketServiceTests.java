package skyshop.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import skyshop.exception.NoSuchProductException;
import skyshop.model.basket.ProductBasket;
import skyshop.model.basket.UserBasket;
import skyshop.model.product.SimpleProduct;

class BasketServiceTests {

    private final StorageService storage = Mockito.mock(StorageService.class);
    private final ProductBasket basket = Mockito.mock(ProductBasket.class);
    private final BasketService service = new BasketService(basket, storage);

    @Test
    void throwsWhenAddingProductThatDoesNotExist() {
        UUID id = UUID.randomUUID();
        Mockito.when(storage.getProductById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchProductException.class,
                () -> service.addProductToBasket(id));
    }


    @Test
    void addsExistingProductToBasket() {
        SimpleProduct product = new SimpleProduct("Яблоко", 100);
        UUID id = product.getId();
        Mockito.when(storage.getProductById(id)).thenReturn(Optional.of(product));

        service.addProductToBasket(id);

        Mockito.verify(basket).addProduct(id);
    }


    @Test
    void returnsEmptyBasketWhenThereAreNoProducts() {
        Mockito.when(basket.getProducts()).thenReturn(Collections.emptyMap());

        UserBasket userBasket = service.getUserBasket();

        assertTrue(userBasket.getItems().isEmpty());
    }

    @Test
    void returnsBasketWithProducts() {
        SimpleProduct product = new SimpleProduct("Яблоко", 100);
        UUID id = product.getId();

        Mockito.when(basket.getProducts()).thenReturn(Map.of(id, 2));
        Mockito.when(storage.getProductById(id)).thenReturn(Optional.of(product));

        UserBasket userBasket = service.getUserBasket();

        assertEquals(1, userBasket.getItems().size());
        assertEquals(product, userBasket.getItems().get(0).getProduct());
        assertEquals(2, userBasket.getItems().get(0).getQuantity());
    }

}
