/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import DAO.PhimDAO;
import entity.Phim;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.*;
import utils.Auth;
import utils.XImage;
/**
 *
 * @author Truong
 */
public class ThongTinPhim {
    int h =650, w=500;
    JFrame mainFrame;
    JLabel lbltenphim,lbltlg,lbltl, lbltheloai, lblthoiluong, lblposter,lbldv,lbldienvien,
            lblnamsx, lblnamsanxuat, lblqgsx, lblquocgiasx, lblnd, lblnoidung ;
    String tenPhim; 
    JButton btnLogin, btnReg;
    JPanel header;
    void ThongTinPhim(){
    myMovie();
    filltoForm();
    loadUser();
}

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }
    void myMovie(){
        mainFrame = new JFrame("Thông tin phim");
        mainFrame.setSize(h,w);
        mainFrame.setResizable(false);
        mainFrame.setBounds(0, 0, w, h);  
        mainFrame.getContentPane().setBackground(new Color(255,240,235));
        header = new JPanel(new BorderLayout());
        header.setPreferredSize(new Dimension(w, 30));       
        JLabel back = new JLabel();
        back.setPreferredSize(new Dimension(50,25));
        back.setIcon(new ImageIcon("D:\\DuAn1\\CINEMA1\\src\\img\\back.png"));
        back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                new HomeTest();
                mainFrame.dispose();
            }
        });
         btnLogin = new JButton("Login");
        btnReg = new JButton("Register");
        btnLogin.setPreferredSize(new Dimension(90,25));
        btnReg.setPreferredSize(new Dimension(90,25));
//        btnLogin.setContentAreaFilled(false);
//        btnLogin.setBorderPainted(false);
//        btnReg.setContentAreaFilled(false);
//        btnReg.setBorderPainted(false);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DangNhap();
                mainFrame.dispose();
            }
        });
        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DangKy();
                mainFrame.dispose();
            }
        });
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        // Add login and register buttons to the button panel
        btnPanel.add(btnLogin);
        btnPanel.add(btnReg);

        // Add the button panel to the header
        header.add(btnPanel, BorderLayout.EAST);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        back.setBorder(emptyBorder);
        header.add(back,BorderLayout.WEST);

        JPanel body1 = new JPanel(new GridLayout(1,2));
        body1.setPreferredSize(new Dimension(w, 250));
        JPanel body1left = new  JPanel(new BorderLayout());
        body1left.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lblposter = new JLabel();
        lblposter.setPreferredSize(new Dimension(w/2,250));
        lblposter.setOpaque(true);
        lblposter.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        lblposter.setBackground(Color.red);
        body1left.add(lblposter);
         body1.add(body1left);
        
        JPanel body1right = new JPanel();
        body1right.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lbltenphim = new JLabel("Tên phim");
//        Border boldBorder = BorderFactory.createLineBorder(Color.BLACK, 2); // Đặt màu đen và độ rộng 2 pixel
        Border boldBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        lbltenphim.setBorder(boldBorder);
        lbltenphim.setPreferredSize(new Dimension(w/2,50));
        lbltenphim.setFont(new Font("", Font.BOLD, 15));
        lbltenphim.setHorizontalAlignment(JLabel.CENTER);
        JPanel body1righttt = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        body1righttt.setBackground(Color.green);
        body1righttt.setPreferredSize(new Dimension(w/2,150));
        lbltlg = new JLabel("Thời lượng: ");
        lbltl = new JLabel("Thể loại: ");
        lblthoiluong = new JLabel("tt");
        lblthoiluong.setOpaque(true);
        lblthoiluong.setPreferredSize(new Dimension(150,20));
//        lblthoiluong.setBackground(Color.red);
        lbltheloai = new JLabel("Tt");
        lbltheloai.setPreferredSize(new Dimension(150,20));
        lbltheloai.setOpaque(true);
//        lbltheloai.setBackground(Color.yellow);
        lbltl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 18));
        lblnamsx = new JLabel("Năm sản xuất: ");
        lblnamsanxuat = new JLabel();
        lblnamsanxuat.setOpaque(true);
        lblnamsanxuat.setPreferredSize(new Dimension(150,20));
        
        lblqgsx = new JLabel("Quốc gia: ");
        lblquocgiasx = new JLabel();
        lblnamsanxuat.setOpaque(true);
        lblquocgiasx.setBackground(Color.red);
        lblquocgiasx.setPreferredSize(new Dimension(150,20));
        
        lbldv = new JLabel("Diễn viên: ");
        lbldienvien = new JLabel();
        lbldv.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        lbldienvien.setPreferredSize(new Dimension(150,40));
        lbldienvien.setVerticalAlignment(JLabel.TOP); 
        lbldienvien.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        
        body1righttt.add(lbltlg);
        body1righttt.add(lblthoiluong);
        body1righttt.add(lbltl);
        body1righttt.add(lbltheloai);
        body1righttt.add(lblnamsx);
        body1righttt.add(lblquocgiasx);
        body1righttt.add(lblnamsanxuat);
        body1righttt.add(lblqgsx);
        body1righttt.add(lblquocgiasx);
        body1righttt.add(lbldv);
        body1righttt.add(lbldienvien);
        body1right.add(lbltenphim);
        body1right.add(body1righttt);
        body1.add(body1right);
        
        JPanel body2 = new JPanel();
        
        body2.setPreferredSize(new Dimension(w,150));
        JLabel nd = new JLabel("NỘI DUNG BỘ PHIM");
        nd.setPreferredSize(new Dimension(w,30));
        nd.setHorizontalAlignment(JLabel.CENTER);
        nd.setBorder(boldBorder);
        lblnd = new JLabel();
        lblnd.setPreferredSize(new Dimension(600,120));
        lblnd.setHorizontalAlignment(JLabel.LEFT); // Đặt căn lề ngang sang trái
        lblnd.setVerticalAlignment(JLabel.TOP);
        lblnd.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        body2.setLayout(new BorderLayout());
        body2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        body2.add(nd, BorderLayout.NORTH);

        body2.add(lblnd, BorderLayout.CENTER);
        
        JButton btnDatve = new JButton("Đặt vé ngay");
        btnDatve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Datve();
            }
            
        });
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(header);
        mainFrame.add(body1);
        mainFrame.add(body2);
        mainFrame.add(btnDatve);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    System.exit(0);
                   
                }
            });
    }
    PhimDAO dao = new PhimDAO();
    void filltoForm() {
        String sql = "SELECT * FROM Phim where tenphim=?";
        List<Phim> dsp = dao.selectBySQL(sql,tenPhim);
        Phim p = dsp.get(0);
        lbltenphim.setText(p.getTenPhim().toUpperCase());
        lbltheloai.setText(p.getTheLoai());
        lblthoiluong.setText(String.valueOf(p.getThoiLuong())+" phút");
        lblnamsanxuat.setText(String.valueOf(p.getNamSX()));
        if(p.getNoiDung()==null){
            lblnd.setText("Nội dung bộ phim đang cập nhật");
        }
        else
        lblnd.setText(("<html>" + p.getNoiDung().replaceAll("\n", "<br>") + "</html>"));
        lbldienvien.setText("<html>" + p.getDienVien().replaceAll("\n", "<br>") + "</html>");
        lblquocgiasx.setText(p.getNuocSX());
//        lblposter.setIcon(new ImageIcon(p.getPoster()));

        ImageIcon imageIcon = new ImageIcon(p.getPoster());
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(w/2, 250, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        lblposter.setIcon(newImageIcon);

    }
    
    void Datve(){
        if(!Auth.isLoginKH()){
            int chose = JOptionPane.showConfirmDialog(null, "Vui lòng đăng nhập!","",JOptionPane.YES_NO_OPTION);
            if(chose ==JOptionPane.YES_OPTION){
                new DangNhap();              
            }
        }
        
    }
    JPanel headerright = new JPanel();
    void loadUser(){
        if (Auth.isLoginKH()) {
            btnLogin.setVisible(false);
            btnReg.setVisible(false);
            headerright.setLayout(new BoxLayout(headerright, BoxLayout.LINE_AXIS));

            JLabel lblUserInfo = new JLabel("" + Auth.KH.getTenKH());
            lblUserInfo.setPreferredSize(new Dimension(100, 20));
            lblUserInfo.setHorizontalAlignment(JLabel.RIGHT);
            JButton btnLogout = new JButton("Log out");
            btnLogout.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Logout();
                    }
                    
                });
            
            lblUserInfo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
            headerright.add(Box.createHorizontalGlue()); // Add horizontal glue to push components to the right
            headerright.add(lblUserInfo);
            headerright.add(btnLogout);

            header.add(headerright);
        }
        else{
            headerright.setVisible(false);
            btnLogin.setVisible(true);
            btnReg.setVisible(true);
            
        }
        
    }
    
    void Logout(){
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Auth.Clear();
            loadUser();
        }
    }
    public static void main(String[] args) {
       ThongTinPhim ttp= new ThongTinPhim();
       ttp.ThongTinPhim();
    }
    
}
