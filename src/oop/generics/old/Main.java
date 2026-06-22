package oop.generics.old;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Collections.addAll(list, 34, 45.78, "text", 34567890, 'f');
        list.add("super");
        OldGeneric oldGeneric = new OldGeneric("t");
        oldGeneric.setField1(34);
        System.out.println(oldGeneric);
        OldGeneric oldGeneric1 = new OldGeneric(34.77);
        oldGeneric1.setField1('g');
        System.out.println(oldGeneric1);

        oldGeneric=oldGeneric1;

    }
}
