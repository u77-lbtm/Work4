package skyshop.service;

import org.springframework.stereotype.Service;
import skyshop.model.article.Article;

import skyshop.model.search.Searchable;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import skyshop.model.product.Product;
import skyshop.model.product.SimpleProduct;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        fillTestData(); // Автоматически заполняем хранилище при создании
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> allItems = new ArrayList<>();
        allItems.addAll(products.values());
        allItems.addAll(articles.values());
        return allItems;
    }

    private void fillTestData() {
        Product apple = new SimpleProduct("Яблоко", 100);
        Product bread = new SimpleProduct("Хлеб", 50);

        products.put(apple.getId(), apple);
        products.put(bread.getId(), bread);

        Article article1 = new Article("Польза яблок", "Яблоки содержат много железа и витаминов.");
        Article article2 = new Article("Как выбрать свежий хлеб", "Обращайте внимание на хрустящую корочку.");

        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
    }
}
