package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T341 {

}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> list;
    List<Integer> newList;
    Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
        this.newList = new ArrayList<>();
        add(nestedList);
        iterator = newList.iterator();
    }

    private void add(List<NestedInteger> list) {
        for(NestedInteger ele : list) {
            if(ele.isInteger()) {
                newList.add(ele.getInteger());
            } else {
                add(ele.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */