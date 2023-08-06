package utils.simulation.generator;

public abstract class Generator<T> {
    protected Object[] args;

    public Generator(Object... args) {
        this.args = args;
    }

    public abstract T generate();
}
