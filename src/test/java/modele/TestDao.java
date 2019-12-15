/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author pedago
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import model.ClientEntity;
import model.DAO;
import model.DAOException;
import model.LignePanier;
import model.Produit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
public class TestDao {
     private static DataSource myDataSource; // La source de données à utiliser
    private static Connection myConnection ;	
    
    private DAO  myDAO;
    
    @Before
    public void setUp() throws SQLException, IOException, SqlToolError {
        myDataSource = getDataSource();
		myConnection = myDataSource.getConnection();
		// On initialise la base avec le contenu d'un fichier de test
		String sqlFilePath = TestDao.class.getResource("testdata.sql").getFile();
		SqlFile sqlFile = new SqlFile(new File(sqlFilePath));
		sqlFile.setConnection(myConnection);
		sqlFile.execute();
		sqlFile.closeReader();	
		// On crée l'objet à tester
		myDAO = new DAO(myDataSource);
    }
    
    @After
    public void tearDown() throws SQLException {
                myConnection.close();		
		myDAO = null;
    }
    @Test 
    public void numero() throws DAOException {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
                
		assertEquals(8, myDAO.numberOfCategorie());
	}
    
    @Test 
    public void produitcategori() throws DAOException, SQLException {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
                List<Produit> liste =myDAO.produitparcategorie("Viandes");
	
               assertEquals(6, liste.size());
	}
    
    @Test 
    public void findclient() throws DAOException, SQLException {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
                ClientEntity  client =myDAO.findClient("Maria Anders");
		assertEquals("Maria Anders", client.name);
	}
    
     @Test 
    public void bonmdp() throws DAOException, SQLException {              
		assertTrue(myDAO.mdp("Maria Anders", "ALFKI"));
	}
    
     @Test 
    public void mauvaisMdp() throws DAOException, SQLException {              
		assertFalse(myDAO.mdp("Maria An", "ALFKI"));
	}
    
    @Test 
    public void modification() throws DAOException, SQLException {
                ClientEntity  client =myDAO.findClient("Maria Anders");
                String adress=client.Adresse;
                myDAO.updateCustomer("ADRESSE", "Obere Str. 56", "Maria Anders");
                String adress2=myDAO.findClient("Maria Anders").Adresse;
      
		assertFalse(adress.equals(adress2));
                
	}
    
    @Test 
    public void TestmAffPANIER() throws DAOException, SQLException {
                myDAO.AddPanier("Chai","ALFKI"  ,"Boissons", 1, (float) 90.00);
                List<LignePanier> panier = new LinkedList<>();
                       panier= myDAO.affPanier("ALFKI");
                int taille=panier.size();
               
               
      
		assertTrue(taille==1);
                
	}
    @Test 
    public void TestAddProduit() throws DAOException, SQLException {
                String name="Coca-Cola";
                int fourni=1;
                int dispo=0;
                int nx=0;
                float pxuni=(float) 30.00;    
                int pxinuec=20;
                String quant="20 BOITES X 10 BOUTEILLE";
                int cate=1;
                int unitstock=200;
                int taille=myDAO.produit().size();
                myDAO.addProduct(name, fourni, dispo, nx, pxuni, pxinuec, quant, cate, unitstock);
                
                assertTrue(myDAO.produit().size()==taille+1);
	
	}
    
    @Test 
    public void TestDelProduit() throws DAOException, SQLException {
                
                int taille=myDAO.produit().size();
                myDAO.delProduct("Chai");
                
                assertTrue(myDAO.produit().size()==taille-1);
	
	}
    
     @Test 
    public void TestAddPanier() throws DAOException, SQLException {
                
                int taille=myDAO.produit().size();
                myDAO.delProduct("Chai");
                
                assertTrue(myDAO.produit().size()==taille-1);
	
	}
    
    
    @Test
	public void canCreateCommande() throws Exception {
		// On calcule combien le client a de factures
		String code = "Maria Anders" ;
                ClientEntity test=myDAO.findClient(code);
		int before = myDAO.numberOfInvoicesForCustomer( test.getcode());
                System.out.println(before);
		// Un tableau de 3 productID
		int[] productIds = new int[]{3,1,2};
		// Un tableau de 3 quantites
		int[] quantities = new int[]{10, 20, 30};
		// On exécute la transaction
                
                
		myDAO.createCommande(test, productIds, quantities);
		int after = myDAO.numberOfInvoicesForCustomer( test.code);
		// Le client a maintenant une facture de plus
		assertEquals(before + 1, after);		
	}
        
        
        
    
 
    public static DataSource getDataSource() throws SQLException {
		org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
		ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
		ds.setUser("sa");
		ds.setPassword("sa");
		return ds;
    }
   
    
}
