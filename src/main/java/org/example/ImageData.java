package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageData {
    private Color currentColor = Color.BLACK;; //Domyślny kolor lini
    private int strokeSize = 5; //Domyślna grubość lini
    private BufferedImage canvasImage; // Obraz płótna do rysowania
    private Point lineStart = null; //Punkt początkowy lini, zainicjowany jako null

    public ImageData() {
    }

    public ImageData(Color currentColor, int strokeSize, BufferedImage canvasImage, Point lineStart) {
        this.currentColor = currentColor;
        this.strokeSize = strokeSize;
        this.canvasImage = canvasImage;
        this.lineStart = lineStart;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public BufferedImage getCanvasImage() {
        return canvasImage;
    }

    public void setCanvasImage(BufferedImage canvasImage) {
        this.canvasImage = canvasImage;
    }

    public Point getLineStart() {
        return lineStart;
    }

    public void setLineStart(Point lineStart) {
        this.lineStart = lineStart;
    }

    public void initializeCanvasImage() {
        this.canvasImage = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
    }
}
