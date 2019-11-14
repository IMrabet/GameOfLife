/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;


import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Ilyes
 */
public class Case extends JButton {
    static int x1=-1,y1=1;
    private int x,y;
    public boolean alive;
    public int nb_voisins=0;
    
    
    public Case() {
        super();
        this.alive = false;
        if (x1<Grille.size){
            x1+=1;
        }
        else{
            y1=y1+1;
            x1=1;
        }
        x=x1;
        y=y1;
        
    }
    public void cocher(){
            this.alive=true;
            this.setBackground(Color.blue);
    }
   public void decocher(){
            this.alive=false;
            this.setBackground(null);
    }


    public int xcase() {
        return x;
    }

    public int ycase() {
        return y;
    }
   
    
        
       
}
    
