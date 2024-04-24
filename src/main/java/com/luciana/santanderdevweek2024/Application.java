package com.luciana.santanderdevweek2024;

import com.luciana.santanderdevweek2024.application.AskChampionUseCase;
import com.luciana.santanderdevweek2024.application.ListChampionsUseCase;
import com.luciana.santanderdevweek2024.domain.ports.ChampionsRepository;
//import com.luciana.santanderdevweek2024.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository) {
        return new ListChampionsUseCase(repository);
    }

    @Bean
    public AskChampionUseCase provideAskChampionUseCase(ChampionsRepository repository){
        return new AskChampionUseCase(repository);
    }

    //Para usar API externa que precisa de uma chave(autorização)
    /*@Bean
	public AskChampionUseCase provideAskChampionUseCase(ChampionsRepository repository,
														GenerativeAiService genAiService) {
		return new AskChampionUseCase(repository, genAiService);
	}*/
}
