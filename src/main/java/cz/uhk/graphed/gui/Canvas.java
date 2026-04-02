package cz.uhk.graphed.gui;

import cz.uhk.graphed.enums.Tool;
import cz.uhk.graphed.model.*;
import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.util.ImageExporter;

import javax.swing.*;
import javax.swing.plaf.ToolBarUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Canvas extends JPanel {
    private List<AbstractGraphicObject> graphicObjects = new ArrayList<>();
    private AbstractGraphicObject selectedObject = null;

    public Canvas(){
        setPreferredSize(new Dimension(800, 600));
    }

    public void add(AbstractGraphicObject object){
        graphicObjects.add(object);
    }
    public void remove(AbstractGraphicObject object){
        graphicObjects.remove(object);
    }

    //Get set
    public List<AbstractGraphicObject> getGraphicObjects() {return graphicObjects;}
    public AbstractGraphicObject getSelectedObject(){return selectedObject;}
    public void setSelectedObject(AbstractGraphicObject selectedObject){this.selectedObject = selectedObject;}
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for(var o : graphicObjects){
            o.draw(g);
        }
    }

    public void makeDecision(Tool currentTool, MouseEvent e){
        switch (currentTool){
            case TRIANGLE:
                EquilateralTriangle triangle = new EquilateralTriangle(e.getPoint(), 50, Color.black, true);

                add(triangle);
                break;
            case SQUARE:
                cz.uhk.graphed.model.Rectangle square = new cz.uhk.graphed.model.Rectangle(e.getPoint(), Color.black, 50, 50);

                add(square);
                break;
            case RECTANGLE:
                cz.uhk.graphed.model.Rectangle rectangle = new Rectangle(e.getPoint(), Color.black, 100, 50);

                add(rectangle);
                break;
            case OVAL:
                Oval oval = new Oval(e.getPoint(), Color.black, 50, 50);

                add(oval);
                break;
            case CHOOSE:
                Point mousePos = e.getPoint();

                var canvasObjects = getGraphicObjects();

                for(AbstractGraphicObject object: canvasObjects){
                    if(object.contains(mousePos)){
                        selectedObject = object;
                    }
                }
                break;
            case CHANGE_COLOR:
                changeColor();
                break;
        }
    }

    public void makeDecision(Tool currentTool){
        Point pos = new Point();
        int edgeLenght = 0;
        Random r = new Random();
        int width = 0;
        int height = 0;

        switch (currentTool){
            case RANDOM_SQUARE:
                edgeLenght = r.nextInt(35, 100);

                pos = getRandomPoint(edgeLenght, edgeLenght);

                Rectangle randomSquare = new Rectangle(pos, Color.black, edgeLenght, edgeLenght);

                add(randomSquare);
                repaint();
                break;
            case RANDOM_TRIANGLE:
                edgeLenght = r.nextInt(35, 100);

                pos = getRandomPoint(edgeLenght, edgeLenght);

                EquilateralTriangle t = new EquilateralTriangle(pos ,edgeLenght, Color.black, true);

                add(t);
                repaint();
                break;
            case RANDOM_RECTANGLE:
                width = r.nextInt(35, 100);
                height = r.nextInt(35, 100);

                pos = getRandomPoint(width, height);
                Rectangle randomRectangle = new Rectangle(pos, Color.black, width, height);

                add(randomRectangle);
                repaint();
                break;
            case RANDOM_OVAL:
                width = r.nextInt(35, 100);
                height = r.nextInt(35, 100);

                pos = getRandomPoint(width, height);
                Oval randomOval = new Oval(pos, Color.black, width, height);

                add(randomOval);
                repaint();
                break;
            case CHANGE_COLOR:
                changeColor();
                break;
            case DELETE:
                if(selectedObject != null){
                    remove(selectedObject);
                    selectedObject = null;
                    repaint();
                }
                break;
            case SAVE_IMG:
                ImageExporter imgExporter = new ImageExporter();
                imgExporter.saveCanvasAsPng(this);
                JOptionPane.showMessageDialog(this, "Image saved successfully", "INFORMATION",  JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    private Point getRandomPoint(int width, int height){
        Random r = new Random();

        Point pos = new Point();
        pos.x = r.nextInt(getWidth() - width);
        pos.y = r.nextInt(getHeight() - height);

        return pos;
    }

    private void changeColor(){
        if(selectedObject != null){
            Color newColor = JColorChooser.showDialog(null, "Vyber barvu", Color.green);

            if(newColor != null){
                selectedObject.setColor(newColor);
                repaint();
            }
        }
    }
}
