package cz.uhk.graphed.model;

import java.awt.*;

public class EquilateralTriangle extends AbstractGraphicObject{
    private int edgeLenght;
    private boolean isUpwards;

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
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        //A
        xPoints[0] =  position.x;
        yPoints[0] =  position.y;
        //B
        xPoints[1] =  position.x + edgeLenght;
        yPoints[1] =  position.y;
        //C
        xPoints[2] = edgeLenght / 2 + position.x;
        double triangleHeight = (int)((Math.sqrt(3)/2) * edgeLenght);
        if(isUpwards){
            yPoints[2] = (int)(position.y - triangleHeight);
        }
        else{
            yPoints[2] = (int)(position.y + triangleHeight);
        }

        g2.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
