package skyshop.controller;

import skyshop.model.article.Article;
import skyshop.model.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import skyshop.service.StorageService;

import java.util.Collection;

@RestController
public class ShopController {

        private final StorageService storageService;

        // Внедряем StorageService через конструктор
        public ShopController(StorageService storageService) {
                this.storageService = storageService;
        }

        @GetMapping("/products")
        public Collection<Product> getAllProducts() {
                return storageService.getAllProducts();
        }

        @GetMapping("/articles")
        public Collection<Article> getAllArticles() {
                return storageService.getAllArticles();
        }
}
