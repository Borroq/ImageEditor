package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawingPanel extends JPanel {
    ImageData imageData;

    public DrawingPanel(ImageData imageData) {
        this.imageData = imageData;
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                imageData.setLineStart(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                imageData.setLineStart(null); //Reset starting point after releasing the mouse
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(imageData.getLineStart() != null) {
                    drawLine(e.getPoint());
                    imageData.setLineStart(e.getPoint());
                }
            }
        });
    }

    private void drawLine(Point endPoint) {
        Graphics2D g2d = imageData.getCanvasImage().createGraphics();
        g2d.setColor(imageData.getCurrentColor());
        g2d.setStroke(new BasicStroke(imageData.getStrokeSize()));
        g2d.drawLine(imageData.getLineStart().x, imageData.getLineStart().y, endPoint.x, endPoint.y);
        g2d.dispose();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageData.getCanvasImage(), 0, 0, this);
    }
}
