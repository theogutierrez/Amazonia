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
import java.util.Map;
import java.util.HashMap;
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
                                        String libe=rs.getString("LIBELLE");
					Produit c = new Produit(id,name,fourn,disp,nx,pxuni,unite_co,quant,libe);
					result.add(c);
				}
			}
                        catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
		}

		return result ;
	}
    public List<Produit> produit() throws SQLException {
		List<Produit> result = new LinkedList<>();

		String sql = "Select * from CATEGORIE INNER Join PRODUIT on CATEGORIE.code = PRODUIT.CATEGORIE ";
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
                                        String libe=rs.getString("LIBELLE");
					Produit c = new Produit(id,name,fourn,disp,nx,pxuni,unite_co,quant,libe);
					result.add(c);
				}
			}
                        catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
		}

		return result ;
	}
    
    public List<Produit> affProduit(String name) throws SQLException{
        List<Produit> resultat = new LinkedList<>();
        String sql = "Select * from CATEGORIE INNER Join PRODUIT on CATEGORIE.code = PRODUIT.CATEGORIE where PRODUIT.NOM = ?";
		try (Connection connection = myDataSource.getConnection();
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int id = rs.getInt("REFERENCE");
					String nom = rs.getString("NOM");
					int fourn = rs.getInt("FOURNISSEUR");
                                        int disp=rs.getInt("INDISPONIBLE");
                                        int nx=rs.getInt("NIVEAU_DE_REAPPRO");
                                        float pxuni=rs.getFloat("PRIX_UNITAIRE");
                                        int unite_co=rs.getInt("UNITES_COMMANDEES");
                                        String quant=rs.getString("QUANTITE_PAR_UNITE");
                                        String libe=rs.getString("LIBELLE");
					 resultat.add(new  Produit(id,name,fourn,disp,nx,pxuni,unite_co,quant,libe));
					
				}
                                
			}
                        catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
                        
		}   
                return resultat;
    }
    public List<LignePanier> affPanier(String client) throws SQLException{
        List<LignePanier> resultat = new LinkedList<>();
        String sql = "Select * from Panier where Client = ?";
		try (Connection connection = myDataSource.getConnection();
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, client);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int id = rs.getInt("Numero");
					String produit = rs.getString("Produit");
                                        String iencli = rs.getString("Client");
                                        float pxuni=rs.getFloat("Prix");
                                        int quant=rs.getInt("Quantite");
                                        String libe=rs.getString("Libelle");
					 resultat.add(new  LignePanier(produit,iencli,libe,quant,pxuni));
					
				}
                                
			}
                        catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
                        
		}   
                return resultat;
    }
    public int addProduct( String name, int fourni,int dispo,int nx,float pxuni,int pxinuec,String quant,int cate,int unitstock) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO PRODUIT (Nom,Fournisseur,Categorie,Quantite_par_unite,Prix_unitaire,Unites_en_stock,Unites_commandees,Niveau_de_reappro,Indisponible) VALUES (?,?,?,?,?,?,?,?,?)";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, name);
                        stmt.setInt(2, fourni);
                        stmt.setInt(3, cate);
                        stmt.setString(4, quant);
                        stmt.setFloat(5, pxuni);
                        stmt.setInt(6, unitstock);
                        stmt.setInt(7, pxinuec);
                        stmt.setInt(8, nx);
                        stmt.setInt(9, dispo);
			result = stmt.executeUpdate();
		}
                
                catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                }
                
		return result;
	}
    
    public int delProduct( String name) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM PRODUIT WHERE NOM = ?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                    
			stmt.setString(1, name);
                        
			result = stmt.executeUpdate();
		}
                catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
		return result;
	}
    
    
    
     public int AddPanier( String prodname,String clientname,String libel,int quant,float prix) throws SQLException {
		int result=0;
		String sql = "INSERT INTO PANIER (Client,Produit,Quantite,Libelle,Prix) VALUES (?,?,?,?,?) ";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                    
			stmt.setString(1, clientname);
                        stmt.setString(2, prodname);
                        stmt.setString(4, libel);
                        stmt.setInt(3, quant);
                        stmt.setFloat(5,prix);
                        
			result = stmt.executeUpdate();
		}
                catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
                
		return result;
	}
     
     public int delPanier( String name) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM PANIER WHERE PRODUIT = ?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                    
			stmt.setString(1, name);
                        
			result = stmt.executeUpdate();
		}
                catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new SQLException(ex.getMessage());
                        }
		return result;
	}
    
    public void updateProduct(String colonne,String code ,String modif) throws DAOException{
        String sql = "UPDATE PRODUIT SET "+ colonne+ "=? WHERE NOM=?";
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
				} else { // else on n'a pas trouvé, on renverra null
                                    result = "";
                                }
			}
		}  catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
		}

		return result.equals(mdp);
	}
    
    public void updateCustomer(String colonne ,String  modif,String  contact) throws DAOException {

		// Une requête SQL paramétrée

                String sql = "UPDATE CLIENT SET "+ colonne+ "=? WHERE CONTACT=?";
		try (   Connection connection = myDataSource.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
                        // Définir la valeur du paramètre
                       

                      
                        stmt.setString(1, modif);
                        
                        stmt.setString(2, contact);
                    
			
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
		ArrayList<Integer> result = new ArrayList<>();

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
    
    /**
     * Méthode pour récupérer les CA par catégorie
     * @param dateDebut
     * @param dateFin
     * @return 
     * @throws java.sql.SQLException 
     */
    public Map<String, Float> priceByCategorie(String dateDebut, String dateFin) throws SQLException {
        Map<String, Float> result = new HashMap<>();
        String sql ="SELECT SUM(QUANTITE*PRIX_UNITAIRE) AS TOTAL,LIBELLE\n" +
                    "FROM PRODUIT\n" +
                    "INNER JOIN LIGNE ON LIGNE.PRODUIT = PRODUIT.REFERENCE\n" +
                    "INNER JOIN CATEGORIE ON PRODUIT.CATEGORIE = CATEGORIE.CODE\n" +
                    "INNER JOIN COMMANDE ON COMMANDE.NUMERO = LIGNE.COMMANDE\n" +
                    "WHERE COMMANDE.SAISIE_LE BETWEEN ? AND ? \n" +
                    "GROUP BY CATEGORIE.LIBELLE ORDER BY TOTAL;";
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,dateDebut);
            stmt.setString(2,dateFin);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String libelle = rs.getString("LIBELLE");
                float total = rs.getFloat("TOTAL");
                result.put(libelle, total);
            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
	}
        return result;      
    }
    
    /**
     * Méthode pour récupérer les CA par pays
     * @param dateDebut
     * @param dateFin
     * @return 
     * @throws java.sql.SQLException 
     */
    public Map<String, Float> priceByCountry(String dateDebut, String dateFin) throws SQLException {
        Map<String, Float> result = new HashMap<>();
        String sql ="SELECT SUM(QUANTITE*PRIX_UNITAIRE) AS TOTAL,PAYS_LIVRAISON\n" +
                    "FROM PRODUIT\n" +
                    "INNER JOIN LIGNE ON LIGNE.PRODUIT = PRODUIT.REFERENCE\n" +
                    "INNER JOIN COMMANDE ON COMMANDE.NUMERO = LIGNE.COMMANDE\n" +
                    "WHERE COMMANDE.SAISIE_LE BETWEEN ? AND ? \n" +
                    "GROUP BY COMMANDE.PAYS_LIVRAISON ORDER BY TOTAL;";
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,dateDebut);
            stmt.setString(2,dateFin);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String libelle = rs.getString("PAYS_LIVRAISON");
                float total = rs.getFloat("TOTAL");
                result.put(libelle, total);
            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
	}
        return result;      
    }

    /**
     * Méthode pour récupérer les CA par client
     * @param dateDebut
     * @param dateFin
     * @return 
     * @throws java.sql.SQLException 
     */
    public Map<String, Float> priceByClient(String dateDebut, String dateFin) throws SQLException {
        Map<String, Float> result = new HashMap<>();
        String sql ="SELECT SUM(QUANTITE*PRIX_UNITAIRE) AS TOTAL,CONTACT\n" +
                    "FROM PRODUIT\n" +
                    "INNER JOIN LIGNE ON LIGNE.PRODUIT = PRODUIT.REFERENCE\n" +
                    "INNER JOIN COMMANDE ON COMMANDE.NUMERO = LIGNE.COMMANDE\n" +
                    "INNER JOIN CLIENT ON COMMANDE.CLIENT = CLIENT.CODE\n" +
                    "WHERE COMMANDE.SAISIE_LE BETWEEN ? AND ? \n" +
                    "GROUP BY CLIENT.CONTACT ORDER BY TOTAL;";
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,dateDebut);
            stmt.setString(2,dateFin);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String libelle = rs.getString("CONTACT");
                float total = rs.getFloat("TOTAL");
                result.put(libelle, total);
            }
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
	}
        return result;      
    }
}
