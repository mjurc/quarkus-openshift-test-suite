package io.quarkus.ts.openshift.todo.demo.app;

import static io.restassured.RestAssured.when;

import java.net.URL;

import org.junit.jupiter.api.Test;

import io.quarkus.ts.openshift.common.AdditionalResources;
import io.quarkus.ts.openshift.common.CustomAppMetadata;
import io.quarkus.ts.openshift.common.OpenShiftTest;
import io.quarkus.ts.openshift.common.deploy.ManualDeploymentStrategy;
import io.quarkus.ts.openshift.common.injection.TestResource;

@OpenShiftTest(strategy = ManualDeploymentStrategy.class)
@CustomAppMetadata(appName = "todo-demo-app", httpRoot = "/", knownEndpoint = "/")
@AdditionalResources("classpath:openjdk-11.yaml")
@AdditionalResources("classpath:deployments/maven/s2i-maven-settings.yaml")
@AdditionalResources("classpath:todo-demo-app.yaml")
public class TodoDemoAppOpenShiftIT {
    @TestResource
    private URL url;

    @Test
    public void verify() {
        when()
                .get(url)
                .then()
                .statusCode(200);
    }
}
