package service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CustomImageCreator {
    public static void createAndWriteImage(int count, HttpServletResponse resp) throws IOException {
        BufferedImage image = new BufferedImage(600,200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Serif", Font.BOLD, 48));
        graphics2D.setColor(Color.RED);
        graphics2D.drawString(String.valueOf(count), 120, 78);
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);
    }
}
