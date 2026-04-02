package cz.uhk.graphed.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group extends AbstractGraphicObject implements Iterable<AbstractGraphicObject> {
    List<AbstractGraphicObject> objects = new ArrayList<>();

    public Group(){
        position = new Point(0, 0);
    }
    public Group(List<AbstractGraphicObject> objects){
        this.objects = objects;
    }

    //Get set
    public void setColor(Color color) {
        for(var o : objects){
            o.setColor(color);
        }
    }

    public void add(AbstractGraphicObject object){
        objects.add(object);
    }
    @Override
    public void draw(Graphics g) {
        for(AbstractGraphicObject object : objects){
            object.draw(g);
        }
    }

    @Override
    public boolean contains(Point p) {
        for(var o : objects){
            if(o.contains(p)) return true;
        }
        return false;
    }

    @Override
    public void move(int dx, int dy){
        for(var o : objects){
            o.move(dx, dy);
        }
    }

    @Override
    public Iterator<AbstractGraphicObject> iterator() {
        return objects.iterator();
    }
}
