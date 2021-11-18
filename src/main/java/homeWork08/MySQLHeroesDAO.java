package homeWork08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLHeroesDAO implements HeroesDAO {
	private DBWorker dbWorker;
	private String[] abs = new String[3];

//private static final String INSERT = "INSERT INTO students02 (id,name,ultimate) VALUES(%d,'%s','%s')";
//private static final String GET_ALL = "SELECT * FROM students02";
//private static final String CREAT_TABLE = "CREATE TABLE students02 (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), ultimate VARCHAR(20))";

	public MySQLHeroesDAO(DBWorker dbWorker) {
		this.dbWorker = dbWorker;
		file();
	}

	public void file() {
		String inputFileName = "src/main/resources/dump.sql";
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {

			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				abs[i] = line;
				i++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addHeroes(Heroes heroes) {
		Connection conn = dbWorker.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = String.format(abs[0], heroes.getName(), heroes.getUltimate());
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void creatTable() {
		Connection conn = dbWorker.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			st.execute(abs[2]);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Heroes> getAll() {
		List<Heroes> customerList = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			conn = dbWorker.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(abs[1]);
			while (rs.next()) {
				Heroes heroes = new Heroes();
				heroes.setId(rs.getInt("id"));
				heroes.setName(rs.getString("name"));
				heroes.setUltimate(rs.getString("ultimate"));
				customerList.add(heroes);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return customerList;
	}

}
