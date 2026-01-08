package dk.vivek.pipesfiltersdemo.pipeline.filters;

public interface Filter<I, O> {
    O apply(I input);
    String name();
}
