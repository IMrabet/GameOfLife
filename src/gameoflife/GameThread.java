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
public class GameThread implements Runnable{
    private int num;
    private int col;
    public Case[][] cases;
    


    public GameThread(int num, Case[][] cases ,int col) {
        this.num = num;
        this.cases = cases;
        this.col=col;
    }
    
    @Override
    public void run() {
        System.out.println("thread de calcul de voisins "+num+ " lancé ");
        for(int i=0;i<cases.length;i++){
            for(int j=0;j<col;j++) {
                synchronized (GameOfLife.lock){
                    if(i<cases.length-1){
                cases[i][j].nb_voisins+=this.comptevoisins(i,j);
                    }
                    else {cases[i][j].nb_voisins+=this.comptevoisins2(i,j);
               }
                }
            }
        }
        }   
        
    public int comptevoisins(int i,int j){
        int x=0;
        synchronized(GameOfLife.lock){
        try {
           if (cases[i][j+1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
        try {
           if (cases[i][j-1].alive){
               x=x+1;
           }}
         catch(Exception ex){}
        try {
           if (cases[i+1][j].alive){
               x=x+1;
           }}
         catch(Exception ex){}
        try {
           if (cases[i+1][j+1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
        try {
           if (cases[i+1][j-1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
        try {
           if (cases[i-1][j].alive){
               x=x+1;
           }}
         catch(Exception ex){}
        try {
           if (cases[i-1][j+1].alive){
               x=x+1;
           }          }
         catch(Exception ex){}
        try {
           if (cases[i-1][j-1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
    return(x);
        }
    }
    public int comptevoisins2(int i,int j){
        int x=0;
        synchronized(GameOfLife.lock){
        
        try {
           if (cases[i+1][j].alive){
               x=x+1;
           }}
         catch(Exception ex){}
        try {
           if (cases[i+1][j+1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
        try {
           if (cases[i+1][j-1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
        try {
           if (cases[i-1][j].alive){
               x=x+1;
           }}
         catch(Exception ex){}
        try {
           if (cases[i-1][j+1].alive){
               x=x+1;
           }          }
         catch(Exception ex){}
        try {
           if (cases[i-1][j-1].alive){
               x=x+1;
           } }
         catch(Exception ex){}
    return(x);
        }}
    
}
