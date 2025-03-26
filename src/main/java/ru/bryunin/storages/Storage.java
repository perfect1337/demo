package ru.bryunin.storages;

public class Storage<T> {
   private T item;
   private static final Storage emptyStorage = new Storage(null);
   private Storage(T item){
       this.item = item;
   }
   public static <V> Storage<V> empty(){
       return emptyStorage;
   }
   public static <V> Storage<V> of(V item){
       if(item == null) return emptyStorage;
       return new Storage<V>(item);
   }
   public T getItem() {
       return item;
   }
}
