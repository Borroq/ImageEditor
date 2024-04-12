package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Toolbar extends JFrame {

    ImageData imageData;
    public Toolbar(ImageData imageData) {
        this.imageData = imageData;
    }

/*    public void fillCanvas(BufferedImage canvasImage, Color color) {
        Graphics2D g2d = canvasImage.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, canvasImage.getWidth(), canvasImage.getHeight());
        g2d.dispose();
    }

    public void openImage(ImageData imageData) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                imageData.setCanvasImage(ImageIO.read(fileChooser.getSelectedFile()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveImage(ImageData imageData) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(imageData.getCanvasImage(), "PNG", fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void createToolbar(ImageData imageData) {
        JToolBar toolBar = new JToolBar();

        JButton openButton = new JButton("Otwórz");
        openButton.addActionListener(e -> openImage(imageData));
        toolBar.add(openButton);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> saveImage(imageData));
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

    public void fillCanvas(BufferedImage imageData, Color color) {
        Graphics2D g2d = imageData.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, imageData.getWidth(), imageData.getHeight());
        g2d.dispose();
    }

    public void openImage(ImageData imageData) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                imageData.setCanvasImage(ImageIO.read(fileChooser.getSelectedFile()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveImage(ImageData imageData) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(imageData.getCanvasImage(), "PNG", fileChooser.getSelectedFile());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void createToolbar(ImageData imageData, Container contentPane) {
        JToolBar toolBar = new JToolBar();
        //BufferedImage canvasImage = imageData.getCanvasImage();


        JButton openButton = new JButton("Otwórz");
        openButton.addActionListener(e -> openImage(imageData));
        toolBar.add(openButton);

        JButton saveButton = new JButton("Zapisz");
        saveButton.addActionListener(e -> saveImage(imageData));
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

        contentPane.add(toolBar, BorderLayout.NORTH);
    }
}
