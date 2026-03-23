package cz.uhk.graphed.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group extends AbstractGraphicObject {
    List<AbstractGraphicObject> objects = new ArrayList<>();

    public Group(){}
    public Group(List<AbstractGraphicObject> objects){
        this.objects = objects;
    }

    //Get set
    public List<AbstractGraphicObject> getObjects() {
        return objects;
    }
    public void setObjects(List<AbstractGraphicObject> objects) { this.objects = objects; }

    public void add(AbstractGraphicObject object){
        objects.add(object);
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 =  (Graphics2D) g;
        for(AbstractGraphicObject object : objects){
            object.draw(g2);
        }
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
