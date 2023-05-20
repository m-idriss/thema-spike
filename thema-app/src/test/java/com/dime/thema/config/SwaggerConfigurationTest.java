package com.dime.thema.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwaggerConfigurationTest {

    private SwaggerConfiguration swaggerConfigurationUnderTest;

    @BeforeEach
    void setUp() {
        swaggerConfigurationUnderTest = new SwaggerConfiguration();
    }

    @Test
    @DisplayName("test Users Microservice OpenAPI Bean")
    void testUsersMicroserviceOpenAPI() {

        // Call the usersMicroserviceOpenAPI() method to get the OpenAPI object
        OpenAPI result = swaggerConfigurationUnderTest.usersMicroserviceOpenAPI();

        // Verify the OpenAPI properties
        Info info = result.getInfo();
        assertThat(info.getTitle()).isEqualTo("Thema App");
        assertThat(info.getDescription()).isEqualTo("API to play game with word");
        assertThat(info.getSummary()).isEqualTo("A word game.");
        assertThat(info.getTermsOfService()).isEqualTo("https://www.termsofservicegenerator.net/");

        Contact contact = info.getContact();
        assertThat(contact.getEmail()).isEqualTo("contact@3dime.com");
        assertThat(contact.getName()).isEqualTo("contact");
        assertThat(contact.getUrl()).isEqualTo("https://www.3dime.com/support");

        License license = info.getLicense();
        assertThat(license.getName()).isEqualTo("Apache 2.0");
        assertThat(license.getUrl()).isEqualTo("https://www.apache.org/licenses/LICENSE-2.0.html");

        assertThat(info.getVersion()).isEqualTo("1.0");

        final OpenAPI expectedResult = new OpenAPI(SpecVersion.V30);
        // Verify the results
        assertThat(result.getInfo().getContact()).isNotNull();
        expectedResult.info(result.getInfo());
        assertThat(result).isEqualTo(expectedResult);
    }
}
