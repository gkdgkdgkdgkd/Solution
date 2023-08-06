package utils.simulation;

import utils.Utils;
import utils.simulation.generator.*;

import java.lang.reflect.*;
import java.util.*;

public class SimulationUtils {
    private final Class<?> cls;
    private final MethodWithGenerator constructor;
    private final Map<String, MethodWithGenerator> methodMap = new HashMap<>();
    private final int total;
    private final StringBuilder operationBuilder = new StringBuilder();
    private final StringBuilder parameterBuilder = new StringBuilder();
    private final int methodTotal;
    private final List<String> methodNames = new ArrayList<>();

    public SimulationUtils(Class<?> cls, int total) {
        this.cls = cls;
        this.total = total;
        constructor = new MethodWithGenerator(cls.getConstructors()[0]);
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            methodMap.put(name, new MethodWithGenerator(method));
            methodNames.add(name);
        }
        methodTotal = methods.length;
    }

    public void setGenerator(String methodName, int parameterIndex, Generator<?> generator) {
        methodMap.get(methodName).setGenerator(parameterIndex, generator);
    }


    public void setConstructorFixedValue(int parameterIndex, Object value) {
        constructor.setFixedValue(parameterIndex, value);
    }

    public void generate() {
        operationBuilder.append("[\"").append(cls.getName());
        parameterBuilder.append("[[");
        for (int i = 0; i < constructor.getParameterCount(); i++) {
            parameterBuilder.append(constructor.generate()).append(",");
        }
        parameterBuilder.deleteCharAt(parameterBuilder.length() - 1);
        operationBuilder.append("\"");
        parameterBuilder.append("]");
        for (int i = 0; i < total; i++) {
            int methodIndex = Utils.randomInt(0, methodTotal - 1);
            MethodWithGenerator generator = methodMap.get(methodNames.get(methodIndex));
            operationBuilder.append(",\"").append(generator.getMethodName()).append("\"");
            parameterBuilder.append(",[");
            for (int j = 0; j < generator.getParameterCount(); j++) {
                parameterBuilder.append(generator.generate()).append(",");
            }
            parameterBuilder.deleteCharAt(parameterBuilder.length() - 1);
            parameterBuilder.append("]");
        }
        operationBuilder.append("]");
        parameterBuilder.append("]");
    }

    public void print() {
        System.out.println(operationBuilder);
        System.out.println(parameterBuilder);
    }

    private static class MethodWithGenerator {
        private int generateIndex = 0;
        private final int parameterCount;
        private final String methodName;
        private final List<Generator<?>> generatorList = new ArrayList<>();
        private final Map<Integer, Object> fixedValueMap = new HashMap<>();

        public MethodWithGenerator(Executable method) {
            this.methodName = method.getName();
            this.parameterCount = method.getParameterCount();
            for (Parameter parameter : method.getParameters()) {
                Class<?> type = parameter.getType();
                if (int.class.equals(type) || Integer.class.equals(type)) {
                    generatorList.add(new IntRandomGenerator());
                } else if (String.class.equals(type)) {
                    generatorList.add(new StringRandomGenerator());
                } else if (long.class.equals(type) || Long.class.equals(type)) {
                    generatorList.add(new LongRandomGenerator());
                } else if(char.class.equals(type) || Character.class.equals(type)) {
                    generatorList.add(new CharGenerator());
                }else{
                    generatorList.add(new DefaultGenerator());
                }
            }
        }

        public void setFixedValue(int parameterIndex, Object value) {
            Class<?> valueClass = value.getClass();
            if (long[].class.equals(valueClass)) {
                fixedValueMap.put(parameterIndex, Arrays.toString((long[]) value));
            } else if (int[].class.equals(valueClass)) {
                fixedValueMap.put(parameterIndex, Arrays.toString((int[]) value));
            } else if (char[].class.equals(valueClass)) {
                fixedValueMap.put(parameterIndex, Arrays.toString((char[]) value));
            } else {
                fixedValueMap.put(parameterIndex, value);
            }
        }

        public void setGenerator(int parameterIndex, Generator<?> generator) {
            generatorList.set(parameterIndex, generator);
        }

        public Object generate() {
            Object res = fixedValueMap.get(generateIndex);
            if (res == null) {
                res = generatorList.get(generateIndex).generate();
            }
            generateIndex = (generateIndex + 1) % parameterCount;
            return res;
        }

        public int getParameterCount() {
            return parameterCount;
        }

        public String getMethodName() {
            return methodName;
        }
    }
}
