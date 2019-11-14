/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ilyes
 */
public class Grille extends JPanel {
    private Case[][] cases;
    static int size ;
    private JButton update;
    

    public Grille() {
        super();
        cases=new Case[size][size];
        JPanel p= new JPanel();
        this.setLayout(new BorderLayout());
        p.setLayout(new GridLayout(size,size));
        Case.x1=0;
        Case.y1=1;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                this.cases[i][j]=new Case();
                this.cases[i][j].addActionListener(new ActionListener(){
                @Override
                    public void actionPerformed(ActionEvent e) {
                        Case c=(Case) e.getSource();
                        if (!c.alive)c.cocher();
                        else c.decocher();}
            
                });
                p.add(this.cases[i][j]);
         }};
        this.add(p,BorderLayout.NORTH);
        p.setPreferredSize(new Dimension(size*20,size*20));
        update=new JButton("valider");
        
        this.add(update,BorderLayout.CENTER);
        update.addActionListener(new Action(this));
                }
    
    
//    public void update(){
//        int[] voisins= new int[size*size];
//        for(int i=0;i<cases.length;i++){
//            voisins[i]=this.voisins(cases[i]);
//        }
//        for(int i=0;i<cases.length;i++){
//            Case c=cases[i];
//            int cont=voisins[i];
//            if (c.alive){           
//                if (cont<2) {c.decocher();};
//                if(cont>3) {c.decocher();}
//               }
//            else {{if(cont==3) c.cocher();}}
//            }
    

    public Case[][] getCases() {
        return cases;
    }
    
    }
    

    
    
