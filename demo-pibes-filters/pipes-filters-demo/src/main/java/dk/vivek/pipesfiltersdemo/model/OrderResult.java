package dk.vivek.pipesfiltersdemo.model;

import java.time.Instant;

public class OrderResult {
    private final String orderId;
    private final String normalizedItem;
    private final String riskLevel;
    private final Instant processedAt;

    public OrderResult(String orderId, String normalizedItem, String riskLevel, Instant processedAt) {
        this.orderId = orderId;
        this.normalizedItem = normalizedItem;
        this.riskLevel = riskLevel;
        this.processedAt = processedAt;
    }

    public String getOrderId() { return orderId; }
    public String getNormalizedItem() { return normalizedItem; }
    public String getRiskLevel() { return riskLevel; }
    public Instant getProcessedAt() { return processedAt; }
}
