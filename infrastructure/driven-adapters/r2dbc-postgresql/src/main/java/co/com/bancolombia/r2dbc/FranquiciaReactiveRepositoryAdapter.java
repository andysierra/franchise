package co.com.bancolombia.r2dbc;

import co.com.bancolombia.model.franquicia.Franquicia;
import co.com.bancolombia.model.franquicia.gateways.FranquiciaRepository;
import co.com.bancolombia.r2dbc.data.FranquiciaData;
import co.com.bancolombia.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FranquiciaReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Franquicia/* change for domain model */,
        FranquiciaData/* change for adapter model */,
        Integer,
        FranquiciaReactiveRepository> implements FranquiciaRepository
{
    public FranquiciaReactiveRepositoryAdapter(FranquiciaReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Franquicia.class/* change for domain model */));
    }

}
