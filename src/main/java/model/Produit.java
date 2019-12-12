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

public class Produit {
    private int produit_id;
    private String name;
    private int fournisseur;
    private String quantite;
    private boolean indisponible;
    private float prix_unitaire;
    private int prix_uniteco;
    private int niveau;
    private String label;
  
    public Produit(int prodId, String name, int fourni,int dispo,int nx,float pxuni,int pxinuec,String quant,String l){
        this.fournisseur=fourni;
        this.indisponible=dispo==0;
        this.name=name;
        this.niveau=nx;
        this.prix_unitaire=pxuni;
        this.prix_uniteco=pxinuec;
        this.produit_id=prodId;
        this.quantite=quant;
        this.label=l;
        
    }
    
     
    public int affId(){
        return this.produit_id;
    }
    
     public int affFour(){
        return this.fournisseur;
    }
     
     public boolean affDispo(){
        return this.indisponible;
    }
     public int affNx(){
        return this.niveau;
    }
     
     public String affnom(){
        return this.name;
    }
      public int affPxu(){
        return this.prix_uniteco;
    }
     public String affQt(){
        return this.quantite;
    }
     public String afflib(){
        return this.label;
    }
    public float Pxuni(){
        return this.prix_unitaire;
    }
     
         
    
}
