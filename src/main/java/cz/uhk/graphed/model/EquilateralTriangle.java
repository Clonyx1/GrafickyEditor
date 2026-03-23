package cz.uhk.graphed.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EquilateralTriangle extends AbstractGraphicObject{
    private int edgeLenght;
    private boolean isUpwards;
    private Point[] vertices = new Point[3];

    public EquilateralTriangle(Point pos, int edgeLenght, Color color, boolean isUpwards) {
        super(pos, color);
        this.edgeLenght = edgeLenght;
        this.isUpwards = isUpwards;
    }

    //Get set
    public Point getStartingPoint() {return position;}
    public void setStartingPoint(Point pos) {this.position= pos;}
    public int getEdgeLenght() {return edgeLenght;}
    public void setEdgeLenght(int edgeLenght) {this.edgeLenght = edgeLenght;}

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //A
        vertices[0] = new Point(position.x, position.y);
        //B
        vertices[1] = new Point(position.x + edgeLenght, position.y);
        //C
        int triangleHeight = (int)((Math.sqrt(3)/2) * edgeLenght);
        if(isUpwards){
            vertices[2] = new Point(edgeLenght / 2 + position.x, position.y - triangleHeight);
        }
        else{
            vertices[2] = new Point(edgeLenght / 2 + position.x, position.y + triangleHeight);
        }

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        for(int i = 0; i < 3; i++){
            xPoints[i] = vertices[i].x;
            yPoints[i] = vertices[i].y;
        }
        g2.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point p) {
        double S = area(vertices[0], vertices[1], vertices[2]);

        double s1 = area(p, vertices[1], vertices[2]);
        double s2 = area(vertices[0], p, vertices[2]);
        double s3 = area(vertices[0], vertices[1], p);

        double dif = Math.abs(S - s1 - s2 - s3);
        if(dif < 0.01) return true;

        return false;
    }

    public double area(Point A, Point B, Point C) {
        //S = 1/2|x1(y2-y3) + x2(y1-y3) + x3(y1 - y2)|
        return 0.5 * Math.abs(A.x * (B.y - C.y) + B.x * (C.y - A.y) +  C.x * (A.y - B.y));
    }
}
