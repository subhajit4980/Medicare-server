package com.subhajit.Medicare.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Configuration class for OpenAPI documentation.
 */
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Subhajit Patra", // Name of the contact person
                        email = "subhajitpatra498@gmail.com", // Email of the contact person
                        url = "https://subhajit4980.github.io/Subhajit/" // URL of the contact person's website
                ),
                description = "OpenAPI documentation for Spring Security", // Description of the API
                title = "OpenAPI specification - Subhajit", // Title of the API
                version = "1.0", // Version of the API
                license = @License(
                        name = "Licence name", // Name of the license
                        url = "https://some-url.com" // URL of the license
                ),
                termsOfService = "Terms of service" // Terms of service for the API
        ),
        servers = {
                @Server(
                        description = "Local ENV", // Description of the server
                        url = "http://localhost:8080/" // Base URL of the server
                ),
                @Server(
                        description = "Remote ENV", // Description of the server
                        url = "https://medicare.up.railway.app"
                )

        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth" // Security requirement for bearer authentication
                )
        }
)
@SecurityScheme(
        name = "bearerAuth", // Name of the security scheme
        description = "JWT auth description", // Description of the security scheme
        scheme = "bearer", // Authentication scheme
        type = SecuritySchemeType.HTTP, // Type of the security scheme
        bearerFormat = "JWT", // Format of the bearer token
        in = SecuritySchemeIn.HEADER // Location of the bearer token in the request
)
public class OpenApiConfig {}
