package io.quarkus.ts.openshift.messaging.amqp;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import io.reactivex.Flowable;

@ApplicationScoped
public class PriceProducer {

    private static final Logger LOG = Logger.getLogger(PriceProducer.class.getName());

    @Outgoing("generated-price")
    public Flowable<Integer> generate() {
        LOG.info("generate fired...");
        return Flowable.interval(1, TimeUnit.SECONDS)
                .onBackpressureDrop()
                .map(tick -> ((tick.intValue() * 10) % 100) + 10);
    }
}
