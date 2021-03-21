package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private int divider;
    DivisibleByFilter(Integer divider){
        this.divider = divider;
    }
    @Override
    public boolean accept(Integer number) {
        return number % divider == 0;
    }
}
