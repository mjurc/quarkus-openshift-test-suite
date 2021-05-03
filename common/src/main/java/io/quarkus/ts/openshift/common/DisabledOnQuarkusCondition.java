package io.quarkus.ts.openshift.common;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;
import java.util.regex.Pattern;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DisabledOnQuarkusCondition implements ExecutionCondition {
    private static final ConditionEvaluationResult ENABLED_BY_DEFAULT = ConditionEvaluationResult.enabled(
            "@DisabledOnQuarkus is not present");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<AnnotatedElement> element = context.getElement();
        Optional<DisabledOnQuarkus> disabledOnQuarkus = findAnnotation(element, DisabledOnQuarkus.class);
        if (disabledOnQuarkus.isPresent()) {
            Pattern pattern = Pattern.compile(disabledOnQuarkus.get().version());
            String quarkusVersion = io.quarkus.builder.Version.getVersion();

            return pattern.matcher(quarkusVersion).matches()
                    ? ConditionEvaluationResult.disabled("Disabled on Quarkus version " + quarkusVersion + " (reason: "
                            + disabledOnQuarkus.get().reason() + ")")
                    : ConditionEvaluationResult.enabled("Enabled on Quarkus version " + quarkusVersion);
        }
        return ENABLED_BY_DEFAULT;
    }
}
