package io.quarkus.ts.openshift.http.clients;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;

@RegisterRestClient
public interface HttpVersionClientServiceAsync {

    @GET
    @Path("/httpVersion")
    Uni<Response> getClientHttpVersion();
}
