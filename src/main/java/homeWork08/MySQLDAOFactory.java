package homeWork08;

public class MySQLDAOFactory extends DAOFactory {

	private DBWorker dbWorker = new DBWorker();

	@Override
	public HeroesDAO getHeroesDAO() {
		return new MySQLHeroesDAO(dbWorker);
	}

}
