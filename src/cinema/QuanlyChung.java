package cinema;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class QuanlyChung extends JFrame {
     int h = 430, w = 700;
     int ch = h / 12;
     int cw = w / 5;
     int x = 10, y = 10;
     
     private JPanel panContainerInfo_nhanvien, panIMG_nhanvien, panContainer_quanly;
     private JLabel labTenNhanvien, labChucVu;
     private JButton btnThongKe, btnQuanLyNhanSu, btnQuanLyxuatChieu, btnQuanLyPhim, btnQuanLyVe, btnDoiMatKhau, btnDangXuat;
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
          layout_container.putConstraint(SpringLayout.WIDTH, panContainerInfo_nhanvien, 670, SpringLayout.WEST,  getContentPane());
          
          panIMG_nhanvien = new JPanel();
          panContainerInfo_nhanvien.add(panIMG_nhanvien);
          panContainerInfo_nhanvien.setLayout(null);
          panIMG_nhanvien.setBackground(Color.BLACK);
          panIMG_nhanvien.setBounds(515, 5, 150, 190);

          labTenNhanvien = new JLabel("Tên nhân viên:");
          labTenNhanvien.setFont(new Font("Arial", 0, 20));
          panContainerInfo_nhanvien.add(labTenNhanvien);
          labTenNhanvien.setBounds(10, 10, 150, 20);
          labTenNhanvien.setHorizontalAlignment(SwingConstants.RIGHT);
          labTenNhanvien.setBackground(Color.pink);;

          labChucVu = new JLabel("Chức vụ:");
          labChucVu.setFont(new Font("Arial", 0, 20));
          labChucVu.setBackground(Color.gray);
          panContainerInfo_nhanvien.add(labChucVu);
          labChucVu.setBounds(10, 35, 150, 20);
          labChucVu.setHorizontalAlignment(SwingConstants.RIGHT);

          panContainer_quanly = new JPanel();
          add(panContainer_quanly);
          panContainer_quanly.setBackground(new Color(255,240,235));

          layout_container.putConstraint(SpringLayout.HORIZONTAL_CENTER, panContainer_quanly,0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
          layout_container.putConstraint(SpringLayout.NORTH, panContainer_quanly,10, SpringLayout.SOUTH, panContainerInfo_nhanvien);
          layout_container.putConstraint(SpringLayout.WIDTH, panContainer_quanly,470, SpringLayout.WEST, getContentPane());
          layout_container.putConstraint(SpringLayout.SOUTH, panContainer_quanly, 170, SpringLayout.NORTH, panContainer_quanly);

          int x_btn = 150;
          int y_btn = 50;
          Font fontbtn = new Font("Arial", 0, 12);
          btnThongKe = new JButton("Thống kê doanh thu");
          btnQuanLyxuatChieu = new JButton("Quản lý xuất chiếu");
          btnQuanLyVe = new JButton("Quản lý vé");
          btnQuanLyPhim = new JButton("Quản lý phim");
          btnQuanLyNhanSu = new JButton("Quản lý nhân sự");
          btnDangXuat = new JButton("Đăng xuất");
          btnDoiMatKhau = new JButton("Đổi mật khẩu");
          panContainer_quanly.setLayout(null);
          panContainer_quanly.add(btnThongKe);
          panContainer_quanly.add(btnQuanLyxuatChieu);
          panContainer_quanly.add(btnQuanLyVe);
          panContainer_quanly.add(btnQuanLyPhim);
          panContainer_quanly.add(btnQuanLyNhanSu);
          panContainer_quanly.add(btnDangXuat);
          panContainer_quanly.add(btnDoiMatKhau);
          btnThongKe.setFont(fontbtn);
          btnQuanLyxuatChieu.setFont(fontbtn);
          btnQuanLyVe.setFont(fontbtn);
          btnQuanLyPhim.setFont(fontbtn);
          btnQuanLyNhanSu.setFont(fontbtn);
          btnDoiMatKhau.setFont(fontbtn);
          btnDangXuat.setFont(fontbtn);
          btnThongKe.setBounds(5, 5, x_btn, y_btn);
          btnDoiMatKhau.setBounds(5, 60, x_btn, y_btn);
          btnDangXuat.setBounds(160, 115, x_btn, y_btn);
          btnQuanLyNhanSu.setBounds(160, 5, x_btn, y_btn);
          btnQuanLyPhim.setBounds(160, 60, x_btn, y_btn);
          btnQuanLyVe.setBounds(315, 5, x_btn, y_btn);
          btnQuanLyxuatChieu.setBounds(315, 60, x_btn, y_btn);
          
          btnThongKe.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });
          btnQuanLyxuatChieu.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });
          btnQuanLyVe.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });
          btnQuanLyPhim.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });
          btnQuanLyNhanSu.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });
          btnDoiMatKhau.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });
          btnDangXuat.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Comming soon !");
               }
          });

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
