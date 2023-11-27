package control.listenMouseQuanLyVe;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import cinema.QuanLyVe;
import entity.Ve;

public class listenQuanLyVe implements MouseListener {
     public static listenQuanLyVe getListenQuanLyVe(){
          return new listenQuanLyVe();
     }
     @Override
     public void mouseClicked(MouseEvent e) {
          Ve.themve();
     }
     @Override
     public void mousePressed(MouseEvent e) {
          System.out.println("Giữ"); 
     }

     @Override
     public void mouseReleased(MouseEvent e) {
          System.out.println("Thả chuột");
     }

     @Override
     public void mouseEntered(MouseEvent e) {
          System.out.println("Ở trên đối tượng");
     }

     @Override
     public void mouseExited(MouseEvent e) {
          System.out.println("Thoát khỏi đối tượng");
          
     }
     
}
