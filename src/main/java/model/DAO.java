/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO {
    private final DataSource myDataSource;

    /**
     *
     * @param dataSource la source de données à utiliser
     */
    public DAO(DataSource dataSource) {
            this.myDataSource = dataSource;
    }
    
    public int numberOfCategorie() throws DAOException {
		int result = 0;

		String sql = "SELECT count(*) as nombre  FROM Categorie ";
		// Syntaxe "try with resources" 
		// cf. https://stackoverflow.com/questions/22671697/try-try-with-resources-and-connection-statement-and-resultset-closing
		try (   Connection connection = myDataSource.getConnection(); // Ouvrir une connexion
			Statement stmt = connection.createStatement(); // On crée un statement pour exécuter une requête
			ResultSet rs = stmt.executeQuery(sql) // Un ResultSet pour parcourir les enregistrements du résultat
		) {
			if (rs.next()) { // Pas la peine de faire while, il y a 1 seul enregistrement
				// On récupère le champ NUMBER de l'enregistrement courant
				result = rs.getInt("nombre");
                               
			}
		} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result;
	}
    
    public List<Produit> produitparcategorie(String libelle) throws SQLException {
		List<Produit> result = new LinkedList<>();

		String sql = "Select * from CATEGORIE INNER Join PRODUIT on CATEGORIE.code = PRODUIT.CATEGORIE where CATEGORIE.LIBELLE=?";
		try (Connection connection = myDataSource.getConnection();
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, libelle);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("REFERENCE");
					String name = rs.getString("Nom");
					int fourn = rs.getInt("FOURNISSEUR");
                                        int disp=rs.getInt("INDISPONIBLE");
                                        int nx=rs.getInt("NIVEAU_DE_REAPPRO");
                                        float pxuni=rs.getFloat("PRIX_UNITAIRE");
                                        int unite_co=rs.getInt("UNITES_COMMANDEES");
                                        String quant=rs.getString("QUANTITE_PAR_UNITE");
					Produit c = new Produit(id,name,fourn,disp,nx,pxuni,unite_co,quant);
					result.add(c);
				}
			}
		}

		return result ;
	}
    public List<Produit> produit() throws SQLException {
		List<Produit> result = new LinkedList<>();

		String sql = "Select * from  PRODUIT ";
		try (Connection connection = myDataSource.getConnection();
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("REFERENCE");
					String name = rs.getString("Nom");
					int fourn = rs.getInt("FOURNISSEUR");
                                        int disp=rs.getInt("INDISPONIBLE");
                                        int nx=rs.getInt("NIVEAU_DE_REAPPRO");
                                        float pxuni=rs.getFloat("PRIX_UNITAIRE");
                                        int unite_co=rs.getInt("UNITES_COMMANDEES");
                                        String quant=rs.getString("QUANTITE_PAR_UNITE");
					Produit c = new Produit(id,name,fourn,disp,nx,pxuni,unite_co,quant);
					result.add(c);
				}
			}
		}

		return result ;
	}
    
    public ClientEntity findClient(String contact) throws DAOException {
		ClientEntity result = null;

		String sql = "SELECT * FROM CLIENT WHERE CONTACT = ?";
		try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, contact);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
                                        String code=rs.getString("CODE");
                                        String societe=rs.getString("SOCIETE");
					String name = rs.getString("CONTACT");
                                        String Fonction=rs.getString("FONCTION");
					String Adresse= rs.getString("ADRESSE");
					String ville=rs.getString("VILLE");
                                        String region=rs.getString("REGION");
					String cp = rs.getString("CODE_POSTAL");
					String pays=rs.getString("PAYS");
                                        String  tel=rs.getString("TELEPHONE");
                                        String fax=rs.getString("FAX");
                                        
                                        
					// On crée l'objet "entity"
                                       
					result = new ClientEntity(name,code,societe,Fonction,Adresse,ville,region,cp,pays,tel,fax);
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result;
	}
    public boolean mdp(String contact,String mdp) throws DAOException {
		String result = null;

		String sql = "SELECT CODE FROM CLIENT WHERE CONTACT = ?";
		try (Connection connection = myDataSource.getConnection(); // On crée un statement pour exécuter une requête
			PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, contact);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé
					String code = rs.getString("CODE");
					
					// On crée l'objet "entity"
					result = code;
				} // else on n'a pas trouvé, on renverra null
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result.equals(mdp);
	}
    
    public void updateCustomer(String colonne ,String  modif,String  code) throws DAOException {

		// Une requête SQL paramétrée

                String sql = "UPDATE CLIENT SET "+ colonne+ "=? WHERE CODE=?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
                       

                      
                        stmt.setString(1, modif);
                        
                        stmt.setString(2, code);
                    
			
			 stmt.executeUpdate();
                     
                         stmt.close();
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}
	}
    
    public void createCommande(ClientEntity customer, int[] productIDs, int[] quantities)
		throws Exception {
                
		String insertInvoice = "INSERT INTO Commande (CLIENT,SAISIE_LE,ENVOYEE_LE,PORT,DESTINATAIRE,ADRESSE_LIVRAISON,VILLE_LIVRAISON,REGION_LIVRAISON,CODE_POSTAL_LIVRAIS,PAYS_LIVRAISON,REMISE) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		//-------------------------------------------InvoiceID, Item, ProductID, Quantity, Cost
		String insertItem = "INSERT INTO LIGNE VALUES(?  , ?   , ? )";

		try (Connection myConnection = myDataSource.getConnection();
		     PreparedStatement invoiceStatement = myConnection.prepareStatement(insertInvoice, Statement.RETURN_GENERATED_KEYS)) {
                        // On démarre la transaction
			myConnection.setAutoCommit(false);
                        
                        System.out.println("Ca commence");
                        System.out.println(customer.getcode());
                        invoiceStatement.setString(1, customer.getcode());
                        invoiceStatement.setString(2, this.aujourdhui() );
                        invoiceStatement.setString(3, this.aujourdhui() );
                        invoiceStatement.setFloat(4, (float) 0.0);
                        invoiceStatement.setString(5, customer.name);
                        invoiceStatement.setString(6, customer.Adresse);
                        invoiceStatement.setString(7, customer.ville);
                        invoiceStatement.setString(8, customer.region);
                        invoiceStatement.setString(9, customer.cp);
                        invoiceStatement.setString(10, customer.pays);
                        invoiceStatement.setFloat(11, (float)0.00);
                        
                        
                        
                        
                        
			try {
                                
                                
				invoiceStatement.executeUpdate();

				// On a bien créé la facture, cherchons son ID	
				ResultSet generatedKeys = invoiceStatement.getGeneratedKeys();
				generatedKeys.next();
				int invoiceID = generatedKeys.getInt("NUMERO");
				Logger.getLogger("DAO").log(Level.INFO, "Nouvelle clé générée pour INVOICE : {0}", invoiceID);
				
				// Créer les Item
				try (PreparedStatement itemStatement = myConnection.prepareStatement(insertItem)) {
					for (int item = 0; item < productIDs.length; item++) {
						itemStatement.clearParameters();
						itemStatement.setInt(1, invoiceID);
						itemStatement.setInt(2, productIDs[item]);
						itemStatement.setInt(3,quantities[item] );
					
						int n = itemStatement.executeUpdate();
					}
				}
				// Tout s'est bien passé, on peut valider la transaction
				myConnection.commit();
			} catch (Exception ex) { // Une erreur s'est produite
				// On logge le message d'erreur
				Logger.getLogger("DAO").log(Level.SEVERE, "Transaction en erreur", ex);
				myConnection.rollback(); // On annule la transaction
				throw(ex); // On relève l'exception pour l'appelant
			} finally {
				myConnection.setAutoCommit(true); // On revient au mode de fonctionnement sans transaction
			}
		}
                
                
	}
    
    public int numberOfCustomers() throws SQLException {
		int result = 0;

		String sql = "SELECT COUNT(*) AS NUMBER FROM COMMANDE";
		try (Connection connection = myDataSource.getConnection();
		     Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("NUMBER");
			}
		}
		return result;
	}
    
    public int numberOfInvoicesForCustomer(String customerId) throws SQLException {
		int result = 0;

		String sql = "SELECT COUNT(*) AS NUMBER FROM COMMANDE WHERE CLIENT = ?";

		try (Connection connection = myDataSource.getConnection();
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, customerId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("NUMBER");
			}
		}
		return result;
	}
    
    
    public ArrayList<Integer> findCommandeForparametre(String colonne ,String p ) throws SQLException {
		ArrayList<Integer> result = new ArrayList<Integer>();

		String sql = "SELECT * FROM COMMANDE WHERE"+colonne+"  = ?";

		try (Connection connection = myDataSource.getConnection();
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1,p);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            result.add(rs.getInt("NUMERO"));
				
			}
		}
		return result;
	}
    
    
    public String aujourdhui() {
       Long millis = System.currentTimeMillis();
       Date date = new Date(millis);
       return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    
    
}
