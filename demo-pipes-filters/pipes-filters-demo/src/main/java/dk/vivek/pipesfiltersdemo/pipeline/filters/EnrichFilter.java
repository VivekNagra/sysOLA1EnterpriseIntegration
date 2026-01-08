package dk.vivek.pipesfiltersdemo.pipeline.filters;

import dk.vivek.pipesfiltersdemo.model.OrderRequest;
import dk.vivek.pipesfiltersdemo.model.OrderResult;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class EnrichFilter implements Filter<OrderRequest, OrderResult> {

    @Override
    public OrderResult apply(OrderRequest input) {
        String risk = input.getQuantity() >= 100 ? "HIGH" : "LOW";
        return new OrderResult(
                input.getOrderId(),
                input.getItem(),
                risk,
                Instant.now()
        );
    }

    @Override
    public String name() {
        return "EnrichFilter";
    }
}
