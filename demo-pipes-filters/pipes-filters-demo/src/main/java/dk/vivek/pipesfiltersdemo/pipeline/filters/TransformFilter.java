package dk.vivek.pipesfiltersdemo.pipeline.filters;

import dk.vivek.pipesfiltersdemo.model.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class TransformFilter implements Filter<OrderRequest, OrderRequest> {

    @Override
    public OrderRequest apply(OrderRequest input) {
        input.setItem(input.getItem().trim().toUpperCase());
        return input;
    }

    @Override
    public String name() {
        return "TransformFilter";
    }
}
