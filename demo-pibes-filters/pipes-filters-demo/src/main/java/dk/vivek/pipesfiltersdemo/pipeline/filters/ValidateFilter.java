package dk.vivek.pipesfiltersdemo.pipeline.filters;

import dk.vivek.pipesfiltersdemo.model.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class ValidateFilter implements Filter<OrderRequest, OrderRequest> {

    @Override
    public OrderRequest apply(OrderRequest input) {
        // Bean Validation handles basic checks; domain rule example:
        if (input.getQuantity() > 1000) {
            throw new IllegalArgumentException("quantity too large for a single order");
        }
        return input;
    }

    @Override
    public String name() {
        return "ValidateFilter";
    }
}
