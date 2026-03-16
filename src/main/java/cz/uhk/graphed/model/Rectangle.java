package cz.uhk.graphed.model;

import java.awt.*;

public class Rectangle extends AbstractGraphicObject {
    private int width;
    private int height;

    //Constructors
    public Rectangle() {
    }

    public Rectangle(Point pos, Color color, int a, int b) {
        super(pos, color);
        this.width = a;
        this.height = b;
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
    public boolean contains(Point p) {
        return false;
    }
}
