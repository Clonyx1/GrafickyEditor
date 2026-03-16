package cz.uhk.graphed.model;

import java.awt.*;

public class Oval extends AbstractGraphicObject{
    private int width;
    private int height;

    public Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Oval(Point pos, Color color, int width, int height) {
        super(pos, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawOval(position.x, position.y, width, height);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}
