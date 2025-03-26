package ru.bryunin.main;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DataStream<T> {
    List<T> collection;
    ArrayList<Object> actionList=new ArrayList<>();
    private DataStream(List<T> stream) {
        this.collection = List.copyOf(stream);
    }

    private DataStream(List<T> stream, ArrayList<Object> actionList) {
        this(stream);
        this.actionList = actionList;
    }

    public static <P> DataStream<P> of(List<P> collection){
        return new DataStream<>(collection);
    }

    public static <P> DataStream<P> of(List<P> collection, ArrayList<Object> actionList){
        return new DataStream<>(collection, actionList);
    }

    public <P> DataStream<P> map(Function<T, P> a) {
        actionList.add(a);
        return (DataStream<P>) DataStream.of(collection, actionList);
    }

    public DataStream<T> filter(Predicate<T> a) {
        actionList.add(a);
        return DataStream.of(collection, actionList);
    }

    public T reduce(Reductor<T> a, T def) {
        if (collection.isEmpty()) return def;
        T res = collection.get(0);
        for (int i = 1; i < collection.size(); i++) {
            res = a.reduct(res, collection.get(i));
        }
        return res;
    }

    public <P> P collect(Supplier<P> s, Accumulator<P, T> a) {
        P outCollection = s.get();
        if (collection.isEmpty()) return outCollection;
        main: for (T el : collection) {
            for(Object o : actionList){
                if(o instanceof Predicate on){
                    if(!on.test(el)){
                        continue main;
                    }
                }
                else if(o instanceof Function on){
                   el = (T) on.apply(el);
                }
            }
            a.accumulate(outCollection, el);
        }
        return outCollection;
    }
}



interface Reductor<T> {
    T reduct(T res, T el);
}

interface Accumulator<T, P> {
    void accumulate(T collection, P element);
}