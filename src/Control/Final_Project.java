/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import View.Admin_Menu;
import View.Login_Button;
import View.Splash_Screen;
import View.Login_Password;
/**
 *
 * @author Pkkg
 */
public class Final_Project {
     public static void main(String[] args) {
  
        
        // Splash Screen 
        Splash_Screen splash = new Splash_Screen();
        splash.setVisible(true);
        
        Login_Button log = new Login_Button();
        try {
            for(int i = 0; i<=100;i++)
            {
                Thread.sleep(20);
                splash.lbl_percent.setText(Integer.toString(i)+"%");
                splash.prog.setValue(i);
            }
        } catch (Exception e) {
        }
        new Splash_Screen().setVisible(false);
log.setVisible(true);
        splash.dispose();
        
        //Splash End
        
        
    }
    
}
