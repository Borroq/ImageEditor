package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SimplePaintApp extends JFrame {

    public SimplePaintApp() {
        super("Prosta aplikacja do rysowania");

        ImageData imageData = new ImageData();
        imageData.initializeCanvasImage();

        Container contentPane = getContentPane();

        Toolbar toolbar = new Toolbar(imageData);
        toolbar.fillCanvas(imageData.getCanvasImage(), Color.WHITE); //Wypełnienie płótna kolorem białym

        DrawingPanel drawingPanel = new DrawingPanel(imageData);
        contentPane.add(drawingPanel, BorderLayout.CENTER);

        toolbar.createToolbar(imageData, contentPane); // Tworzenie paska narzędzi

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
