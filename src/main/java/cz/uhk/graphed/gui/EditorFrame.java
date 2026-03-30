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

    private List<Button> buttons = new ArrayList<>();
    private Button triangleBtn = new Button("Trojúhelník");
    private Button squareBtn = new Button("Čtverec");
    private Button rectBtn = new Button("Obdelník");
    private Button ovalBtn = new Button("Kruh");
    private Button moveBtn = new Button("Přesunout objekt");

    private AbstractGraphicObject selectedObject = null;
    private Point lastMousePos = null;

    String currentTool = "";

    public EditorFrame() {
        super("FIM Grafic Editor");
        initSampleData();
        //Add all buttons to buttons list
        initButtons();
        initToolbar();
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
                makeDecision(e);
                lastMousePos = e.getPoint();
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                selectedObject = null;
            }
        });
    }
    private void addMouseMotionListener(){
        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedObject != null){
                    int deltaX = e.getX() - lastMousePos.x;
                    int deltaY = e.getY() - lastMousePos.y;

                    selectedObject.move(deltaX, deltaY);
                }
                lastMousePos = e.getPoint();
                repaint();
            }
        });
    }
    //Decides what to do when mouse is pressed
    private void makeDecision(MouseEvent e){
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
        else if("MOVE".equals(currentTool)) {
            Point mousePos = e.getPoint();

            var canvasObjects = canvas.getGraphicObjects();

            for(AbstractGraphicObject object: canvasObjects){
                if(object.contains(mousePos)){
                    selectedObject = object;
                }
            }
        }
    }

    private void initButtons(){
        buttons.add(triangleBtn);
        buttons.add(squareBtn);
        buttons.add(rectBtn);
        buttons.add(ovalBtn);
        buttons.add(moveBtn);
    }

    private void initToolbar(){
        buttons.forEach(button -> {
            toolBar.add(button);
            toolBar.addSeparator();
        });

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
        moveBtn.addActionListener(e -> {
            currentTool = "MOVE";
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
