package cinema;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class QuanLyVe extends JFrame{
     private JPanel panPhim, panContainer;
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
          SpringLayout layout_container = new SpringLayout();
          setLayout(layout_container);
          
          
          //Thêm components
          panContainer = new JPanel();
          panContainer.setBackground(Color.gray);
          panPhim = new JPanel();
          panPhim.setPreferredSize(new Dimension(w, h/3));
          panPhim.setBackground(Color.PINK);

          scrPhim = new JScrollPane(panPhim); layout_container.putConstraint(SpringLayout.SOUTH, scrPhim, h/3, SpringLayout.NORTH, getContentPane());
          scrPhim.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
          add(scrPhim);
          layout_container.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrPhim, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
          layout_container.putConstraint(SpringLayout.WEST, scrPhim, 10, SpringLayout.WEST, getContentPane());
          layout_container.putConstraint(SpringLayout.NORTH, scrPhim, 10, SpringLayout.NORTH, getContentPane());
          layout_container.putConstraint(SpringLayout.SOUTH, scrPhim, h/3, SpringLayout.NORTH, scrPhim);
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
