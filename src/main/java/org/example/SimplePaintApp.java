package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SimplePaintApp extends JFrame {
    private Color currentColor = Color.BLACK; //Domyślny kolor lini
    private int strokeSize = 5; //Domyślna grubość lini
    private BufferedImage canvasImage; // Obraz płótna do rysowania

    public SimplePaintApp() {
        super("Prosta aplikacja do rysowania");
        canvasImage = new BufferedImage(800, 600, BufferedImage.TYPE_4BYTE_ABGR);
        fillCanvas(Color.WHITE); //Wypełnienie płótna kolorem białym
        DrawingPanel drawingPanel = new DrawingPanel();
        getContentPane().add(drawingPanel, BorderLayout.CENTER);

        createToolbar(); // Tworzenie paska narzędzi

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void fillCanvas(Color color) {
        Graphics2D g2d = canvasImage.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, canvasImage.getWidth(), canvasImage.getHeight());
        g2d.dispose();
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                canvasImage = ImageIO.read(fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(canvasImage, "PNG", fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void createToolbar() {
        JToolBar toolBar = new JToolBar();

        JButton openButton = new JButton("Otwórz");
        openButton.addActionListener(e -> openImage());
        toolBar.add(openButton);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> saveImage());
        toolBar.add(saveButton);

        JButton colorButton = new JButton("Kolor");
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Wybierz kolor", currentColor);
            if (chosenColor != null) {
                currentColor = chosenColor;
            }
        });
        toolBar.add(colorButton);

        JButton strokeButton = new JButton("Grubość");
        strokeButton.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(this, "Podaj grubość linii: ", strokeSize);
            try {
                strokeSize = Integer.parseInt(size);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nieprawidłowa wartość!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        toolBar.add(strokeButton);

        getContentPane().add(toolBar, BorderLayout.NORTH);
    }
}
