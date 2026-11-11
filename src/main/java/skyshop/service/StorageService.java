package skyshop.service;

import skyshop.model.article.Article;
import skyshop.model.product.Product;
import skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        fillTestData(); // Автоматически заполняем хранилище при создании
    }

    // Метод для получения всех продуктов
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    // Метод для получения всех статей
    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    // Метод для получения всех объектов (продуктов и статей) для поиска
    public Collection<Searchable> getAllSearchables() {
        List<Searchable> allItems = new ArrayList<>();
        allItems.addAll(products.values());
        allItems.addAll(articles.values());
        return allItems;
    }


    // Приватный метод для заполнения хранилища начальными данными
    private void fillTestData() {
        // Примечание: если Product у вас abstract, подставьте сюда конкретных наследников
        // Например: SimpleProduct, DiscountedProduct и т.д.
        /*
        Product apple = new SimpleProduct("Яблоко", 100);
        products.put(apple.getId(), apple);
        */

        Article article1 = new Article("Польза яблок", "Яблоки содержат много железа и витаминов.");
        Article article2 = new Article("Как выбрать свежий хлеб", "Обращайте внимание на хрустящую корочку.");

        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
    }
}
