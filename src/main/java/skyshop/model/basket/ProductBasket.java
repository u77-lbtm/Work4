
package skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

    @Component
    @SessionScope
    public class ProductBasket {

        // Ключ — UUID товара из каталога, значение — количество единиц в корзине
        private final Map<UUID, Integer> products = new HashMap<>();

        /**
         * Добавление продукта в корзину по его UUID.
         * Если товар уже есть — увеличивает счетчик на 1.
         */
        public void addProduct(UUID id) {
            if (id != null) {
                products.merge(id, 1, Integer::sum);
            }
        }

        /**
         * Возвращает неизменяемую мапу со всеми товарами и их количеством.
         * Нужна сервису (BasketService) для формирования ответа и подсчета суммы.
         */
        public Map<UUID, Integer> getProducts() {
            return Collections.unmodifiableMap(products);
        }

        /**
         * Проверяет, пуста ли корзина.
         */
        public boolean isEmpty() {
            return products.isEmpty();
        }

        /**
         * Проверяет наличие продукта по UUID.
         */
        public boolean hasProduct(UUID id) {
            return id != null && products.containsKey(id);
        }

        /**
         * Удаляет продукт из корзины полностью по его UUID.
         */
        public void removeProduct(UUID id) {
            if (id != null) {
                products.remove(id);
            }
        }
    }


