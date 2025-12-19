package oop.lambdaExpression;

public abstract class AbstractAction implements Action {
    @Override
    public int getValue(double v){
      return Double.toString(v).split("\\.")[1].length();
    }
}
