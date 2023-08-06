package utils.simulation.generator;

import utils.Utils;

public class LongRandomGenerator extends Generator<Long> {
    @Override
    public Long generate() {
        return Utils.randomLong(0L, 1_000_000_000_000L);
    }
}
