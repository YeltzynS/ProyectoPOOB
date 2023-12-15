package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MiPanel extends JPanel {

    public MiPanel() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage gomokuFondo = null;
        try {
            gomokuFondo = ImageIO.read(new File("tituloDelJUEGO.png"));
            System.out.println("Se cargo la imagen");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        g.drawImage(gomokuFondo, 0, 0, 800, 150, null);
    }
}