package cinema;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class QuanlyChung extends JFrame {
     int h = 600, w = 500;
     int ch = h / 12;
     int cw = w / 5;
     int x = 10, y = 10;
     
     private JPanel panContainerInfo_nhanvien, panIMG_nhanvien, panInfo_nhanvien;
     private JLabel labTenNhanvien, labChucVu;

     public QuanlyChung(){
          initComponents();
     }
     public void initComponents(){
          //Thiết kế cửa sổ
          setSize(w, h);
          setLocationRelativeTo(null);
          getContentPane().setBackground(new Color(255,240,235));
          setTitle("Giao diện quản lý chung");
          setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          SpringLayout layout_container = new SpringLayout();
          setLayout(layout_container);

          panContainerInfo_nhanvien = new JPanel();
          panContainerInfo_nhanvien.setBackground(Color.WHITE);
          add(panContainerInfo_nhanvien);
          
          layout_container.putConstraint(SpringLayout.HORIZONTAL_CENTER, panContainerInfo_nhanvien, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
          layout_container.putConstraint(SpringLayout.NORTH, panContainerInfo_nhanvien, 5, SpringLayout.NORTH, getContentPane());
          layout_container.putConstraint(SpringLayout.SOUTH, panContainerInfo_nhanvien, 200, SpringLayout.NORTH, panContainerInfo_nhanvien);
          layout_container.putConstraint(SpringLayout.WIDTH, panContainerInfo_nhanvien, 475, SpringLayout.WEST,  getContentPane());
          // panInfo_nhanvien = new JPanel();
          // panContainerInfo_nhanvien.add(panInfo_nhanvien);
          // panContainerInfo_nhanvien.setLayout(null);  
          // panInfo_nhanvien.setBackground(Color.WHITE);
          // panInfo_nhanvien.setBounds(5, 5, 200, 190);
          
          panIMG_nhanvien = new JPanel();
          panContainerInfo_nhanvien.add(panIMG_nhanvien);
          panContainerInfo_nhanvien.setLayout(null);
          panIMG_nhanvien.setBackground(Color.BLACK);
          panIMG_nhanvien.setBounds(320, 5, 150, 190);
          
          labTenNhanvien = new JLabel("Tên nhân viên:");
          labTenNhanvien.setFont(new Font("Arial", 0, 13));
          //panInfo_nhanvien.setLayout(null);
          panContainerInfo_nhanvien.add(labTenNhanvien);
          labTenNhanvien.setBounds(10, 10, 100, 13);

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
