package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SimplePaintApp extends JFrame {
/*    private Color currentColor = Color.BLACK; //Domyślny kolor lini
    private int strokeSize = 5; //Domyślna grubość lini
    private BufferedImage canvasImage; // Obraz płótna do rysowania
    private Point lineStart = null; //Punkt początkowy lini, zainicjowany jako null*/

    public SimplePaintApp() {
        super("Prosta aplikacja do rysowania");

        ImageData imageData = new ImageData();
        imageData.initializeCanvasImage();

        Container contentPane = getContentPane();

        Toolbar toolbar = new Toolbar(imageData);
        toolbar.fillCanvas(imageData.getCanvasImage(), Color.WHITE); //Wypełnienie płótna kolorem białym

        DrawingPanel drawingPanel = new DrawingPanel(imageData);
        getContentPane().add(drawingPanel, BorderLayout.CENTER);


       /* toolbar.openImage(imageData.getCanvasImage());
        toolbar.saveImage(imageData.getCanvasImage());*/
        toolbar.createToolbar(imageData, contentPane); // Tworzenie paska narzędzi

        //createToolbar(imageData);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//================ WYDZIELIC DO OSOBNEJ KLASY =============================


  /* private void fillCanvas(BufferedImage canvasImage, Color color) {
        Graphics2D g2d = canvasImage.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, canvasImage.getWidth(), canvasImage.getHeight());
        g2d.dispose();
    }

    private void openImage(BufferedImage canvasImage) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                canvasImage = ImageIO.read(fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveImage(BufferedImage canvasImage) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(canvasImage, "PNG", fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void createToolbar(ImageData imageData) {
        JToolBar toolBar = new JToolBar();
        BufferedImage canvasImage = imageData.getCanvasImage();


        JButton openButton = new JButton("Otwórz");
        openButton.addActionListener(e -> openImage(canvasImage));
        toolBar.add(openButton);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> saveImage(canvasImage));
        toolBar.add(saveButton);

        JButton colorButton = new JButton("Kolor");
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Wybierz kolor", imageData.getCurrentColor());
            if (chosenColor != null) {
                imageData.setCurrentColor(chosenColor);
            }
        });
        toolBar.add(colorButton);

        JButton strokeButton = new JButton("Grubość");
        strokeButton.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(this, "Podaj grubość linii: ", imageData.getStrokeSize());
            try {
                imageData.setStrokeSize(Integer.parseInt(size));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nieprawidłowa wartość!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        toolBar.add(strokeButton);

        getContentPane().add(toolBar, BorderLayout.NORTH);
    }*/



}
