package dk.vivek.pipesfiltersdemo.api;

import dk.vivek.pipesfiltersdemo.model.OrderRequest;
import dk.vivek.pipesfiltersdemo.model.OrderResult;
import dk.vivek.pipesfiltersdemo.pipeline.OrderPipeline;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderPipeline pipeline;

    public OrderController(OrderPipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/process")
    public ResponseEntity<OrderResult> process(@Valid @RequestBody OrderRequest request) {
        return ResponseEntity.ok(pipeline.process(request));
    }
}
