package com.lefeng.generic;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildCardOfDrawingShape {

    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();
        Canvas canvas = new Canvas();
        canvas.drawAll(circles);

        //Note: for wildcard of '?', it could be Shape itself, or some subclass; it need not literally extend Shape.
        List<? extends Circle> list2 = circles;
        canvas.drawAll(list2);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());

        List<Circle> circles1 = new ArrayList<>();
//        circles1.add(new Shape());  //does not compile at all, as Shape is not necessarily a Circle, vice versa, Circle is a shape.
    }

    static class Shape {
        public void draw(Canvas c){
        }
    }

    static class Circle extends Shape {
        private int x, y, radius;
        public void draw(Canvas c) {
            System.out.println("drawing circle on canvas");
        }
    }
    static class Rectangle extends Shape {
        private int x, y, width, height;
        public void draw(Canvas c) {
            System.out.println("drawing Rectangle on canvas");
        }
    }

    static class Canvas {
        public void drawAll(List<? extends Shape> shapes){
            for (Shape shape : shapes) {
                shape.draw(this);
            }
        }

        public void draw(Shape s) {
            s.draw(this);
        }
    }
}


