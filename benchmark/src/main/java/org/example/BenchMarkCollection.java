package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

//среднее время
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
//val -сколько раз будет выполняться тест реально, и результаты попадут в отчёты
@Fork(value = 5, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 10)
//warmup - прогревочное измерение, рез-ты не попадут в отчёты
//@Warmup(iterations = 5)
public class BenchMarkCollection {

    private static int N = 1_000_000;
    private static final String STRING_TO_FIND = String.valueOf(N - N / 4);

    private List<String> linkedList;
    private List<String> arrayList;
    private Set<String> hashSet;
    private Set<String> linkedHashSet;
    private Set<String> treeSet;

    @Setup
    public void setUp(){
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            final String value = String.valueOf(i);
            linkedList.add(value);
            arrayList.add(value);
            hashSet.add(value);
            linkedHashSet.add(value);
            treeSet.add(value);
        }
    }

    @Benchmark
    public void List_LinkedList(Blackhole blackhole) {
        blackhole.consume(linkedList.contains(STRING_TO_FIND));
    }

    @Benchmark
    public void List_ArrayList(Blackhole blackhole) {
        blackhole.consume(arrayList.contains(STRING_TO_FIND));
    }

    @Benchmark
    public void Set_HashSet(Blackhole blackhole) {
        blackhole.consume(hashSet.contains(STRING_TO_FIND));
    }

    @Benchmark
    public void Set_LinkedHashSet(Blackhole blackhole) {
        blackhole.consume(linkedHashSet.contains(STRING_TO_FIND));
    }

    @Benchmark
    public void Set_TreeSet(Blackhole blackhole) {
        blackhole.consume(treeSet.contains(STRING_TO_FIND));
    }

}
