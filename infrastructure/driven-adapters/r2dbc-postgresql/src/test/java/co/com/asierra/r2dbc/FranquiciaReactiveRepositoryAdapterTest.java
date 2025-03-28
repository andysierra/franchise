package co.com.asierra.r2dbc;

import co.com.asierra.r2dbc.repository.franquicia.FranquiciaReactiveRepositoryAdapter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FranquiciaReactiveRepositoryAdapterTest {
    // TODO: change four you own tests

    @InjectMocks
    FranquiciaReactiveRepositoryAdapter repositoryAdapter;

//    @Mock
//    MyReactiveRepository repository;
//
//    @Mock
//    ObjectMapper mapper;
//
//    @Test
//    void mustFindValueById() {
//
//        when(repository.findById("1")).thenReturn(Mono.just("test"));
//        when(mapper.map("test", Object.class)).thenReturn("test");
//
//        Mono<Object> result = repositoryAdapter.findById("1");
//
//        StepVerifier.create(result)
//                .expectNextMatches(value -> value.equals("test"))
//                .verifyComplete();
//    }
//
//    @Test
//    void mustFindAllValues() {
//        when(repository.findAll()).thenReturn(Flux.just("test"));
//        when(mapper.map("test", Object.class)).thenReturn("test");
//
//        Flux<Object> result = repositoryAdapter.findAll();
//
//        StepVerifier.create(result)
//                .expectNextMatches(value -> value.equals("test"))
//                .verifyComplete();
//    }
//
//    @Test
//    void mustFindByExample() {
//        when(repository.findAll(any(Example.class))).thenReturn(Flux.just("test"));
//        when(mapper.map("test", Object.class)).thenReturn("test");
//
//        Flux<Object> result = repositoryAdapter.findByExample("test");
//
//        StepVerifier.create(result)
//                .expectNextMatches(value -> value.equals("test"))
//                .verifyComplete();
//    }
//
//    @Test
//    void mustSaveValue() {
//        when(repository.save("test")).thenReturn(Mono.just("test"));
//        when(mapper.map("test", Object.class)).thenReturn("test");
//
//        Mono<Object> result = repositoryAdapter.save("test");
//
//        StepVerifier.create(result)
//                .expectNextMatches(value -> value.equals("test"))
//                .verifyComplete();
//    }
}
