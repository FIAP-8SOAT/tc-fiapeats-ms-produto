package br.com.fiap.fiapeats.unitTests.bdd;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.fiap.fiapeats.unitTests.bdd")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Sql(scripts = {"/sqlTest.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class RunCucumberTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    void assertNotNull() {
        Assert.assertNotNull(RestAssured.port);
    }
}