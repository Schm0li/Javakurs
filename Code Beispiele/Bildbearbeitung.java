import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class Bildbearbeitung {
    public static void main(String[] args) throws Exception {
        File file = new File("src/image.jpg");
        FileImageInputStream input = new FileImageInputStream(file);
        BufferedImage image = ImageIO.read(input);

        BufferedImage output = new BufferedImage(image.getWidth() / 2, image.getHeight() / 2,
                image.getType());

        for(int x = 0; x < image.getWidth(); x += 2) {
            for(int y = 0; y < image.getHeight(); y += 2) {
                int[] rgb = new int[4];
                Color[] oldColor = new Color[4];
                int[] gray = new int[4];

                rgb[0] = image.getRGB(x, y);
                rgb[1] = image.getRGB(x + 1, y);
                rgb[2] = image.getRGB(x, y + 1);
                rgb[3] = image.getRGB(x + 1, y + 1);

                for(int i = 0; i < 4; i++) {
                    oldColor[i] = new Color(rgb[i]);
                    gray[i] = (oldColor[i].getRed() + oldColor[i].getBlue() + oldColor[i].getGreen()) / 3;
                }

                int resultGray = (gray[0] + gray[1] + gray[2] + gray[3]) / 4;
                Color newColor = new Color(resultGray, resultGray, resultGray);
                output.setRGB(x / 2, y / 2, newColor.getRGB());
            }
        }

        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(output));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        FileOutputStream outputStream = new FileOutputStream("src/output.jpg");
        ImageIO.write(output, "jpg", outputStream);
    }
}
