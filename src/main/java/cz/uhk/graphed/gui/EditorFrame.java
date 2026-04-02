package cz.uhk.graphed.gui;

import cz.uhk.graphed.enums.Tool;
import cz.uhk.graphed.model.*;
import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.util.ImageExporter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EditorFrame extends JFrame {
    private Canvas canvas = new Canvas();
    private ToolBar toolBar = new ToolBar(canvas);

    private Point lastMousePos = null;

    public EditorFrame() {
        super("FIM Grafic Editor");
        initSampleData();
        //Add all buttons to buttons list
        toolBar.initToolbar();
        addMouseEventListener();
        addMouseMotionListener();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(canvas, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);

        pack();
    }

    private void addMouseEventListener(){
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvas.makeDecision(toolBar.getCurrentTool(), e);
                lastMousePos = e.getPoint();
                repaint();
            }
        });
    }
    private void addMouseMotionListener(){
        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(canvas.getSelectedObject() != null){
                    int deltaX = e.getX() - lastMousePos.x;
                    int deltaY = e.getY() - lastMousePos.y;

                    var selectedObject = canvas.getSelectedObject();
                    selectedObject.move(deltaX, deltaY);
                    canvas.setSelectedObject(selectedObject);
                }
                lastMousePos = e.getPoint();
                repaint();
            }
        });
    }


    private void initSampleData() {
        Group group = new Group();
        group.add(new Rectangle(new Point(0, 0), Color.BLACK, 150, 150));
        group.add(new Oval(new Point(50, 25), Color.BLACK, 50, 50));
        group.add(new Oval(new Point(125, 25), Color.BLACK, 50, 50));

        Group group2 = new Group();
        group2.add(new Rectangle(new Point(100, 200), Color.BLACK, 100, 100));
        group2.add(new Oval(new Point(100, 275), Color.BLACK, 20, 20));
        group2.add(new Oval(new Point(125, 275), Color.BLACK, 20, 20));


        canvas.add(group);
        canvas.add(group2);
    }
}
