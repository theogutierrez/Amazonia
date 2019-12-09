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
    private int indisponible;
    private float prix_unitaire;
    private int prix_uniteco;
    private int niveau;
    
    public Produit(int prodId, String name, int fourni,int dispo,int nx,float pxuni,int pxinuec,String quant){
        this.fournisseur=fourni;
        this.indisponible=dispo;
        this.name=name;
        this.niveau=nx;
        this.prix_unitaire=pxuni;
        this.prix_uniteco=pxinuec;
        this.produit_id=prodId;
        this.quantite=quant;
    }
    
}
