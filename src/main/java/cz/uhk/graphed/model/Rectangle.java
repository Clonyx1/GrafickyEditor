package cz.uhk.graphed.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rectangle extends AbstractGraphicObject {
    private int width;
    private int height;

    //Constructors
    public Rectangle() {
    }

    public Rectangle(Point pos, Color color, int width, int height) {
        super(pos, color);
        this.width = width;
        this.height = height;
    }

    //Get set
    public int getWidth(){
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    //Methods
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(color);
        g2.drawRect(position.x, position.y, width, height);
    }

    @Override
    public boolean contains(Point p)
    {
        List<Point> containedPoints = new ArrayList<>();

        for(int x = position.x; x < position.x + width; x++){
            for(int y = position.y; y < position.y + height; y++){
                containedPoints.add(new Point(x, y));
            }
        }

        if(containedPoints.contains(p)){
            return true;
        }

        return false;
    }
}
