package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CreateToolbar extends JFrame {
     private Color currentColor;
    private BufferedImage canvasImage;
    private int strokeSize = 5; //Domyślna grubość lini

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public BufferedImage getCanvasImage() {
        return canvasImage;
    }

    public void setCanvasImage(BufferedImage canvasImage) {
        this.canvasImage = canvasImage;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }



    public CreateToolbar() {

    }

    public void fillCanvas(Color color) {
        Graphics2D g2d = canvasImage.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, getCanvasImage().getWidth(), getCanvasImage().getHeight());
        g2d.dispose();
    }

    public void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                setCanvasImage(ImageIO.read(fileChooser.getSelectedFile()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(getCanvasImage(), "PNG", fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void createToolbar() {
        JToolBar toolBar = new JToolBar();

        JButton openButton = new JButton("Otwórz");
        openButton.addActionListener(e -> openImage());
        toolBar.add(openButton);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> saveImage());
        toolBar.add(saveButton);

        JButton colorButton = new JButton("Kolor");
        colorButton.addActionListener(e -> {
            Color chosenColor = JColorChooser.showDialog(this, "Wybierz kolor", getCurrentColor());
            if (chosenColor != null) {
                setCurrentColor(chosenColor);
            }
        });
        toolBar.add(colorButton);

        JButton strokeButton = new JButton("Grubość");
        strokeButton.addActionListener(e -> {
            String size = JOptionPane.showInputDialog(this, "Podaj grubość linii: ", getStrokeSize());
            try {
                setStrokeSize(Integer.parseInt(size));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nieprawidłowa wartość!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        toolBar.add(strokeButton);

        getContentPane().add(toolBar, BorderLayout.NORTH);
    }
}
