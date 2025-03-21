package co.com.bancolombia.r2dbc;

import co.com.bancolombia.r2dbc.data.FranquiciaData;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface FranquiciaReactiveRepository extends ReactiveCrudRepository<FranquiciaData, Integer>, ReactiveQueryByExampleExecutor<FranquiciaData> {

}
