package skyshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skyshop.model.article.Article;
import skyshop.model.basket.UserBasket;
import skyshop.model.product.Product;
import skyshop.model.search.SearchResult;
import skyshop.service.BasketService;
import skyshop.service.SearchService;
import skyshop.service.StorageService;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ShopController {

        private final StorageService storageService;
        private final SearchService searchService;
        private final BasketService basketService;

        public ShopController(StorageService storageService,
                              SearchService searchService,
                              BasketService basketService) {
                this.storageService = storageService;
                this.searchService = searchService;
                this.basketService = basketService;
        }

        @GetMapping("/products")
        public Collection<Product> getAllProducts() {
                return storageService.getAllProducts();
        }

        @GetMapping("/articles")
        public Collection<Article> getAllArticles() {
                return storageService.getAllArticles();
        }

        @GetMapping("/search")
        public Collection<SearchResult> search(@RequestParam("pattern") String pattern) {
                return searchService.search(pattern);
        }


        @GetMapping("/basket/{id}")
        public String addProduct(@PathVariable("id") UUID id) {
                basketService.addProductToBasket(id);
                return "*Продукт успешно добавлен*";
        }


        @GetMapping("/basket")
        public UserBasket getUserBasket() {
                return basketService.getUserBasket();
        }
}
