/*package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    private List<Integer> list;


    @BeforeEach
    public void init(){
        list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
    }
    @Test
    public void sort() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);
        List<Integer> expected;
        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        Assertions.assertEquals(expected, sorted);

        sorted = sorter.sort(Arrays.asList(1,1,1,1,1,1,2,1));
        Assertions.assertEquals(Arrays.asList(1,1,1,1,1,1,1,2), sorted);
    }
    @Test
    public void sort_bug(){
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(Arrays.asList(1,2,4,2));
        List<Integer> expected = Arrays.asList(1,2,2,4);
        Assertions.assertEquals(expected, sorted);
    }
}*/
package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    private List<Integer> makeList(){
        List<Integer> list = Arrays.asList(1,2,4,2);
        return list;
    }
    @Test
    public void sort() {
        List<Integer> list = makeList();
        List<Integer> expected = Arrays.asList(1, 2, 2, 4);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
