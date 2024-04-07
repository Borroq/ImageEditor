package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SimplePaintApp extends JFrame {
    private Color currentColor = Color.BLACK; //Domyślny kolor lini
    private int strokeSize = 5; //Domyślna grubość lini
    private BufferedImage canvasImage; // Obraz płótna do rysowania
    private Point linkStart = null; //Punkt początkowy lini, zainicjowany jako null

    public SimplePaintApp()  {
        super("Prosta aplikacja do rysowania");
        canvasImage = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
        /*fillCanvas(Color.WHITE); //Wypełnienie płótna kolorem białym
        DrawingPanel drawingPanel = new DrawingPanel;
        getContentPane().add(drawingPanel, BorderLayout.CENTER);

        createToolbar(); // Tworzenie paska narzędzi

        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);*/
    }
}
