/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import entity.KhachHang;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utils.MsgBox;


/**
 *
 * @author ngoth
 */
public class QuenMK_1 {
    int h = 300, w = 700;
    // ch: component high
    int ch = h / 10;
    int cw = w / 5;
    int x = 10, y = 10;
    JFrame mainFrame;
    JLabel lblTitle, lblClose, lblNV, lblKH;
    JPanel mainPanel;
    JButton btnKH,btnNV;

    String password;
    NhanVien nv;
    KhachHang kh;

    public QuenMK_1() {
        this.password = password;
        this.nv = nv;
        this.kh = kh;
        myGUI();
    }
    
    private void myGUI(){
        mainFrame = new JFrame();
        mainFrame.setSize(w, h);
        mainFrame.setLayout(null);
        mainFrame.setUndecorated(true);
        mainFrame.setLocationRelativeTo(null);
        
        lblClose = new JLabel("x");
        lblClose.setFont(new Font("Arial", 1, 30));
        lblClose.setBounds(w-35, 0, 50, 50);
        lblClose.setCursor(new Cursor(12));
        lblClose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent me) {
                lblClose.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent me) {
                lblClose.setForeground(Color.black);
            }
        });
        mainFrame.add(lblClose);
        
        lblTitle = new JLabel("Bạn đăng nhập với vai trò ?", JLabel.CENTER);
        lblTitle.setBounds(40, 30, w-80 + 0, ch+30);
        lblTitle.setFont(new Font("Arial", 1, 30));
        lblTitle.setOpaque(true);
        //lblTitle.setBackground(Color.yellow);
        mainFrame.add(lblTitle);
        
        y+=90;
        mainPanel = new JPanel(new FlowLayout(0, 40, 20));
       // mainPanel.setBackground(Color.green);
        mainPanel.setBounds(80, y, w-140, h/2+40);
        mainFrame.add(mainPanel);
        
        ImageIcon nv = new ImageIcon("D:\\CINEMA\\src\\img\\user.png");
        btnNV = new JButton(nv);
        btnNV.setPreferredSize(new Dimension(cw+80, ch*2+20));
        btnNV.setName("Nhan Vien");
        btnNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              // KiemTraMK(btnNV.getName());
            }
        });
        mainPanel.add(btnNV);
        
        ImageIcon kh = new ImageIcon("D:\\CINEMA\\src\\img\\kh.png");
        btnKH = new JButton(kh);
        btnKH.setPreferredSize(new Dimension(cw+80, ch*2+20));
        btnKH.setName("Khach Hang");
        btnKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
            }
        });
        mainPanel.add(btnKH);
        
        lblNV = new JLabel("Nhân viên",JLabel.CENTER);
        lblNV.setPreferredSize(new Dimension(cw+80, ch));
        lblNV.setFont(new Font("Arial", 1, 24));       
        mainPanel.add(lblNV);
        
        lblKH = new JLabel("Khách hàng",JLabel.CENTER);
        lblKH.setPreferredSize(new Dimension(cw+80, ch));
        lblKH.setFont(new Font("Arial", 1, 24));
        mainPanel.add(lblKH);
        
        mainFrame.setVisible(true);
    
    }
    KhachHangDAO khdao = new KhachHangDAO();
    private void KiemTraMK(String vaiTro)
    {
        if(vaiTro.equals("Khach Hang"))
        {
//            KhachHang kh = khdao.SelectById(txtEmail.getText());
//            kh.setMatKhau(mk1);
//            khdao.Update(kh);
//            JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu thành công!!");
        }
        else 
        {
          
        }
    }
    
    public static void main(String[] args) {
        new QuenMK_1();
    }
}
