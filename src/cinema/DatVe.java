package cinema;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DAO.KhachHangDAO;
import DAO.VeDAO;
import com.sun.java.swing.plaf.windows.WindowsBorders;
import entity.Ve;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import utils.Auth;
import utils.JDBCHelper;
import utils.MsgBox;

/**
 *
 * @author PC_
 */
public class DatVe {
    VeDAO vedao = new VeDAO();
    KhachHangDAO khdao = new KhachHangDAO();
    int maSC;
    int slGhe = 60;
    int w = 1200, h = 1000;
    int cw = 100, ch = 100;
    int x = 10, y = 10, px = 20, py = 10;
    HashMap<Integer,Ve> dsGhe = new HashMap<Integer,Ve>();
    
    
    Color color = new Color(255, 240, 235);
    
    JFrame mainFrame;
    JPanel headerPanel,mainPanel,pnlTrai, pnlGiua, pnlPhai, footerPanel, pnlChuThich, pnlThanhTien;
    JLabel lblManHinh, lblClose, lblGhe, lblThanhTien, lblSoLuong;

    public DatVe(int maSC) {
        Auth.KH = khdao.SelectById("thehulk304@gmail.com");
        this.maSC = maSC;
        myGUI();
        this.tinhTien();
    }
    
    private void myGUI()
    {
        mainFrame = new JFrame();
        mainFrame.setSize(w, h);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setUndecorated(true);
        mainFrame.setResizable(false);
        
        
        y = 10;
        headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(x,y,w-20,100);
        
        lblManHinh = new JLabel("MÀN HÌNH", JLabel.CENTER);
        lblManHinh.setFont(new Font("Arial", 1, 50));
        lblManHinh.setBounds(200, 0, w - 420, 100);
        lblManHinh.setBorder(new BevelBorder(1, Color.RED, Color.RED));
        headerPanel.add(lblManHinh);
        
        lblClose = new JLabel("X",JLabel.CENTER);
        lblClose.setFont(new Font("Arial",1,50));
        lblClose.setBounds(w - 120, 25, 50, 50);
        lblClose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            
            public void mouseEntered(MouseEvent e) {
                lblClose.setForeground(color);
            }

            public void mouseExited(MouseEvent e) {
                lblClose.setForeground(Color.BLACK);
            }
        });
        lblClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerPanel.add(lblClose);
        
        y+=140;
        
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(x, y, w-20, ch*6+50);
        
        pnlTrai = new JPanel();
        pnlTrai.setBounds(px, py, cw*2, ch* 6);
        pnlTrai.setLayout(new GridLayout(6, 2, 5, 5));
        
        
        px += cw*2 + 60;
        
        pnlGiua = new JPanel();
        pnlGiua.setBounds(px, py, cw*6, ch*6);
        pnlGiua.setLayout(new GridLayout(6, 6, 5, 5));
        
        px += cw*6 + 60;
        
        pnlPhai = new JPanel();
        pnlPhai.setBounds(px, py, cw*2, ch* 6);
        pnlPhai.setLayout(new GridLayout(6, 2, 5, 5));
        
        loadGhe(this.maSC);
        
        y += ch*6 + 60;
        
        mainPanel.add(pnlTrai);
        mainPanel.add(pnlGiua);
        mainPanel.add(pnlPhai);
        
        footerPanel = new JPanel();
        footerPanel.setBorder(new WindowsBorders.DashedBorder(Color.BLACK));
        footerPanel.setLayout(null);
        footerPanel.setBounds(x, y, w - 20, h - y - 10);
        
        pnlChuThich = new JPanel();
        pnlChuThich.setLayout(new GridLayout(3, 1));
        pnlChuThich.setBounds(10, 5, 210, h - y - 20);
        
        String[] chuThich = {"Đã Được Đặt","Đang Chọn","Chưa Chọn"};
        for (int i = 0; i < chuThich.length; i++) {
            JPanel panel = new JPanel();
            panel.setSize(210, (h-y-20)/3);
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(50,50));
            label.setBorder(new LineBorder(Color.PINK));
            if (i == 0)
                label.setIcon(new ImageIcon(getClass().getResource("/img/ordered-48.png")));
            else if (i == 1)
            {
                label.setOpaque(true);
                label.setBackground(color);
            }
            panel.add(label);
            JLabel label1 = new JLabel(chuThich[i], JLabel.LEFT);
            label1.setFont(new Font("Arial",1,18));
            label1.setPreferredSize(new Dimension(150,50));
            panel.add(label1);
            pnlChuThich.add(panel);
        }

        footerPanel.add(pnlChuThich);
        
        pnlThanhTien = new JPanel(new GridLayout(3, 1));
        pnlThanhTien.setBounds(550, 5, 500, h - y - 20);
        
        lblSoLuong = new JLabel();
        lblSoLuong.setFont(new Font("Arial",1,18));
        pnlThanhTien.add(lblSoLuong);
        
        lblGhe = new JLabel();
        lblGhe.setFont(new Font("Arial",1,18));
        pnlThanhTien.add(lblGhe);
        
        lblThanhTien = new JLabel();
        lblThanhTien.setFont(new Font("Arial",1,18));
        pnlThanhTien.add(lblThanhTien);
        
        footerPanel.add(pnlThanhTien);
        
        
        mainFrame.add(headerPanel);
        mainFrame.add(mainPanel);
        mainFrame.add(footerPanel);
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new DatVe(15);
    }

    private void loadGhe(Object ...args) {
        String sql = "select * from ve where masuatchieu = ? order by maghe";
        List<Ve> list = new ArrayList<Ve>();
        try {
            ResultSet rs = JDBCHelper.Query(sql, args);
            while (rs.next()) {
                Ve ve = new Ve();
                ve.setMaGhe(rs.getString("maghe"));
                ve.setMaSuatChieu(rs.getInt("masuatchieu"));
                ve.setMaVe(rs.getInt("mave"));
                ve.setEmailKH(rs.getString("khachhang"));
                ve.setEmailNV(rs.getString("nhanvien"));
                ve.setThanhTien(rs.getDouble("thanhtien"));
                ve.setThanhToan(rs.getBoolean("thanhtoan"));
                ve.setTinhTrang(Auth.KH.getEmailKH());
                list.add(ve);
            }
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char hang = 'A';
        int cot = 1;
        int vitriGhe = 0;
        
        for (int i = 0; i < this.slGhe; i++) 
        {
            if (cot > 10)
            {
                int a = (int)hang;
                a++;
                hang = (char)(a);
                cot = 1;
            }
            String maGhe = String.valueOf(hang) + String.valueOf(cot);

            Ve ve = new Ve();
            ve.setVitri(i);
            ve.setMaGhe(maGhe);
            if (vitriGhe == list.size())
                vitriGhe--;
            if (vitriGhe >= 0)
            {
                if (ve.getMaGhe().equals(list.get(vitriGhe).getMaGhe()))
                {
                    ve = list.get(vitriGhe);
                    vitriGhe++;
                }
                else 
                {
                    double thanhTien;
                    if (i < 20)
                        thanhTien = 60000;
                    else
                        thanhTien = 65000;
                    ve.setThanhTien(thanhTien);
                    ve.setThanhToan(false);
                }
            }
            this.dsGhe.put(i,ve);
            cot++;
        }
        fillToSeat();
    }
    
    private void fillToSeat()
    {
        pnlTrai.removeAll();
        pnlGiua.removeAll();
        pnlPhai.removeAll();
        for (int i = 0; i < this.slGhe; i++) 
        {
            Ve ve = this.dsGhe.get(i);
            JLabel l = new JLabel(ve.getMaGhe(), JLabel.CENTER);
            if (ve.isThanhToan() || ve.getTinhTrang() == 2)
            {
                l.setText("");
                l.setIcon(new ImageIcon(getClass().getResource("/img/ordered.png")));
            }
            else if (ve.getTinhTrang() == 1)
            {
                l.setOpaque(true);
                l.setBackground(this.color);
            }
            
            l.setBorder(new LineBorder(Color.pink));
            l.setCursor(new Cursor(Cursor.HAND_CURSOR));
            l.setName(String.valueOf(i));
            l.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(!l.getText().equals("")){
                        Ve ve = dsGhe.get(Integer.parseInt(l.getName()));
                        ve.setMaVe(16);
                        ve.setMaSuatChieu(maSC);
                        ve.setEmailKH(Auth.KH.getEmailKH());
                        ve.setThanhToan(false);
                        datVe(ve);
                    }
                    else
                        MsgBox.alert(null, "Vé đã được đặt");
                }
            });
            int cot = Integer.parseInt(ve.getMaGhe().substring(1));
            
            if (cot <= 2)
                pnlTrai.add(l);
            else if (cot <= 8)
                pnlGiua.add(l);
            else
                pnlPhai.add(l);
        }
    }
    private void datVe(Ve v)
    { 
        Ve ve = vedao.SelectByMaGhe(v.getMaGhe(), maSC);
        System.out.println(v.getThanhTien());
        if (ve != null)
            vedao.deleteGhe(v.getMaGhe(),maSC);
        else
            vedao.Insert(v);
        loadGhe(this.maSC);
        tinhTien();
        mainFrame.setSize(w-1,h);
        mainFrame.setSize(w,h);
        
    }
    
    private void tinhTien()
    {
        int slDat = 0;
        String ghe = "Ghế: ";
        double thanhTien = 0;
        for (int i = 0; i < dsGhe.size(); i++) {
            Ve ve = dsGhe.get(i);
            if (ve.getTinhTrang() == 1)
            {
                slDat ++;
                if (slDat > 1)
                    ghe += ", ";
                ghe += ve.getMaGhe();
                thanhTien += ve.getThanhTien();
            }
            lblSoLuong.setText("Số lượng: " + String.valueOf(slDat));
            lblGhe.setText(ghe);
            lblThanhTien.setText("Tổng tiền: " + String.valueOf(thanhTien));
        }
    }
}
