package cinema;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class QuanLyVe extends JFrame{
     private JPanel panPhim;
     private JScrollPane scrPhim;
     private JTable tblPhim;

     public QuanLyVe(){
          initComponents();


     }
     private void initComponents() {
          int h = 600, w = 1200;
          int ch = h / 12;
          int cw = w / 5;
          int x = 10, y = 10;

          //Thiết kế cửa sổ
          setSize(w, h);
          //setLayout(null);
          setLocationRelativeTo(null);
          getContentPane().setBackground(new Color(255,240,235));
          setTitle("Giao diện quản lý vé đặt");
          setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          
          //Thêm components
          panPhim =  new JPanel();
          panPhim.setSize(w*3, h);
          panPhim.setBackground(Color.darkGray);

          scrPhim = new JScrollPane(panPhim);
          setSize(w, h/4);
          scrPhim.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          panPhim.setSize(w*3, h);
          panPhim.setBackground(Color.darkGray);
          add(scrPhim);
          




    
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
          java.util.logging.Logger.getLogger(DangNhapNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(DangNhapNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(DangNhapNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(DangNhapNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } 
          new QuanLyVe().setVisible(true);
     }
}
