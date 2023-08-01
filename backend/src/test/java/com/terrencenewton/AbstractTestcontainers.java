package com.terrencenewton;

import com.github.javafaker.Faker;
import com.terrencenewton.hotelreservationmanagement.external.storage.roomtype.RoomTypeEntityMapperImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest(
        classes = {RoomTypeEntityMapperImpl.class}
)
@ActiveProfiles("test")
public abstract class AbstractTestcontainers {

    @Container
    protected static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("terrencenewton-dao-unit-test")
                    .withUsername("unittest")
                    .withPassword("password");

    @DynamicPropertySource
    private static void registerDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password",postgreSQLContainer::getPassword);
    }

    protected static final Faker FAKER = new Faker();
}
