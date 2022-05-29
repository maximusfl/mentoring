package org.example;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(CollectionsInsert.class.getSimpleName())
                .include(CollectionInsertInStart.class.getSimpleName())
                .include(CollectionInsertToMiddle.class.getSimpleName())
                .include(CollectionContains.class.getSimpleName())
                .include(CollectionAddToLast.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();

    }
}
