package utils.simulation.generator;

import utils.Utils;

public class IntIncrementGenerator extends Generator<Integer> {
    private int start = 0;

    @Override
    public Integer generate() {
        start += Utils.randomInt(1, 300);
        return start;
    }
}
