package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
//val -сколько раз будет выполняться тест реально, и результаты попадут в отчёты
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 2)
//warmup - прогревочное измерение, рез-ты не попадут в отчёты
@Warmup(iterations = 1)
public class CollectionInsertToMiddle {


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

    public Object addToMiddleLinkedList() {
        for(int i = 0; i < N; i++) {
            linkedList.add(i/2, String.valueOf(i));
        }
        return null;
    }
    public Object addToMiddleArrayList() {
        for(int i = 0; i < N; i++) {
            arrayList.add(i/2, String.valueOf(i));
        }
        return null;
    }


    @Benchmark
    public void List_LinkedList(Blackhole blackhole) {
        blackhole.consume(addToMiddleLinkedList());
    }

    @Benchmark
    public void List_ArrayList(Blackhole blackhole) {
        blackhole.consume(addToMiddleArrayList());
    }

}
