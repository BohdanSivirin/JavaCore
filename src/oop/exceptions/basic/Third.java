package oop.exceptions.basic;

import java.util.Random;

public class Third {
    public void thirdMethod() throws MyHandledException {
        Fourth fourth = new Fourth();
        fourth.fourth();
        int a = new Random().nextInt(100);
        if (a % 2 == 0) {
            System.out.println(" method third successfully work ");
        } else {
            throw new MyUnhandledException();
        }
    }
}
