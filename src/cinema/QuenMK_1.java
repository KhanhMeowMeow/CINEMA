/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import DAO.NhanVienDAO;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utils.MsgBox;
import utils.XEmail;

/**
 *
 * @author ngoth
 */
public class QuenMK_1 {
    int h = 480, w = 700;
    // ch: component high
    int ch = h / 10;
    int cw = w / 4;
    int x = 10, y = 10;
    
    JFrame mainFrame;
    JLabel lblTitle,lblTitle1, lblClose,lblClose1, lblEmail, lblOTP,firstPanel,secondPanel, lblMK, lblXN_MK;
    JTextField txtEmail, txtOTP, txtMK, txtXN_MK,txtEmail1;
    JPanel mainPanel, btnPanel,mainPanel1,btnPanel1;
    JButton btnGui,btnXacNhan,btnXNMK;

    public QuenMK_1() {
        myGUI();
txtEmail.setText("bolu300@fpt.edu.vn");
       // CN();
    }
    
    private void myGUI(){
        mainFrame = new JFrame();
        mainFrame.setSize(w, h);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(new Color(255,240,235));
        mainFrame.setUndecorated(true);
        mainFrame.setLocationRelativeTo(null);
        
        firstPanel = new JLabel();
        firstPanel.setBounds(0, 0, w, h);
        firstPanel.setBackground(new Color(235,240,235));
               
        lblTitle = new JLabel("QUÊN MẬT KHẨU",JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", 1, 35));
        lblTitle.setBounds(0, y*4, w, ch*2-30);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(255,240,235));
        firstPanel.add(lblTitle);
        
        lblClose = new JLabel("x");
        lblClose.setFont(new Font("Arial", 1, 30));
        lblClose.setPreferredSize(new Dimension(50, 50));
        lblClose.setBounds(w-30, 0, 50, 50);
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
        firstPanel.add(lblClose);
        
        y+=90;
        mainPanel = new JPanel(new FlowLayout(0,10,30));
        mainPanel.setBounds(x, y, w-20, h/2-50);
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(255,240,235));
        firstPanel.add(mainPanel); 
        
        lblEmail = new JLabel("Email",JLabel.RIGHT);
        lblEmail.setPreferredSize(new Dimension(cw-90, ch));
        lblEmail.setFont(new Font("Arial", 1, 20));
        lblEmail.setOpaque(true);
        lblEmail.setBackground(new Color(255,240,235));
        mainPanel.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBorder(new LineBorder(Color.black, 1, true));
        txtEmail.setPreferredSize(new Dimension(3*cw-100, ch));
        mainPanel.add(txtEmail);
        
        btnGui = new JButton("Gửi");
        btnGui.setBackground(Color.pink);
        btnGui.setPreferredSize(new Dimension(cw-60, ch));
        btnGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              xacNhanNV();
            }
        });
        mainPanel.add(btnGui);
        ///
        lblOTP = new JLabel("OTP",JLabel.RIGHT);
        lblOTP.setPreferredSize(new Dimension(cw-90, ch));
        lblOTP.setFont(new Font("Arial", 1, 20));
        lblOTP.setOpaque(true);
        lblOTP.setBackground(new Color(255,240,235));
        mainPanel.add(lblOTP);
        
        txtOTP = new JTextField();
        txtOTP.setBorder(new LineBorder(Color.black, 1, true));
        txtOTP.setPreferredSize(new Dimension(3*cw-100, ch));
        mainPanel.add(txtOTP);
        
        y+=200;
        btnPanel = new JPanel();
        btnPanel.setBounds(x, y, w-50, ch*2);
        btnPanel.setOpaque(true);
        btnPanel.setBackground(Color.white);
       // btnPanel.setBackground(new Color(255,240,235));
        firstPanel.add(btnPanel);
        
        btnXacNhan = new JButton("XÁC NHẬN");
        btnXacNhan.setPreferredSize(new Dimension(cw+20, ch));
        btnXacNhan.setBackground(Color.pink);
        btnPanel.add(btnXacNhan);
        ////////////////////////////////
        
        secondPanel = new JLabel();
        secondPanel.setBounds(0, 0, w, h);
        secondPanel.setOpaque(true);
        secondPanel.setBackground(Color.yellow);
        
        lblTitle1 = new JLabel("QUÊN MẬT KHẨU",JLabel.CENTER);
        lblTitle1.setFont(new Font("Arial", 1, 35));
        lblTitle1.setBounds(0, y*4, w, ch*2-30);
        lblTitle1.setOpaque(true);
        lblTitle1.setBackground(new Color(255,240,235));
        secondPanel.add(lblTitle1);
        
        lblClose1 = new JLabel("x");
        lblClose1.setFont(new Font("Arial", 1, 30));
        lblClose1.setPreferredSize(new Dimension(50, 50));
        lblClose1.setBounds(w-30, 0, 50, 50);
        lblClose1.setCursor(new Cursor(12));

        lblClose1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent me) {
                lblClose1.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent me) {
                lblClose1.setForeground(Color.black);
            }
        });
        secondPanel.add(lblClose1);
        
        y+=90;
        mainPanel1 = new JPanel(new FlowLayout(0,10,30));
        mainPanel1.setBounds(x, y, w-20, h/2-50);
        mainPanel1.setOpaque(true);
        mainPanel1.setBackground(new Color(255,240,235));
        secondPanel.add(mainPanel1); 
        
        lblMK = new JLabel("MK",JLabel.RIGHT);
        lblMK.setPreferredSize(new Dimension(cw-90, ch));
        lblMK.setFont(new Font("Arial", 1, 20));
        lblMK.setOpaque(true);
        lblMK.setBackground(new Color(255,240,235));
        mainPanel1.add(lblMK);
        
        txtMK = new JTextField();
        txtMK.setBorder(new LineBorder(Color.black, 1, true));
        txtMK.setPreferredSize(new Dimension(3*cw-50, ch));
        mainPanel1.add(txtMK);
        
        lblXN_MK = new JLabel("Xac nhan",JLabel.RIGHT);
        lblXN_MK.setPreferredSize(new Dimension(cw-90, ch));
        lblXN_MK.setFont(new Font("Arial", 1, 20));
        lblXN_MK.setOpaque(true);
        lblXN_MK.setBackground(new Color(255,240,235));
        mainPanel1.add(lblXN_MK);
        
        txtXN_MK = new JTextField();
        txtXN_MK.setBorder(new LineBorder(Color.black, 1, true));
        txtXN_MK.setPreferredSize(new Dimension(3*cw-100, ch));
        mainPanel1.add(txtXN_MK);
        
        y+=200;
        btnPanel1 = new JPanel();
        btnPanel1.setBounds(x, y, w-50, ch*2);
        btnPanel1.setOpaque(true);
        btnPanel1.setBackground(Color.white);
       // btnPanel.setBackground(new Color(255,240,235));
        secondPanel.add(btnPanel1);
        
        
        mainFrame.add(secondPanel);
        mainFrame.add(firstPanel);
        mainFrame.setVisible(true);
    }
    
    void sendMail(){
        final String username = "username@gmail.com";
        final String password = "password";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ngothiducnhu3005@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(txtEmail.getText()) // email nhan
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    
    }
    
    public static void main(String[] args) {
        new QuenMK_1();
    }
    
    //QUEN MAT KHAU
    ////////////////////////////////////////////////////////
    
    Thread t;
    String maXacThuc = "";
    int index = 1;
        private void CN(){
        if (index == 1)
            this.guiMa(this.xacNhanNV());
        else if (index ==2)
            this.xacNhan();
//        else
//            this.doiMK();
    }
        private void initQMK() {
//        txtMK1.setVisible(false);
//        txtMK2.setVisible(false);
//        txtMaNV.setText("");
//        txtMaXacThuc.setText("");
//        txtMK1.setText("");
//        txtMK2.setText("");
//        lblThongBao.setText("Mời bạn lấy mã xác thực đổi mật khẩu");
       // this.setButton();
    }
        
        private void guiMa(NhanVien nv) {
        if (nv != null) {
            //txtEmail.setEnabled(false);

            for (int i = 0; i < 6; i++) {
                int ran = (int) (65 + Math.random() * 25);
                maXacThuc += String.valueOf((int) ran);
            }
            String[] thongTin = {nv.getEmailNV(), maXacThuc};
            XEmail mail = new XEmail(thongTin, 1);
            mail.guiEmail();
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 59; i >= 0; i--) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {}
                        String text = "Nhanh lên, bạn còn " + String.valueOf(i) + " giây!!";
                        //lblThongBao.setText(text);
                        if (i == 0) {
                            initQMK();
                            break;
                        }
                    }
                }
            });
            t.start();
            index = 2;
            //this.setButton();
            xacNhan();
        }

    }
        
    NhanVienDAO dao = new NhanVienDAO();
    private NhanVien xacNhanNV() {
        String Email = txtEmail.getText();
        NhanVien nv = dao.SelectById(Email);
        if (nv == null) {
           // lblThongBao.setText("Mã nhân viên không đúng");
           MsgBox.alert(null, "Email k dung!");
        }

        return nv;
    }

    private void xacNhan() {
        String maXacNhan = txtOTP.getText();
        if (maXacNhan.equals("")) {
            //lblThongBao.setText("Mã xác thực không đúng");
            MsgBox.alert(null, "OTP k dung");
        } else {
            if (maXacNhan.equals(maXacThuc)) {
//                txtMK1.setVisible(true);
//                txtMK2.setVisible(true);
                index = 3;
                //this.setButton();
               // txtMaXacThuc.setEnabled(false);
                t.stop();
                MsgBox.alert(null,"Mời bạn đổi mật khẩu");
                mainFrame.dispose();
                new QuenMK_2();
            } else {
                MsgBox.alert(null,"Mã xác nhận không đúng");
            }
        }
    }

    
    
//    private void setButton()
//    {
//        if(this.index == 1)
//            btnChucNang.setText("Gửi Mã");
//        else if (this.index == 2)
//            btnChucNang.setText("Xác Nhận");
//        else
//            btnChucNang.setText("Đổi Mật Khẩu");
//    }
}
