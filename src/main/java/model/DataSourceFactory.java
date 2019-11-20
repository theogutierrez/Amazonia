/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DataSourceFactory {
    	public enum DriverType {
		embedded, server
	};
	
	// Choic du type de driver : embedded ou serveur
	private static final DriverType TYPE = DriverType.server;
	/**
	 * Renvoie la source de données (server ou embbeded)
	 * @return  la source de données
	 */
	public static DataSource getDataSource() {
		DataSource result;

		switch (TYPE) {
			case server: // Derby mode serveur, doit être démarré indépendamment
				org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
				ds.setDatabaseName("dtjcln2av96s6");
				ds.setUser("cjbpbwuflbwnxe");
				ds.setPassword("623cce31421e5de479a4699eb2c9dac54e3d0bbbac9c3a241ed049d081d36ee7");
				// The host on which Network Server is running
				ds.setServerName("ec2-54-246-98-119.eu-west-1.compute.amazonaws.com");
				// port on which Network Server is listening
				ds.setPortNumber(5432);
				result = ds;
				break;
			default: // Derby mode embedded, démarré automatiquement avec l'application
				org.apache.derby.jdbc.EmbeddedDataSource es = new org.apache.derby.jdbc.EmbeddedDataSource();
				es.setCreateDatabase("create");
				es.setDatabaseName("embedded_sample");
				result = es;
		}

		return result;
	}
}
