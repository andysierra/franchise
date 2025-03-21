package co.com.asierra.api.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
public class ServerResponses {

    public static Mono<ServerResponse> onError(Throwable throwable) {
        log.error("Error al crear franquicia", throwable);
        return ServerResponse.badRequest().bodyValue("Error al crear franquicia");
    }
}
