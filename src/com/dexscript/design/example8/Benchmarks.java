package com.dexscript.design.example8;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class Benchmarks {
    Object result = 0;

    /*
    # Warmup Iteration   1: 56.692 ns/op
    # Warmup Iteration   2: 30.793 ns/op
    # Warmup Iteration   3: 29.922 ns/op
    Iteration   1: 30.201 ns/op
    Iteration   2: 29.929 ns/op
    Iteration   3: 30.364 ns/op
     */
    @Benchmark
    public void addBenchmark() {
        for (int i = 0; i < 10; i++) {
            result = add(result, i, Integer.class);
        }
    }

    /*
    # Warmup Iteration   1: 39.936 ns/op
    # Warmup Iteration   2: 29.731 ns/op
    # Warmup Iteration   3: 29.723 ns/op
    Iteration   1: 30.760 ns/op
    Iteration   2: 30.203 ns/op
    Iteration   3: 29.813 ns/op
     */
    @Benchmark
    public void addIntegerBenchmark() {
        for (int i = 0; i < 10; i++) {
            result = addInteger(result, i);
        }
    }

    private static Object add(Object leftOperand, Object rightOperand, Class T) {
        if (T == Integer.class) {
            return addInteger(leftOperand, rightOperand);
        } else if (T == Long.class) {
            return addLong(leftOperand, rightOperand);
        } else if (T == Double.class) {
            return addDouble(leftOperand, rightOperand);
        }
        throw new UnsupportedOperationException();
    }

    private static Object addInteger(Object leftOperand, Object rightOperand) {
        return (int)leftOperand + (int)rightOperand;
    }

    private static Object addLong(Object leftOperand, Object rightOperand) {
        return (long)leftOperand + (long)rightOperand;
    }

    private static Object addDouble(Object leftOperand, Object rightOperand) {
        return (double)leftOperand + (double)rightOperand;
    }
}