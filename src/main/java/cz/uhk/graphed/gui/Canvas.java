package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.AbstractGraphicObject;
import cz.uhk.graphed.model.Group;

import javax.swing.*;
import javax.swing.plaf.ToolBarUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private Group graphicObjects = new Group();

    public Canvas(){
        setPreferredSize(new Dimension(800, 600));
    }

    public void add(AbstractGraphicObject object){
        graphicObjects.add(object);
    }

    //Get set
    public Group getGraphicObjects() {return graphicObjects;}
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        graphicObjects.draw(g);
    }
}
