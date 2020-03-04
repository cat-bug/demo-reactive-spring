package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
@SpringBootTest
class RouterFunctionConfigTest {

    @Autowired
    RouterFunction routerFunction;

    @Test
    public void shouldReturnNames() {
        WebTestClient testClient = WebTestClient.bindToRouterFunction(routerFunction)
                .build();
        testClient.get().uri("/names/gum")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

}