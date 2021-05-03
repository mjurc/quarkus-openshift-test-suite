package io.quarkus.ts.openshift.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

/**
 * The {@code @DisabledOnQuarkus} annotation can be used to selectively enable or disable certain tests
 * based on version of Quarkus used in the test suite.
 *
 * @see #version()
 * @see #reason()
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DisabledOnQuarkusCondition.class)
public @interface DisabledOnQuarkus {
    /**
     * Regular expression that is matched against the version of Quarkus used in the test suite.
     * If the version matches, the test is disabled.
     * Note that the entire Quarkus version string must match, substring match isn't enough.
     */
    String version();

    /**
     * Why is the annotated test class or test method disabled.
     */
    String reason();
}
