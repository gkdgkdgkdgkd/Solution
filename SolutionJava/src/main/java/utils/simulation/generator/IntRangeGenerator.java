package utils.simulation.generator;

import utils.Utils;

public class IntRangeGenerator extends Generator<Integer> {
    public IntRangeGenerator(Object... args) {
        super(args);
    }

    @Override
    public Integer generate() {
        if (args == null || args.length < 2) {
            return new IntRandomGenerator().generate();
        }
        return Utils.randomInt((int) args[0], (int) args[1]);
    }
}
