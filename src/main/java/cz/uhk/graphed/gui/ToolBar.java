package cz.uhk.graphed.gui;

import cz.uhk.graphed.enums.Tool;

import javax.swing.*;

public class ToolBar extends JToolBar {
    private Tool currentTool = null;
    private Canvas canvas;

    public ToolBar(Canvas canvas) {
        this.canvas = canvas;
    }

    //Get set
    public Tool getCurrentTool() {
        return currentTool;
    }

    public void initToolbar(){
        add(createButton("Square", Tool.SQUARE));
        addSeparator();
        add(createButton("Rectangle", Tool.RECTANGLE));
        addSeparator();
        add(createButton("Triangle", Tool.TRIANGLE));
        addSeparator();
        add(createButton("Oval", Tool.OVAL));
        addSeparator();
        add(createButton("Random square", Tool.RANDOM_SQUARE));
        addSeparator();
        add(createButton("Random rectangle", Tool.RANDOM_RECTANGLE));
        addSeparator();
        add(createButton("Random triangle", Tool.RANDOM_TRIANGLE));
        addSeparator();
        add(createButton("Random oval", Tool.RANDOM_OVAL));
        addSeparator();
        add(createButton("Change color", Tool.CHANGE_COLOR));
        addSeparator();
        add(createButton("Select", Tool.CHOOSE));
        addSeparator();
        add(createButton("Delete", Tool.DELETE));
        addSeparator();
        add(createButton("Save", Tool.SAVE_IMG));
    }

    private JButton createButton(String text, Tool tool){
        JButton btn =  new JButton(text);
        btn.addActionListener(e -> {
            currentTool = tool;
            canvas.makeDecision(currentTool);
        });

        return btn;
    }
}
