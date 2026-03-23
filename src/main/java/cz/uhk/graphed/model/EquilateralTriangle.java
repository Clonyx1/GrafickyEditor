package cz.uhk.graphed.model;

import java.awt.*;

public class EquilateralTriangle extends AbstractGraphicObject{
    private Point startingPoint;
    private int edgeLenght;
    private boolean isUpwards;

    public EquilateralTriangle(Point startingPoint, int edgeLenght, Color color, boolean isUpwards) {
        this.startingPoint = startingPoint;
        this.edgeLenght = edgeLenght;
        this.color = color;
        this.isUpwards = isUpwards;
    }

    //Get set
    public Point getStartingPoint() {return startingPoint;}
    public void setStartingPoint(Point startingPoint) {this.startingPoint = startingPoint;}
    public int getEdgeLenght() {return edgeLenght;}
    public void setEdgeLenght(int edgeLenght) {this.edgeLenght = edgeLenght;}

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        //A
        xPoints[0] =  startingPoint.x;
        yPoints[0] =  startingPoint.y;
        //B
        xPoints[1] =  startingPoint.x + edgeLenght;
        yPoints[1] =  startingPoint.y;
        //C
        xPoints[2] = edgeLenght / 2 + startingPoint.x;
        double triangleHeight = (int)((Math.sqrt(3)/2) * edgeLenght);
        if(isUpwards){
            yPoints[2] = (int)(startingPoint.y - triangleHeight);
        }
        else{
            yPoints[2] = (int)(startingPoint.y + triangleHeight);
        }


        g2.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
