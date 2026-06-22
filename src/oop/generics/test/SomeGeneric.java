package oop.generics.test;

public interface SomeGeneric <T>{
   <R> R getValue(T value);
}
