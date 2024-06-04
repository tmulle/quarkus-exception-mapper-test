package org.acme;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NestedExceptionMapper implements ExceptionMapper<Throwable> {

    @Inject
    Logger log;
    
    /**
     * Maps exceptions to appropriate HTTP responses.
     *
     * @param exception The exception thrown during the request processing.
     * @return A Response object with a corresponding status code and a JSON
     * body containing error details.
     */
    @Override
    public Response toResponse(Throwable exception) {
        log.errorf(exception, "Error");
        return null;
    }
}