package ru.bryunin.reflection;

import ru.bryunin.reflection.annotation.Cache;
import ru.bryunin.reflection.annotation.Mutator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class ProxyHandler implements InvocationHandler {
    Map<Key,Object> cache;

    private Object obj;

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method = obj.getClass().getMethod(method.getName(), method.getParameterTypes());
        Key key = new Key(method, args);
        if(method.isAnnotationPresent(Mutator.class)){
            cache.clear();
            return method.invoke(obj, args);
        }
        if(!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(obj, args);
        }
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        Object o = method.invoke(obj, args);
        cache.put(key, o);
        return o;
    }
}

record Key(Method n, Object[] args) {
}

