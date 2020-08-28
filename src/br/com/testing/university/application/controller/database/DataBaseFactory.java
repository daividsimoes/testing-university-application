package br.com.testing.university.application.controller.database;

/**
 * Simulate a Data Base Factory
 * 
 * @author Daivid
 *
 */
public class DataBaseFactory {

	private static DataBase dataBase;

	public DataBase getConnection() {

		if (DataBaseFactory.dataBase == null) {
			DataBaseFactory.dataBase = new DataBase();
		}

		return DataBaseFactory.dataBase;
	}
}