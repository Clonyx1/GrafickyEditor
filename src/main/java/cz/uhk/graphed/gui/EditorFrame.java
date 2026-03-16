package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.Oval;
import cz.uhk.graphed.model.Rectangle;

import javax.swing.*;
import java.awt.*;

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
        canvas.add(new Rectangle(new Point(50, 70), Color.black, 50, 50));
        canvas.add(new Rectangle(new Point(0, 150), Color.green, 50, 100));
        canvas.add(new Rectangle(new Point(85, 100), Color.blue, 70, 50));
        canvas.add(new Oval(new Point(150, 200), Color.yellow, 25, 25));
    }
}
