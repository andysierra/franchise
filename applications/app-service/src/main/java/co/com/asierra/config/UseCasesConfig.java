package co.com.asierra.config;

import co.com.asierra.model.franquicia.gateways.FranquiciaRepository;
import co.com.asierra.usecase.franchise.FranchiseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.asierra.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public FranchiseUseCase franchiseUseCase(FranquiciaRepository franquiciaRepository) {
                return new FranchiseUseCase(franquiciaRepository);
        }
}
