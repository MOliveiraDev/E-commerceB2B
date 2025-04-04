package com.springboot.E_commerceB2B.Config;

import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import com.nimbusds.openid.connect.sdk.Nonce;
import com.nimbusds.openid.connect.sdk.OIDCResponseTypeValue;
import com.nimbusds.oauth2.sdk.ResponseType;
import com.nimbusds.oauth2.sdk.Scope;
import com.nimbusds.openid.connect.sdk.OIDCScopeValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class AppConfig {

    @Bean
    public AuthenticationRequest authenticationRequest() throws URISyntaxException {
        URI authEndpoint = new URI("https://example.com/auth");
        ClientID clientID = new ClientID("your-client-id");
        ResponseType responseType = new ResponseType(OIDCResponseTypeValue.ID_TOKEN);
        Scope scope = new Scope(OIDCScopeValue.OPENID);
        Nonce nonce = new Nonce();

        return new AuthenticationRequest.Builder(responseType, scope, clientID, authEndpoint)
                .nonce(nonce)
                .build();
    }


}