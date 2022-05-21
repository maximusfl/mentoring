package org.example;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Test {
    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(BenchMarkCollection.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();

    }
}
