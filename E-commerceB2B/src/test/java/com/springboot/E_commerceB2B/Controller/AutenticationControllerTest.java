package com.springboot.E_commerceB2B.Controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.springboot.E_commerceB2B.Controller.AutenticationController;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AutenticationControllerTest {

    @Mock
    private AuthenticationRequest authenticationRequest;

    @InjectMocks
    private AutenticationController autenticationController;

    public AutenticationControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticationRequest() {

        assertNotNull(autenticationController);
    }
}