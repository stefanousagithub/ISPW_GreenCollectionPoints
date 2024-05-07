package application.persistence;

import java.util.ArrayList;

public interface DAOActions<Entity> {
	//Modificare le credenziali d'accesso (USER, PASS, DB_NAME) qui!
    static final String USER = "postgres";
    static final String PASS = "postgres";
    static final String DB_NAME = "risorsedb";
	static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";

	public boolean find(Entity e);

	public void store(Entity e);

	public void update(Entity e);

	public void delete(Entity e);

	public ArrayList<Entity> getTable();

}
