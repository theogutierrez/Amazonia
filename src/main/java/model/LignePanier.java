/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author reguig
 */
public class LignePanier {
    private String name;
    private String client;
    private String libel;
    private int quant;
    private float prix;
    
    public LignePanier(String n,String c,String l,int q,float p){
        this.name=n;
        this.client=c;
        this.libel=l;
        this.prix=p;
        this.quant=q;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getClient(){
        return this.client;
    }
    
    public String getLibel(){
        return this.libel;
    }
    
    public int getQuant(){
        return this.quant;
    }
    
    public float getPrix(){
        return this.prix;
    }
}
