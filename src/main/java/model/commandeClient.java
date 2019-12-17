/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Benjamin
 */
public class commandeClient {
    public String numero;
    public String client;
    public String saisie;
    public String envoyeLe;
    public String port;
    public String destinataire;
    public String adresseLivr;
    public String villeLivr ;
    public String regionLivr;
    public String cpLivr;
    public String paysLivr;
    public String remise; 
    
    public String commande;
    public String produit;
    public String quantite;
    public String reference;
    public String nom;
    public String fournisseur;
    public String categorie;
    public String quantiteUni ;
    public String prixUni;
    public String uniteStock;
    public String uniteCom;
    public String niveauReap;
    public String indisponible;
    
    public commandeClient(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k, String l,String m, String n, String o, String p, String q, String r, String s, String t, String u, String v, String w, String x, String y){
        this.numero=a;
        this.client=b;
        this.saisie=c;
        this.envoyeLe=d;
        this.port=e;
        this.destinataire=f;
        this.adresseLivr=g;
        this.villeLivr=h;
        this.regionLivr=i;
        this.cpLivr=j;
        this.paysLivr=k;
        this.remise=l;
        
        this.commande=m;
        this.produit=n;
        this.quantite=o;
        this.reference=p;
        this.nom=q;
        this.fournisseur=r;
        this.categorie=s;
        this.quantiteUni=t;
        this.prixUni=u;
        this.uniteStock=v;
        this.uniteCom=w;
        this.niveauReap=x;
        this.indisponible=y;
                
                
                
                
                
    }
    
    public String getnumero(){
        return this.numero;
    }
    
    public String getclient(){
        return this.client;
    }
    
    public String getsaisie(){
        return this.saisie;
    }
    
    public String getenvoyeLe(){
        return this.envoyeLe;
    }
    
    public String getport(){
        return this.port;
    }
    
    public String getdestinataire(){
        return this.destinataire;
    }
    
    public String getadresse(){
        return this.adresseLivr;
    }
    public String getville(){
        return this.villeLivr;
    }
    
    public String getregion(){
        return this.regionLivr;
    }
    
    public String getcp(){
        return this.cpLivr;
    }
    public String getpays(){
        return this.paysLivr;
    }
    public String getremise(){
        return this.remise;
    }
    
    
    
   
            
 }