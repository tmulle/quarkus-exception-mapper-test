package org.acme;

import jakarta.validation.constraints.NotBlank;

public class IncomingRequest {
    
    @NotBlank
    private String someItem;

}
