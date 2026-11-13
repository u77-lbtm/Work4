package skyshop.model.article;

import skyshop.model.search.Searchable;
import java.util.UUID;

public final class Article implements Searchable {
    private final String title;
    private final String text;
    private final UUID id;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
        this.id = UUID.randomUUID();
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }


    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getContentType() {
        return "Статья";
    }

    @Override
    public String getName() {
        return title;
    }
    @Override
    public UUID getId() {
        return null;
    }


    @Override
    public String toString() {
        return title + "\n" + text;
    }
}




