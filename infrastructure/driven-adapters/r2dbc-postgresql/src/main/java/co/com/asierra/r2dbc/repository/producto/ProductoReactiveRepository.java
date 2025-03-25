package co.com.asierra.r2dbc.repository.producto;

import co.com.asierra.r2dbc.data.ProductoData;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoReactiveRepository extends ReactiveCrudRepository<ProductoData, Integer>, ReactiveQueryByExampleExecutor<ProductoData> {
}
