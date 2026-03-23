package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.*;
import cz.uhk.graphed.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class EditorFrame extends JFrame {
    private Canvas canvas = new Canvas();
    private JToolBar toolBar = new JToolBar();
    private Button triangleBtn = new Button("Trojúhelník");
    private Button squareBtn = new Button("Čtverec");
    private Button rectBtn = new Button("Obdelník");
    private Button ovalBtn = new Button("Kruh");
    String currentTool = "";

    public EditorFrame() {
        super("FIM Grafic Editor");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initToolbar();
        addMouseEventListener();

        add(canvas, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        initSampleData();

        pack();
    }

    private void addMouseEventListener(){
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if ("TRIANGLE".equals(currentTool)) {
                    EquilateralTriangle triangle = new EquilateralTriangle(e.getPoint(), 50, Color.black, true);

                    canvas.add(triangle);
                }
                else if("SQUARE".equals(currentTool)) {
                    Rectangle square = new Rectangle(e.getPoint(), Color.black, 50, 50);

                    canvas.add(square);
                }
                else if("RECTANGLE".equals(currentTool)) {
                    Rectangle rectangle = new Rectangle(e.getPoint(), Color.black, 100, 50);

                    canvas.add(rectangle);
                }
                else if("OVAL".equals(currentTool)) {
                    Oval oval = new Oval(e.getPoint(), Color.black, 50, 50);

                    canvas.add(oval);
                }
                repaint();
            }
        });
    }

    private void initToolbar(){
        toolBar.add(triangleBtn);
        toolBar.addSeparator();

        toolBar.add(squareBtn);
        toolBar.addSeparator();

        toolBar.add(rectBtn);
        toolBar.addSeparator();

        toolBar.add(ovalBtn);
        toolBar.addSeparator();

        createEventListeners();
    }

    private void createEventListeners(){
        triangleBtn.addActionListener(e -> {
            currentTool = "TRIANGLE";
        });
        rectBtn.addActionListener(e -> {
            currentTool = "RECTANGLE";
        });
        ovalBtn.addActionListener(e -> {
            currentTool = "OVAL";
        });
        squareBtn.addActionListener(e -> {
            currentTool = "SQUARE";
        });

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
