package cinema;
import DAO.PhimDAO;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import entity.Phim;
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
import utils.XImage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Truong
 */
public class HomeJFrame {
    PhimDAO dao = new PhimDAO();
    int h =650, w=700;
    int ch = h/10;
    int cw = w/4;
    int x=10,y=10;
    JFrame mainFrame;
    JLabel lblLogo, lblSlide,lblTen1, lblTen2, lblTen3; 
    JLabel lblPhimdc, lblPoster, lblPoster1, lblPoster2,lblPoster3;
    JTextField txtFind;
    JButton btnLogin, btnReg;
    JPanel headerPanel,panelleft;
    public HomeJFrame(){
        myHome();
        filltoForm();
    }

    Timer tm;
    int z = 0;
    String[] list = {
                      "C:\\Users\\Truong\\Downloads\\Image\\1.jpg",//0
                      "C:\\Users\\Truong\\Downloads\\Image\\2.jpg",
                       "C:\\Users\\Truong\\Downloads\\Image\\3.jpg",
            "C:\\Users\\Truong\\Downloads\\Image\\4.jpg",//0
                      "C:\\Users\\Truong\\Downloads\\Image\\5.jpg",
                       "C:\\Users\\Truong\\Downloads\\Image\\6.jpg"
                    };
    private void myHome() {
        mainFrame = new JFrame("Trang chủ");
        mainFrame.setSize(h,w);
        mainFrame.setBounds(0, 0, w, h);  
        mainFrame.getContentPane().setBackground(new Color(255,240,235));
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setTitle("Trang chủ");
        mainFrame.setResizable(false);  // Vô hiệu hóa khả năng thay đổi kích thước cửa sổ
        
    // Header trang chủ
        headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        FlowLayout flowLayout = (FlowLayout) headerPanel.getLayout();
        flowLayout.setHgap(20); // Khoảng cách theo chiều ngang
        headerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        headerPanel.setSize(w,h-600);
        headerPanel.setBackground(new Color(255,240,235));
        lblLogo=new JLabel();
        lblLogo.setPreferredSize(new Dimension(50,25));
        lblLogo.setIcon(new ImageIcon("D:\\DuAn1\\CINEMA\\src\\img\\c1.jpg"));
        txtFind = new JTextField();
        txtFind.setPreferredSize(new Dimension(300,25));
        txtFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi người dùng nhấn Enter
                Find();
            }
        });
        
        JButton searchButton = new JButton(new ImageIcon("D:\\DuAn1\\CINEMA\\src\\img\\search.png"));
        searchButton.setPreferredSize(new Dimension(25,25));
        FlowLayout searchPanelLayout = new FlowLayout();
        searchPanelLayout.setHgap(0); // Đặt khoảng cách ngang là 0
        JPanel searchPanel = new JPanel(searchPanelLayout);
        searchPanel.add(txtFind);
        searchPanel.add(searchButton);
        searchButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                Find();
            }
            
        });
        JButton btnLogin = new JButton("Login");
        JButton btnReg = new JButton("Register");
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

//        lblLogo.setBounds(x, y, cw + 50, ch);
        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(searchPanel);
//    headerPanel.add(txtFind, BorderLayout.CENTER);
//    headerPanel.add(searchButton, BorderLayout.EAST);
        headerPanel.add(btnReg, BorderLayout.SOUTH);
        headerPanel.add(btnLogin, BorderLayout.SOUTH);
     
        //Body1 Trang chủ
        JPanel body1 = new JPanel();
        body1.setLayout(new BoxLayout(body1, BoxLayout.X_AXIS));
        body1.setSize(w, 250);
//        body1.setBackground(Color.green);

        // Thêm panelleft và panelright vào body1
        panelleft = new JPanel();
        panelleft.setPreferredSize(new Dimension(400, 250));
        panelleft.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lblSlide = new JLabel();
        lblSlide.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lblSlide.setPreferredSize(new Dimension(380, 230));
        lblSlide.setOpaque(true); // Thêm dòng này để hiển thị màu sắc nền
//        lblSlide.setBackground(Color.GREEN);
        panelleft.add(lblSlide);
        body1.add(panelleft);

        JPanel panelright = new JPanel(new GridLayout(2, 1));
//        panelright.setBackground(Color.yellow);
        panelright.setPreferredSize(new Dimension(w - 400, 250));
        JLabel lblRightTop = new JLabel();
        lblRightTop.setIcon(new ImageIcon("C:\\Users\\Truong\\Downloads\\Image\\1.jpg"));
        lblRightTop.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 5)); // Khoảng trống 5px
        panelright.add(lblRightTop);

        // JLabel cho phần dưới
        JLabel lblRightBottom = new JLabel();
        lblRightBottom.setIcon(new ImageIcon("C:\\Users\\Truong\\Downloads\\Image\\3.jpg"));
        lblRightBottom.setBorder(BorderFactory.createEmptyBorder(5, 7, 5, 5)); // Khoảng trống 5px
        panelright.add(lblRightBottom);
        
         panelright.add(lblRightTop);
        panelright.add(lblRightBottom);
        body1.add(panelright);
        
        lblSlide.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentResized(java.awt.event.ComponentEvent evt) {
            // Đặt hình ảnh khi kích thước thay đổi
                SetImageSize(0);
            }
        });
               //set a timer
        tm = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(z);
                z += 1;
                if (z >= list.length) {
                        z = 0;
                    }
                }
            });
        tm.start(); 
    
        //Body2
        JPanel body2 = new JPanel();
        body2.setLayout(new BorderLayout());
        body2.setPreferredSize(new Dimension(w, 200));
        body2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lblPhimdc = new JLabel("PHIM ĐANG CHIẾU");
        lblPhimdc.setHorizontalAlignment(JLabel.CENTER);
        lblPhimdc.setVerticalAlignment(JLabel.NORTH);
        lblPhimdc.setFont(new Font("", Font.BOLD, 15));
        // Tạo các JPanel mới cho mỗi cặp lblPoster và lblTen
        JPanel panelPoster1 = new JPanel(new BorderLayout());
        JPanel panelPoster2 = new JPanel(new BorderLayout());
        JPanel panelPoster3 = new JPanel(new BorderLayout());

        // Thiết lập kích thước và màu nền cho lblPoster và lblTen
        lblPoster1 = new JLabel();
        lblPoster1.setPreferredSize(new Dimension(w/3, 50));
        lblPoster1.setOpaque(true);
        lblPoster1.setBackground(Color.red);

        lblTen1 = new JLabel();
        lblTen1.setPreferredSize(new Dimension(w/3, 30));
        lblTen1.setOpaque(true);
        lblTen1.setHorizontalAlignment(JLabel.CENTER);
        lblTen1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                hienthongtinPhim(lblTen1.getText());
                mainFrame.dispose();
            }
            
        });

        // Thiết lập kích thước và màu nền cho lblPoster và lblTen
        lblPoster2 = new JLabel();
        lblPoster2.setPreferredSize(new Dimension(w/3, 50));
        lblPoster2.setOpaque(true);
        lblPoster2.setBackground(Color.green);

        lblTen2 = new JLabel();
        lblTen2.setPreferredSize(new Dimension(w/3, 30));
        lblTen2.setOpaque(true);
        lblTen2.setHorizontalAlignment(JLabel.CENTER);
        lblTen2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                hienthongtinPhim(lblTen2.getText());
                mainFrame.dispose();
            }
            
        });
        
        // Thiết lập kích thước và màu nền cho lblPoster và lblTen
        lblPoster3 = new JLabel();
        lblPoster3.setPreferredSize(new Dimension(w/3, 50));
        lblPoster3.setOpaque(true);
        lblPoster3.setBackground(Color.blue);

        lblTen3 = new JLabel();
        lblTen3.setPreferredSize(new Dimension(w/3, 30));
        lblTen3.setOpaque(true);
        lblTen3.setHorizontalAlignment(JLabel.CENTER);
        lblTen3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                hienthongtinPhim(lblTen3.getText());
                mainFrame.dispose();
            }
            
        });
        
        // Thêm lblPoster và lblTen vào từng JPanel tương ứng
        panelPoster1.add(lblPoster1, BorderLayout.CENTER);
        panelPoster1.add(lblTen1, BorderLayout.SOUTH);

        panelPoster2.add(lblPoster2, BorderLayout.CENTER);
        panelPoster2.add(lblTen2, BorderLayout.SOUTH);

        panelPoster3.add(lblPoster3, BorderLayout.CENTER);
        panelPoster3.add(lblTen3, BorderLayout.SOUTH);

        body2.add(lblPhimdc, BorderLayout.NORTH);
        body2.add(panelPoster1, BorderLayout.WEST);
        body2.add(panelPoster2, BorderLayout.CENTER);
        body2.add(panelPoster3, BorderLayout.EAST);
        
    
        // Hiển thị    
        mainFrame.add(headerPanel);
        mainFrame.add(body1);
        mainFrame.add(body2);
       
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
    public void SetImageSize(int i){
        if (lblSlide.getWidth() > 0 && lblSlide.getHeight() > 0) {
            
            ImageIcon icon = new ImageIcon(list[i]);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(lblSlide.getWidth(), lblSlide.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
            lblSlide.setIcon(newImc);
        }
    }

//    void filltoForm(){
//        String sql = "SELECT * FROM Phim WHERE maphim = ?";
//        List<Phim> dsp = dao.selectBySQL(sql, "123456");       
//        Phim p = dsp.get(0);
//         lblTen1.setText(p.getTenPhim());
//        System.out.println(""+p.getPoster());
//
//    }
    void filltoForm() {
    String sql = "SELECT * FROM Phim";
    List<Phim> dsp = dao.selectBySQL(sql);

    // Trộn danh sách để lấy 3 phần tử ngẫu nhiên
    Collections.shuffle(dsp);

    // Kiểm tra xem danh sách có ít nhất 3 phần tử không
    if (dsp.size() >= 3) {
        Phim p1 = dsp.get(0);
        lblTen1.setText(p1.getTenPhim());
        System.out.println("Phim 1 Poster: " + p1.getPoster());

        if (p1.getPoster() != null) {
            lblPoster1.setToolTipText(p1.getPoster());
            lblPoster1.setIcon(new ImageIcon(p1.getPoster()));
        }

        Phim p2 = dsp.get(1);
        lblTen2.setText(p2.getTenPhim());
        System.out.println("Phim 2 Poster: " + p2.getPoster());

        if (p2.getPoster() != null) {
            lblPoster2.setToolTipText(p2.getPoster());
            lblPoster2.setIcon(new ImageIcon(p2.getPoster()));
        }

        Phim p3 = dsp.get(2);
        lblTen3.setText(p3.getTenPhim());
        System.out.println("Phim 3 Poster: " + p3.getPoster());

        if (p3.getPoster() != null) {
            lblPoster3.setToolTipText(p3.getPoster());
            lblPoster3.setIcon(new ImageIcon(p3.getPoster()));
        }
    }
}
    
    void hienthongtinPhim(String tenPhim){
        ThongTinPhim ttp = new ThongTinPhim();
        ttp.setTenPhim(tenPhim);
        ttp.ThongTinPhim();
    }
    void Find(){
        String sql = "SELECT * FROM Phim where tenphim=?";
        List<Phim> dsp = dao.selectBySQL(sql,txtFind.getText());
        if (!dsp.isEmpty()) {
            Phim p = dsp.get(0);
            try {
                if (!txtFind.getText().equals(p.getTenPhim())) {
                    hienthongtinPhim(txtFind.getText());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phim");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy phim");
        }

    }
    public static void main(String[] args) {
        new HomeJFrame();
    }
          
}
