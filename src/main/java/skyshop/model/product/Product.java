
package skyshop.model.product;
import skyshop.model.search.Searchable;
import java.util.*;




public abstract class Product implements Searchable {

    private final String name;
   private final UUID id;



    public Product(String name) {
        this.name = name;
        this.id=UUID.randomUUID();
        if (name == null) {
            throw new IllegalArgumentException("Имя продукта не может быть null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может состоять только из пробелов");
        }


        System.out.println("Данные корректны: " + name);
    }
    @Override
            public UUID getId(){

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
