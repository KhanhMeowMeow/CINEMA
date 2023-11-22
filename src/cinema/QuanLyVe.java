package cinema;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Spring;
import javax.swing.SpringLayout;

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
          setLocationRelativeTo(null);
          getContentPane().setBackground(new Color(255,240,235));
          setTitle("Giao diện quản lý vé đặt");
          setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLayout(null);
          
          //Thêm components
          panPhim =  new JPanel();
          panPhim.setBackground(Color.lightGray);
          scrPhim = new JScrollPane(panPhim);   
          scrPhim.setBounds(0, 0, w, h/3);  
          panPhim.setPreferredSize(new Dimension( w, h/3));   
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
