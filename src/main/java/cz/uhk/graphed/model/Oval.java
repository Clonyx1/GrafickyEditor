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

        g2.setColor(color);
        g2.drawOval(position.x, position.y, width, height);
    }

    @Override
    public boolean contains(Point p) {
        //Rovnice (x-m)^2/a^2 + (y-n)^2/b^2=1, kde [m,n] je střed, a polovina šířky a b polovina výšky

        int x = position.x;
        int y = position.y;

        int m = x + width / 2;
        int n = y + height / 2;

        double a = width / 2.0;
        double b = height / 2.0;

        //Elipsa, kterou hledám
        double target = (Math.pow(x-m, 2))/Math.pow(a, 2) + (Math.pow(y-n, 2))/Math.pow(b, 2);

        int mouseX = p.x;
        int mouseY = p.y;

        //Elipsa, která obsahuje myš
        double mouse = (Math.pow(mouseX - m, 2))/Math.pow(a, 2) + (Math.pow(mouseY - n, 2))/Math.pow(b, 2);

        //Pokud je elipsa myši menší číslo, elipsa obsahuje myš
        if(target > mouse) return true;

        return false;
    }
}
