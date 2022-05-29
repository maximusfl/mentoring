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
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 2)
//warmup - прогревочное измерение, рез-ты не попадут в отчёты
@Warmup(iterations = 1)
public class CollectionsInsert {


    private static int N = new Context().getN();
    private List<String> linkedList;
    private List<String> arrayList;
    private Set<String> hashSet;
    private Set<String> linkedHashSet;
    private Set<String> treeSet;


    @Setup
    public void setUp() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();

    }

    public Object defaultAddToEnd(int n, Collection collection) {
        for(int i = 0; i < n; i++) {
            collection.add(String.valueOf(i));
        }
        return null;
    }


    @Benchmark
    public void List_LinkedList(Blackhole blackhole) {
        blackhole.consume(defaultAddToEnd(N,linkedList));
    }

    @Benchmark
    public void List_ArrayList(Blackhole blackhole) {
        blackhole.consume(defaultAddToEnd(N,arrayList));
    }

    @Benchmark
    public void Set_HashSet(Blackhole blackhole) {
        blackhole.consume(defaultAddToEnd(N, hashSet));
    }

    @Benchmark
    public void Set_LinkedHashSet(Blackhole blackhole) {
        blackhole.consume(defaultAddToEnd(N, linkedHashSet));
    }

    @Benchmark
    public void Set_TreeSet(Blackhole blackhole) {
        blackhole.consume(defaultAddToEnd(N, treeSet));
    }

}

