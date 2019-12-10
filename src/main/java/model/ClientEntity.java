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
public class ClientEntity {
    public String name;
    public String code;
    public String societe;
    public String Fonction;
    public String Adresse;
    public String ville;
    public String region;
    public String cp ;
    public String pays;
    public String  tel;
    public String fax;
    
    public ClientEntity(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k){
        this.name=a;
        this.code=b;
        this.societe=c;
        this.Fonction=d;
        this.Adresse=e;
        this.ville=f;
        this.region=g;
        this.cp=h;
        this.pays=i;
        this.tel=j;
        this.fax=k;
    }
    
    public String getnom(){
        return this.name;
    }
    
    public String getcode(){
        return this.code;
    }
    
    public String getsociete(){
        return this.societe;
    }
    
    public String getfonction(){
        return this.Fonction;
    }
    
    public String getadresse(){
        return this.Adresse;
    }
    
    public String getville(){
        return this.ville;
    }
    
    public String getregion(){
        return this.region;
    }
    public String getcp(){
        return this.cp;
    }
    
    public String getpays(){
        return this.pays;
    }
    
    public String gettel(){
        return this.tel;
    }
    public String getfax(){
        return this.fax;
    }
    
    
    
   
            
 }
