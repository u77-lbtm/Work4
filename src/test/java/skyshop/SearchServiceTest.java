package skyshop;
import org.junit.jupiter.api.Test;
import skyshop.service.SearchService;
import skyshop.service.StorageService;
import skyshop.model.product.SimpleProduct;
import skyshop.model.search.Searchable;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SearchServiceTest {
    @Test
    void returnsEmptyWhenStorageHasNoObjects() {
        StorageService storage = mock(StorageService.class);
        when(storage.getAllSearchables()).thenReturn(Collections.emptyList());

        SearchService search = new SearchService(storage);

        assertTrue(search.search("яблоко").isEmpty());
    }

    @Test
    void returnsEmptyWhenNothingMatches() {
        StorageService storage = mock(StorageService.class);
        when(storage.getAllSearchables()).thenReturn(
                Collections.<Searchable>singletonList(
                        new SimpleProduct("Хлеб", 50)
                )
        );
        SearchService search = new SearchService(storage);
        assertTrue(search.search("телефон").isEmpty());
    }

    @Test
    void returnsMatchingObject() {
        StorageService storage = mock(StorageService.class);
        when(storage.getAllSearchables()).thenReturn(
                Collections.<Searchable>singletonList(
                        new SimpleProduct("Яблоко", 100)
                )
        );

        SearchService search = new SearchService(storage);
        var results = search.search("яблоко");

        assertFalse(results.isEmpty());
        assertEquals("Яблоко", results.iterator().next().getName());
    }

    @Test
    void returnsOnlyMatchingObjects() {
        StorageService storage = mock(StorageService.class);
        when(storage.getAllSearchables()).thenReturn(Arrays.<Searchable>asList(
                new SimpleProduct("Яблоко", 100),
                new SimpleProduct("Хлеб", 50)
        ));

        SearchService search = new SearchService(storage);

        assertEquals(1, search.search("яблоко").size());
    }
}