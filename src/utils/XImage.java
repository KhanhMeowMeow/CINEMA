/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;


/**
 *
 * @author LENOVO
 */
public class XImage 
{
    public static Image getAppIcon()
    {
        URL url = XImage.class.getResource("/com/edusys/Hinh/fpt.png");
        return new ImageIcon(url).getImage().getScaledInstance(300, 450, Image.SCALE_SMOOTH);
    }
    
    public static void save(File src)
    {
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists())  
            dst.getParentFile().mkdirs();
        try 
        {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
 
                
    }
    
    public static ImageIcon read(String fileName)
    {
        File path = new File("D:\\Duan1_Pro1014\\CINEMA-20231127T032041Z-001\\CINEMA\\src\\img", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
