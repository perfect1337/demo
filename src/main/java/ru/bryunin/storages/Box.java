package ru.bryunin.storages;

public class Box<T> {
    private T item=null;

    public T getItem() {
        T tmp  = item;
        item = null;
        return tmp;

    }

    public void setItem(T item) {
        if(this.item==null){
            this.item = item;
        }
        else{
            throw new IllegalArgumentException("You cannot have more than one item");
        }
    }

    public String toString() {
        return "Box [item=" + item + "]";
    }
}
