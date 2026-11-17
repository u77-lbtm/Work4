package skyshop.controller;

public interface Controller {
    @com.fasterxml.jackson.annotation.JsonIgnore
    String getSearchTerm();

    @com.fasterxml.jackson.annotation.JsonIgnore
    String getContentType();
}
