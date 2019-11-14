/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilyes
 */
public class Action implements ActionListener {
    Grille g;
    static int nb_threads=8;
    static boolean[] change=new boolean[nb_threads];
    
    
    public Action(Grille g) {
    this.g=g;
     for(int i=0;i<nb_threads;i++){
        change[i]=false;
     }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Case[][] cases=g.getCases();
     Thread[] threads=new Thread[nb_threads];
    Case[][] T;
    int x=cases.length/(nb_threads-1);
    for(int i=0;i<nb_threads;i++){
        if (i<(nb_threads-1)){
        T=Arrays.copyOfRange(cases,i*x,(i+1)*x+1);}
        else {T=Arrays.copyOfRange(cases,i*x,cases.length);}
        Runnable r=new GameThread(i,T,cases.length);
        threads[i]=new Thread(r);
        threads[i].start();
    }
     for(int i=0;i<nb_threads;i++){
            try {
                threads[i].join();
            } catch (InterruptedException ex) {}
     }
     for(int i=0;i<nb_threads;i++){
        if (i<(nb_threads-1)){
        T=Arrays.copyOfRange(cases,i*x,(i+1)*x);}
        else {T=Arrays.copyOfRange(cases,i*x,cases.length);}
        Runnable r=new UpdateThread(i,cases.length,T);
        threads[i]=new Thread(r);
        threads[i].start();
    }
     for(int i=0;i<nb_threads;i++){
            try {
                threads[i].join();
            } catch (InterruptedException ex) {}
     }
    
    
           
    }
    
}
