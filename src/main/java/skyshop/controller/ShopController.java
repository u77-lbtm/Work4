package skyshop.controller;

import skyshop.model.article.Article;
import skyshop.model.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import skyshop.model.search.SearchResult;
import skyshop.service.SearchService;
import skyshop.service.StorageService;

import java.util.Collection;

import static java.awt.SystemColor.text;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.title;

@RestController
public class ShopController implements Controller {

        private final StorageService storageService;
        private final SearchService searchService;

        // Внедряем StorageService через конструктор
        public ShopController(StorageService storageService, SearchService searchService) {
                this.storageService = storageService;
                this.searchService = searchService;

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
        @com.fasterxml.jackson.annotation.JsonIgnore
        @Override
        public String getSearchTerm() {
                return title + " " + text;
        }

        @com.fasterxml.jackson.annotation.JsonIgnore
        @Override
        public String getContentType() {
                return "ARTICLE";
        }
}