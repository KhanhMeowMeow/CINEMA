package cinema;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestImg {
    public TestImg() {
        Home();
    }

    void Home() {
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setSize(600, 600);

        JLabel lblImg = new JLabel();
        lblImg.setPreferredSize(new Dimension(300, 400));
        lblImg.setOpaque(true);
        lblImg.setBackground(Color.red);

        mainFrame.add(lblImg);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load image after the frame is displayed
        ImageIcon imageIcon = new ImageIcon("D:\\DuAn1\\CINEMA1\\src\\img\\ditto.jpg");
        Image image = imageIcon.getImage();
        
        // Use a fixed size for the image (e.g., 300x400)
        Image newImage = image.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        
        ImageIcon newImageIcon = new ImageIcon(newImage);
        lblImg.setIcon(newImageIcon);
    }

    public static void main(String[] args) {
        new TestImg();
        try {
            // Đường dẫn đến file ảnh
            String imagePath = "D:\\DuAn1\\CINEMA1\\src\\img\\ditto.jpg";

            // Đọc ảnh từ file
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Lấy kích thước ảnh
            int width = image.getWidth();
            int height = image.getHeight();

            // Hiển thị kích thước ảnh
            System.out.println("Kích thước ảnh: " + width + " x " + height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
