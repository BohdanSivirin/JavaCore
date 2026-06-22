package oop.inheritance.piant;


import java.util.ArrayList;
import java.util.Scanner;

public class Paint {
    private final Scanner scanner = new Scanner(System.in);
    private ColourType currentColorType = ColourType.BLACK;
    private LineType currentLineType = LineType.THIN;
    private final ArrayList<Figure> figures = new ArrayList<>();
    private final ArrayList<Figure> highLightsFigures = new ArrayList<>();

    public Paint() {
        menu();
    }

    private void menu() {
        System.out.println("""

                Menu:
                1) - paint Figure
                2) - paint Change Colour
                3) - paint Change Depth
                4) - highlight Figure
                5) - move Figure
                6) - clone Figure
                7) - delete Figure
                8) - exit""");
        switch (scanner.nextInt()) {
            case 1 -> paintFigure();
            case 2 -> paintChangeColour();
            case 3 -> paintChangeDepth();
            case 4 -> highlightFigure();
            case 5 -> moveFigure();
            case 6 -> cloneFigure();
            case 7 -> deleteFigure();
            case 8 -> System.exit(0);
        }
        menu();
    }

    private void paintFigure() {
        System.out.println("""
                Choose figure:
                1 - triangle
                2 - rhombus
                3 - rectangle
                4 - circle""");
        int val = scanner.nextInt();
        System.out.println("\nInput first point:");
        Point firstPoint = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        System.out.println("\nInput second point:");
        Point secondPoint = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        switch (val) {
            case 1 -> figures.add(new Triangle(currentColorType, currentLineType, firstPoint, secondPoint));
            case 2 -> figures.add(new Rhombus(currentColorType, currentLineType, firstPoint, secondPoint));
            case 3 -> figures.add(new Rectangle(currentColorType, currentLineType, firstPoint, secondPoint));
            case 4 -> figures.add(new Circle(currentColorType, currentLineType, firstPoint, secondPoint));
        }
    }

    private void paintChangeColour() {
        System.out.println("\nInput numb of color:\n1 - white,\n2 - black,\n3 - red,\n4 - blue,\n5 - green");
        switch (scanner.nextInt()) {
            case 1 -> currentColorType = ColourType.WHITE;
            case 2 -> currentColorType = ColourType.BLACK;
            case 3 -> currentColorType = ColourType.RED;
            case 4 -> currentColorType = ColourType.BLUE;
            case 5 -> currentColorType = ColourType.GREEN;
        }
        for (Figure highLightsFigure : highLightsFigures) {
            highLightsFigure.changeColor(currentColorType);
        }
        System.out.println("Current color changed: " + currentColorType);
    }

    private void paintChangeDepth() {
        System.out.println("\nInput numb of depth:\n1 - thin,\n2 - fat,\n3 - very fat ");
        switch (scanner.nextInt()) {
            case 1 -> currentLineType = LineType.THIN;
            case 2 -> currentLineType = LineType.FAT;
            case 3 -> currentLineType = LineType.VERY_FAT;
        }
        currentLineType=LineType.valueOf("RED");
        for (Figure highLightsFigure : highLightsFigures) {
            highLightsFigure.changeDepth(currentLineType);
        }
        System.out.println("Current line type changed: " + currentLineType);
    }

    private void highlightFigure() {
        System.out.println("\nInput first point:");
        Point firstPoint = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        System.out.println("\nInput second point:");
        Point secondPoint = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        for (Figure figure : figures) {
            double currentFigureLeftX = figure.getLeftPoint().getX();
            double currentFigureLeftY = figure.getLeftPoint().getY();
            double currentFigureRightX = figure.getRightPoint().getX();
            double currentFigureRightY = figure.getRightPoint().getY();
            if (firstPoint.getX() <= currentFigureLeftX
                && firstPoint.getY() <= currentFigureLeftY
                && secondPoint.getX() >= currentFigureRightX
                && secondPoint.getY() >= currentFigureRightY) {
                highLightsFigures.add(figure);
                System.out.println("\n[ <-- Figure added to array --> ]\n" + figure);
            }
        }
    }

    private void moveFigure() {
        if (highLightsFigures.isEmpty()) {
            System.out.println("Empty highlights area ");
            return;
        }
        System.out.println("\nInput point where to move to:");
        Point firstPoint = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        for (Figure highLightsFigure : highLightsFigures) {
            highLightsFigure.move(firstPoint);
        }
        highLightsFigures.clear();
    }

    private void cloneFigure() {
        if (highLightsFigures.isEmpty()) {
            System.out.println("Empty highlights area ");
            return;
        }

        for (Figure highLightsFigure : highLightsFigures) {
            figures.add(highLightsFigure.clone());
        }
        highLightsFigures.clear();
    }

    private void deleteFigure() {
        figures.removeAll(highLightsFigures);
        highLightsFigures.clear();
    }
}
