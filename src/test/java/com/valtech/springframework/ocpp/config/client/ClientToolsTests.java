package com.valtech.springframework.ocpp.config.client;

import com.valtech.springframework.ocpp.ConnectionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.InvalidPropertyException;

import static org.junit.jupiter.api.Assertions.*;

public class ClientToolsTests {

    private void assertInvalidPropertyException(String message, ClientProperties properties) {
        InvalidPropertyException e = assertThrows(InvalidPropertyException.class, () -> ClientTools.validateClientProperties(properties));

        assertTrue(e.getMessage().contains(message));
    }

    @Test
    @DisplayName("Assert that exception is thrown when connectionUrl is null")
    void assertThatExceptionIsThrown_whenConnectionUrlIsNull() {
        ClientProperties properties = new ClientProperties();

        assertInvalidPropertyException("If client is enabled, connectionUrl must not be null or empty", properties);
    }

    @Test
    @DisplayName("Assert that exception is thrown when connectionUrl is empty")
    void assertThatExceptionIsThrown_whenConnectionUrlIsEmpty() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("");
        properties.setType(ConnectionType.JSON);

        assertInvalidPropertyException("If client is enabled, connectionUrl must not be null or empty", properties);
    }

    @Test
    @DisplayName("Assert that exception is thrown when identifier is null")
    void assertThatExceptionIsThrown_whenIdentifierIsNull() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("ws://localhost:8887");
        properties.setType(ConnectionType.JSON);

        assertInvalidPropertyException("If client is enabled, identifier must not be null or empty", properties);
    }

    @Test
    @DisplayName("Assert that exception is thrown when identifier is empty")
    void assertThatExceptionIsThrown_whenIdentifierIsEmpty() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("ws://localhost:8887");
        properties.setIdentifier("");
        properties.setType(ConnectionType.JSON);

        assertInvalidPropertyException("If client is enabled, identifier must not be null or empty", properties);
    }

    @Test
    @DisplayName("Assert that exception is thrown when SOAP connection and callback is null")
    void assertThatExceptionIsThrown_whenSOAPConnectionAndCallbackIsNull() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("ws://localhost:8887");
        properties.setIdentifier("identifier");
        properties.setType(ConnectionType.SOAP);

        assertInvalidPropertyException("If connection is SOAP, soapCallback must not be null or empty", properties);
    }

    @Test
    @DisplayName("Assert that exception is thrown when SOAP connection and callback is empty")
    void assertThatExceptionIsThrown_whenSOAPConnectionAndCallbackIsEmpty() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("ws://localhost:8887");
        properties.setIdentifier("identifier");
        properties.setType(ConnectionType.SOAP);
        properties.setSoapCallback("");

        assertInvalidPropertyException("If connection is SOAP, soapCallback must not be null or empty", properties);
    }

    @Test
    @DisplayName("Do nothing when soap configuration is valid")
    void doNothing_whenSOAPConfigurationIsValid() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("ws://localhost:8887");
        properties.setIdentifier("identifier");
        properties.setType(ConnectionType.SOAP);
        properties.setSoapCallback("http://localhost:8890");

        assertDoesNotThrow(() -> ClientTools.validateClientProperties(properties));
    }

    @Test
    @DisplayName("Do nothing when json configuration is valid")
    void doNothing_whenJSONConfigurationIsValid() {
        ClientProperties properties = new ClientProperties();
        properties.setConnectionUrl("ws://localhost:8887");
        properties.setIdentifier("identifier");
        properties.setType(ConnectionType.JSON);

        assertDoesNotThrow(() -> ClientTools.validateClientProperties(properties));
    }
}
