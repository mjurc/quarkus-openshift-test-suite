package io.quarkus.ts.openshift.configmap.api.server;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Hello {
    private final String content;

    public Hello(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
