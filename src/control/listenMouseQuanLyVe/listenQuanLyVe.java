package control.listenMouseQuanLyVe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


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
          System.out.println(""); 
     }

     @Override
     public void mouseReleased(MouseEvent e) {
          System.out.println("");
     }

     @Override
     public void mouseEntered(MouseEvent e) {
          System.out.println("");
     }

     @Override
     public void mouseExited(MouseEvent e) {
          System.out.println("");
          
     }
     
}
