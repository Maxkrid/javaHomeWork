package homeWork08;

public abstract class DAOFactory {
	private static final int MYSQL_FACTORY = 1;

	public abstract HeroesDAO getHeroesDAO();

	public static DAOFactory getDAOFactory(int factory) {
		DAOFactory daoFactory = null;
		switch (factory) {
		case MYSQL_FACTORY:
			daoFactory = new MySQLDAOFactory();
			break;
		default:
			daoFactory = new MySQLDAOFactory();
		}
		return daoFactory;
	}
}
