package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataBase {

	private final static String user = "root";
	private final static String password = "soma1020naw";
	private static int result;

	public static String insert(String name, String mail, String comment,String faile) {

		final String url = "jdbc:mysql://localhost:3306/SNS?serverTimezone=JST";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LocalDateTime date1 = LocalDateTime.now();
		DateTimeFormatter dtformat1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS E");
		String fdate1 = dtformat1.format(date1);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,password);
				//全検索するSQLを作成する
				String sql = "INSERT snsdata(name,mail,days,comment,faile) VALUES(?,?,?,?,?)";
				//SELECTの準備と実行

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,mail);
				pstmt.setString(3,fdate1);
				pstmt.setString(4,comment);
				pstmt.setString(5,faile);

				pstmt.executeUpdate();

			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
		    {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
			}
		}
			return fdate1;
	}

	public ArrayList<database.data> select() {
		final String url = "jdbc:mysql://localhost:3306/SNS?serverTimezone=JST";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<database.data> list = new ArrayList<database.data>();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			//DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,password);
			//全検索するSQLを作成する
			String sql_select = "SELECT * FROM snsdata;";
			//SELECTの準備と実行
			pstmt = con.prepareStatement(sql_select);

			rs = pstmt.executeQuery();

			while(rs.next() == true){
				list.add(new database.data(rs.getInt("id"),rs.getString("name"),rs.getString("mail"),rs.getString("days"),rs.getString("updatetime"),rs.getString("comment"),rs.getString("faile")));
			}


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<database.data> One_select(int id) {
			final String url = "jdbc:mysql://localhost:3306/SNS?serverTimezone=JST";

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<database.data> list = new ArrayList<database.data>();


			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				//DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,password);
				//全検索するSQLを作成する
				String sql_select = "SELECT * FROM snsdata WHERE id = '"+id+"';";
				//SELECTの準備と実行
				pstmt = con.prepareStatement(sql_select);

				rs = pstmt.executeQuery();

				while(rs.next() == true){
					list.add(new database.data(rs.getInt("id"),rs.getString("name"),rs.getString("mail"),rs.getString("days"),rs.getString("updatetime"),rs.getString("comment"),rs.getString("faile")));
				}


			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return list;
		}
	public static void remove(int id) {

		final String url = "jdbc:mysql://localhost:3306/SNS?serverTimezone=JST";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,password);
				//全検索するSQLを作成する
				String delete = "DELETE FROM snsdata WHERE id = '"+id+"';";
				//SELECTの準備と実行

				pstmt = con.prepareStatement(delete);

				pstmt.executeUpdate();

			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
		    {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
			}
		}
	}

	public static void change(String sql) {
		final String url = "jdbc:mysql://localhost:3306/SNS?serverTimezone=JST";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,password);

				pstmt = con.prepareStatement(sql);

				pstmt.executeUpdate();

			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
		    {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e1) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e1.printStackTrace();
				}
			}
		}
	}
}
