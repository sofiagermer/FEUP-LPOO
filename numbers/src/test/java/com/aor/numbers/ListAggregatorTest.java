package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.Mockito;

public class ListAggregatorTest {
    private List<Integer> list;

    @BeforeEach
    public void init() {
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

        max = aggregator.max(Arrays.asList(1,2,3,4,5,6,7,8,8));
        Assertions.assertEquals(8,max);

        max = aggregator.max(Arrays.asList(1,2,2));
        Assertions.assertEquals(2, max);
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
        ListDeduplicator deduplicator = new ListDeduplicator(new ListSorter());
        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void bug_report_7263() {
        list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        Assertions.assertEquals(-1, max);
    }
    @Test
    public void distinct_bug_8726() {
        ListAggregator aggregator = new ListAggregator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator);

        Assertions.assertEquals(3, distinct);
    }
}


