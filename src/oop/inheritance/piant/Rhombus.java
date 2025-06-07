package oop.inheritance.piant;

public class Rhombus extends Figure {
    private Point top;
    private Point down;
    private Point left;
    private Point right;

    public Rhombus(ColourType colourType, LineType lineType, Point leftPoint, Point rightPoint) {
        super(colourType, lineType, leftPoint, rightPoint);
    }

    @Override
    public void draw() {
        top = new Point((rightPoint.getX() - leftPoint.getX()) / 2, getLeftPoint().getY());
        down = new Point((getRightPoint().getX() - getLeftPoint().getY()) / 2, getRightPoint().getY());
        left = new Point((getRightPoint().getY() - getLeftPoint().getY()) / 2, getLeftPoint().getX());
        right = new Point((getRightPoint().getY() - getLeftPoint().getY()) / 2, getRightPoint().getX());
        System.out.println(super.toString() + "\n_________\nPoints :\ntop = " + top + "\ndown = " + down + "\nleft = " + left + "\nright = " + right);
    }
    @Override
    public Rhombus clone() {
        return new Rhombus(
                this.colourType,
                this.lineType,
                this.leftPoint.clone().fewSteps(),
                this.rightPoint.clone().fewSteps());
    }
}
