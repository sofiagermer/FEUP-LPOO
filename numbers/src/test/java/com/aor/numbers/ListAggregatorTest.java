package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private  List<Integer> list;

    @BeforeEach
    public void init(){
        list = new ArrayList<>();
       list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }


    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void bug_report_7263(){
        list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        Assertions.assertEquals(-1, max);
    }

    @Test
    public void bug_report_8726(){
        class ListDeduplicatorStub implements GenericListDeduplicator{
            @Override
            public List<Integer> deduplicate(List<Integer> list){
                List <Integer> temp;
                temp.add(1);
                temp.add(2);
                temp.add(4);
                return Array.asList(1,2,4);
            }
        }
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        ListAggregator aggregator = new ListAggregator();

        GenericListDeduplicator deduplicator = new ListDeduplicatorStub();
        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(3, distinct);
    }
}
