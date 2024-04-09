package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class DrawingPanel extends JPanel {

    private Point lineStart = null; //Punkt początkowy lini, zainicjowany jako null


    public DrawingPanel() {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lineStart = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lineStart = null; //Reset starting point after releasing the mouse
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(lineStart != null) {
                    // Tu skończyłem
                }
            }
        });
    }
}
