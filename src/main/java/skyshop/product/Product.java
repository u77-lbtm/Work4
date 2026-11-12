package skyshop.product;

import skyshop.model.search.Searchable;
import java.util.UUID;

public abstract class Product implements Searchable {

    private final String name;
    private final UUID id;

    public Product(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может состоять только из пробелов");
        }

        this.name = name;
        this.id = UUID.randomUUID();
        System.out.println("Данные корректны: " + name);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }
}
