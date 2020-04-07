package io.quarkus.ts.openshift.security.basic;

import javax.annotation.security.PermitAll;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/permit-all")
@PermitAll
public class PermitAllResource {
    @GET
    public String get(@Context SecurityContext security) {
        return "Hello!";
    }
}
