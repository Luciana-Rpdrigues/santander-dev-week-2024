package com.luciana.santanderdevweek2024.adapters.in;

import com.luciana.santanderdevweek2024.application.AskChampionUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do LOL.")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {
    @CrossOrigin // para consumir a api para configurar o front end, este não é recomendado em questão de segurança.
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {
        String answer = useCase.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question) { }
    public record AskChampionResponse(String answer) { }
}
