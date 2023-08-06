package utils.simulation.generator;

import utils.Utils;

public class CharGenerator extends Generator<Character> {
    @Override
    public Character generate() {
        return (char) ('a' + Utils.randomInt(0, 25));
    }
}
