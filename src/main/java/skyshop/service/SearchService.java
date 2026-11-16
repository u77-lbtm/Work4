package skyshop.service;

import org.springframework.stereotype.Service;
import skyshop.model.search.SearchResult;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    // Spring автоматически передаст сюда экземпляр StorageService при старте приложения
    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String pattern) {
        return storageService.getAllSearchables().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
