package cinema;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class QuanlyChung extends JFrame {
     int h = 600, w = 1200;
     int ch = h / 12;
     int cw = w / 5;
     int x = 10, y = 10;
     
     public QuanlyChung(){
          initComponents();
     }
     public void initComponents(){
          //Thiết kế cửa sổ
          setSize(w, h);
          setLocationRelativeTo(null);
          getContentPane().setBackground(new Color(255,240,235));
          setTitle("Giao diện quản lý vé đặt");
          setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          SpringLayout layout_container = new SpringLayout();
          setLayout(layout_container);

          
          System.out.println("Hú em ơi");


     }
     public static void main(String[] args) {
          try {
               for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                         javax.swing.UIManager.setLookAndFeel(info.getClassName());
                         break;
                    }
               }
          } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(QuanlyChung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(QuanlyChung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(QuanlyChung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(QuanlyChung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } 

          new QuanlyChung().setVisible(true);
     }
}
