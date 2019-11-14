/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Ilyes
 */
public class UpdateThread implements Runnable{
    private int num;
    private int col;
    public Case[][] cases;

    public UpdateThread(int num, int col, Case[][] cases) {
        this.num = num;
        this.col = col;
        this.cases = cases;
    }
    
    @Override
    public void run() {
        System.out.println("thread de mise à jour "+num+ " lancé ");
        for(int i=0;i<cases.length;i++){
            for(int j=0;j<col;j++) {
               Case c=cases[i][j];
               int cont=cases[i][j].nb_voisins;
               
               if (c.alive){           
               if (cont<2) {c.decocher();};
               if(cont>3) {c.decocher();}
               }
                else {if(cont==3) c.cocher();} ;
                synchronized (GameOfLife.lock){
                    cases[i][j].nb_voisins=0;}
                }
            }
    }
    
}
