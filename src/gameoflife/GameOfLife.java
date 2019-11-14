/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Ilyes
 */
public class GameOfLife {
    /**
     * @param args the command line arguments
     */
    static  Object lock= new Object();
    public static void main(String[] args) {
       int fps=10;
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int N=(screenSize.height)/20;
       
     
       JFrame fr=new JFrame();
       Grille.size=N-7;
       fr.setPreferredSize(new Dimension(screenSize.height-50,screenSize.height-50));
       Grille g=new Grille();
       g.setPreferredSize(new Dimension(N*20,N*20));
        System.out.println(g.getCases().length);
       fr.setContentPane(g);
       fr.pack();
       fr.setVisible(true);
       fr.setResizable(false);
       fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
