package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.*;
import cz.uhk.graphed.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditorFrame extends JFrame {
    private Canvas canvas = new Canvas();

    public EditorFrame() {
        super("FIM Grafic Editor");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(canvas, BorderLayout.CENTER);
        initSampleData();

        pack();
    }

    private void initSampleData() {
        /*canvas.add(new Rectangle(new Point(50, 70), Color.black, 50, 50));
        canvas.add(new EquilateralTriangle(new Point(100, 100),50, Color.black, true));
        canvas.add(new Oval(new Point(150, 200), Color.yellow, 25, 25));*/

        Rectangle rect = new Rectangle(new Point(50, 70), Color.black, 50, 50);
        EquilateralTriangle triangle = new EquilateralTriangle(new Point(100, 100),50, Color.black, true);

        List<AbstractGraphicObject> objectList = new ArrayList<>();
        objectList.add(triangle);
        objectList.add(rect);

        Group group = new Group(objectList);
        List<AbstractGraphicObject> groupList = group.getObjects();
        groupList.forEach(o -> { canvas.add(o); });
    }
}
