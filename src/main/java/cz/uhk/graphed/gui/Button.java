package cz.uhk.graphed.gui;

import javax.swing.*;
import java.awt.*;

public class Button extends JToggleButton {

    public Button(String text){
        setPreferredSize(new Dimension(100, 50));
        setText(text);
    }
}
