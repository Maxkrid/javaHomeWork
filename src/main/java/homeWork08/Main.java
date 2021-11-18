package homeWork08;

public class Main {

	public static void main(String[] args) {

		DBWorker db = new DBWorker();
		MySQLHeroesDAO my = new MySQLHeroesDAO(db);
		my.creatTable();
		Heroes heroes = new Heroes("Lun", "Eclipse");
		Heroes heroes2 = new Heroes("2", "Eclipse");
		Heroes heroes3 = new Heroes("3", "Eclipse");
		my.addHeroes(heroes2);
		my.addHeroes(heroes3);
System.out.println(my.getAll());
	}

}
