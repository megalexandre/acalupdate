package br.org.acal.application.telas;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;


//Para que a imagem apareça na tela, é preciso estender a classe JWindow.
public class Splash extends JWindow{
         
     //AbsoluteConstraints absBarra, absImage;
     //AbsoluteLayout absl;
     ImageIcon image;
     JLabel label, texto;
     JProgressBar progress;
     
    public Splash(){
        
        //absBarra = new AbsoluteConstraints(0,480);
        //absImage = new AbsoluteConstraints(0,0);
        
        //absl = new AbsoluteLayout();
        label = new JLabel();
        image = new ImageIcon(getClass().getResource("/img/acal.png"));
        label.setIcon(image);
        progress = new JProgressBar();
        progress.setPreferredSize(new Dimension(640,20));
        progress.setBackground(Color.WHITE);
        progress.setString("Carregando");
        progress.setStringPainted(true);
        progress.setForeground(Color.ORANGE);
        //setLayout(absl);
       // getContentPane().add(label,absImage);
//getContentPane().add(progress,absBarra);
     
        new Thread(){
       
            @Override
            public void run(){
                
                int i = 0;
                while(i < 101){
                    
                    progress.setValue(i);
                    i++;
                   
                    try {   
                            
                       sleep(20);
                    } catch (InterruptedException ex) {
                  
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("erro aqui");
                        System.exit(1);
                    }
                }
                new TelaLogin().setVisible(true);
                //new TelaPrincipal().setVisible(true);
                dispose();
               
            }
           }.start();
     
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/4 ,   
        Toolkit.getDefaultToolkit().getScreenSize().height/5 );  
        pack();
        setVisible(true);
        
        
        
    }
    
    private  void testarConexao1(){
        
            new Thread(){
            @Override
            public void run(){
            Session session= null;
            try{
            
            progress.setString("Testando Conexão com o Banco de Dados");

        }catch(HibernateException e){
            
            JOptionPane.showMessageDialog(null, "Erro de conexão ao banco de dados: "+e.getMessage());
            System.exit(1);
        }
            progress.setString("Conexão bem sucedida...");
            }
        }.start();    
    }
    
    public static void main(String[] args) {

        /*
        try {
            Properties p = new Properties();
            p.put("logoString", "ACAL2000");
            //com.jtattoo.plaf.luna.LunaLookAndFeel.setTheme(p);
            //javax.swing.UIManager.setLookAndFeel(new com.jtattoo.plaf.luna.LunaLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }  */

        Splash splash = new Splash();
        splash.testarConexao1();   
    }
}
