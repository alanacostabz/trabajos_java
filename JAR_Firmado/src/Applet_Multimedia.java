
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bryan
 */
public class Applet_Multimedia extends JApplet {
    
    public void init(){
        System.out.println("entra");
        
        logo=getImage(getDocumentBase(),"rd2.png");
        
    }
    
    public void paint(Graphics g){
        g.drawImage(logo,50, 50, this);
    }
    
    Image logo;
}
