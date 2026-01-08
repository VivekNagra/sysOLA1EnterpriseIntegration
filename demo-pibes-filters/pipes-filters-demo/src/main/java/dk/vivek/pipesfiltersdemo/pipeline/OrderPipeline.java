package dk.vivek.pipesfiltersdemo.pipeline;

import dk.vivek.pipesfiltersdemo.model.OrderRequest;
import dk.vivek.pipesfiltersdemo.model.OrderResult;
import dk.vivek.pipesfiltersdemo.pipeline.filters.EnrichFilter;
import dk.vivek.pipesfiltersdemo.pipeline.filters.TransformFilter;
import dk.vivek.pipesfiltersdemo.pipeline.filters.ValidateFilter;
import org.springframework.stereotype.Service;

@Service
public class OrderPipeline {

    private final ValidateFilter validate;
    private final TransformFilter transform;
    private final EnrichFilter enrich;

    public OrderPipeline(ValidateFilter validate, TransformFilter transform, EnrichFilter enrich) {
        this.validate = validate;
        this.transform = transform;
        this.enrich = enrich;
    }

    public OrderResult process(OrderRequest request) {
        OrderRequest validated = validate.apply(request);
        OrderRequest transformed = transform.apply(validated);
        return enrich.apply(transformed);
    }
}
