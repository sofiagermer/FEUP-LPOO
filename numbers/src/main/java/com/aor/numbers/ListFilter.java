package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    private final GenericListFilter filter;
    public ListFilter(GenericListFilter filter){
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list) {
        List <Integer> afterFilter = new ArrayList<>();
        for(int num : list){
            if(filter.accept(num)) afterFilter.add(num);
        }
        return afterFilter;
    }
}
