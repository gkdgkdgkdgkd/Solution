package utils.simulation.generator;

import utils.Utils;

public class StringRangeGenerator extends Generator<String> {
    public StringRangeGenerator(Object... args) {
        super(args);
    }

    @Override
    public String generate() {
        return "\"" + Utils.randomLowercaseStr((int) args[0]) + "\"";
    }
}
