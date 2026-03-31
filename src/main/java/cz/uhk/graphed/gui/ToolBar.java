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
        add(createButton("Čtverec", Tool.SQUARE));
        addSeparator();
        add(createButton("Obdelník", Tool.RECTANGLE));
        addSeparator();
        add(createButton("Trojúhelník", Tool.TRIANGLE));
        addSeparator();
        add(createButton("Kruh", Tool.OVAL));
        addSeparator();
        add(createButton("Náhodný čtverec", Tool.RANDOM_SQUARE));
        addSeparator();
        add(createButton("Náhodný obdelník", Tool.RANDOM_RECTANGLE));
        addSeparator();
        add(createButton("Náhodný trojúhelník", Tool.RANDOM_TRIANGLE));
        addSeparator();
        add(createButton("Náhodný ovál", Tool.RANDOM_OVAL));
        addSeparator();
        add(createButton("Změnit barvu", Tool.CHANGE_COLOR));
        addSeparator();
        add(createButton("Vybrat", Tool.CHOOSE));
        addSeparator();
        add(createButton("Vymazat", Tool.DELETE));
        addSeparator();
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
