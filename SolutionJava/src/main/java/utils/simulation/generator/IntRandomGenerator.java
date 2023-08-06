package utils.simulation.generator;

import utils.Utils;

public class IntRandomGenerator extends Generator<Integer> {
    @Override
    public Integer generate(){
        return Utils.randomInt(0, 100_000);
    }
}
