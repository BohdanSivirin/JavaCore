package oop.lambdaExpression;

@FunctionalInterface
public interface ActionTwo {
    int POSITION = 1;
    String TITLE = "Interface_ActionTwo";
//    void create();

    int getPosition(String t);

    default void createObj() {
        System.out.println(" create some object ");
    }

    static void print(String t) {
        System.out.println(t);
    }
}
