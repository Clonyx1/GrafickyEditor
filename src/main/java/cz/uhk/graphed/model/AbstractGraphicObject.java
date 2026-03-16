package cz.uhk.graphed.model;

import java.awt.*;

public abstract class AbstractGraphicObject {
    protected Point position;
    protected Color color;

    //Constructors
    public AbstractGraphicObject(){

    }

    public AbstractGraphicObject(Point pos, Color color){
        this.position = pos;
        this.color = color;
    }

    //Get set
    public Point getPosition(){
        return position;
    }

    public void setPosition(Point position){
        this.position = position;
    }

    public void setPosition(int x, int y){
        this.position = new Point(x, y);
    }

    //Methods
    public abstract void draw(Graphics g);
    public abstract boolean contains(Point p);
}
