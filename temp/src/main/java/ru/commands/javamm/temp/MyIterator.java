package ru.commands.javamm.temp;

import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator<Integer> {
    final List<Integer> innerList;
    int index = 0;

    private int size() {
        return innerList.size();
    }

    public MyIterator(List<Integer> list) {
        this.innerList = list;
    }

    @Override
    public boolean hasNext() {
        if (index > size() - 1) {
            return false;
        } else {
            if (innerList.get(index) % 2 != 0) {
                for (int i = index; index < size() - 1; i++) {
                    if (innerList.get(++index) % 2 == 0) {
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return innerList.get(index++);
        } else {
            throw new RuntimeException("There is no more element in collection");
        }
    }
}
