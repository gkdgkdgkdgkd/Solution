package utils.simulation.generator;

import utils.Utils;

public class StringRandomGenerator extends Generator<String> {
    @Override
    public String generate() {
        return "\"" + Utils.randomLowercaseStr(Utils.randomInt(1, 100)) + "\"";
    }
}
