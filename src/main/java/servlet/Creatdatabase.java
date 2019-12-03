/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import model.DAO;
import model.DAOException;
import model.DataSourceFactory;
import org.apache.derby.tools.ij;

/**
 *
 * @author pedago
 */
@WebListener()
public class Creatdatabase implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            if (!databaseExists()) {
                try {
                    initializeDatabase();
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Creatdatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            } //To change body of generated methods, choose Tools | Templates.
        } catch (DAOException ex) {
            Logger.getLogger(Creatdatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private boolean databaseExists() throws DAOException {
        boolean result = false;

		DAO dao = new DAO(DataSourceFactory.getDataSource());
                 int code = dao.numberOfCustomers();
                Logger.getLogger("Amazonia_database").log(Level.INFO, "Database already exists");
                result = true;
		return result; //To change body of generated methods, choose Tools | Templates.
    }

    private void initializeDatabase() throws UnsupportedEncodingException {
        OutputStream nowhere = new OutputStream() {
			@Override
			public void write(int b) {
			}
		};
		
		Logger.getLogger("Amazonia_database").log(Level.INFO, "Creating databse from SQL script");
		try {
			Connection connection = DataSourceFactory.getDataSource().getConnection();
			int result = ij.runScript(connection, this.getClass().getResourceAsStream("database_originale.sql"), "UTF-8", System.out, "UTF-8");
			if (result == 0) {
				Logger.getLogger("Amazonia_database").log(Level.INFO, "Database succesfully created");
			} else {
				Logger.getLogger("Amazonia_database").log(Level.SEVERE, "Errors creating database");
			}
		} catch (SQLException e) {
			Logger.getLogger("Amazonia_database").log(Level.SEVERE, null, e);
		}

	} //To change body of generated methods, choose Tools | Templates.
    }
    

