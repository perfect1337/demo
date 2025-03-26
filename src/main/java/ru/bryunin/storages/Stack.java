package ru.bryunin.storages;


public class Stack<T> {
    private int stackSize=100;
    private T[] stack = (T[]) new Object[stackSize];
    private int top=0;
    public void push(T element) {
        if(top==stackSize) System.out.println("Stack is full");
        stack[top] = element;
        top++;
    }
    public T pop() {
        if(top==0)System.out.println("Stack is empty");
        T element = stack[top];
        stack[top]=null;
        top--;
        return element;
    }
    public T peek() {
        if(top==0) return null;
        return stack[top-1];
    }
}
