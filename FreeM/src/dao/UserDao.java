package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.UserDateBeans;
import free_mm.FMHelper;

public class UserDao {

	//ユーザーIDを取得用
	@SuppressWarnings("null")
	public int getUserId(String loginId, String password) throws NoSuchAlgorithmException, SQLException {
		Connection conn = DBManager.getConnection();

		try {
			// データベースへ接続

			// SELECT文を準備
			String sql = "SELECT * FROM user_info WHERE login_id = ? and password = ?";

//			パスワードをMD5で暗号化
			String ps = FMHelper.psMD5(password);
			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, ps);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return (Integer) null;
            }

			int userId = rs.getInt("user_id");
			return userId;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	//ユーザーIDからユーザー情報を取得
	public static UserDateBeans UserDateBeans(int userId) throws SQLException {
		//データベースへ接続
		Connection conn = DBManager.getConnection();
		UserDateBeans udb = new UserDateBeans();
		try {

			String sql = "SELECT * FROM user_info WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,userId );
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				udb.setUserId(rs.getInt("user_id"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setName(rs.getString("user_name"));

			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return udb;
	}
//	ユーザー情報の全件取得
	public static UserDateBeans AllUserDateBeans(int userId) throws SQLException {
		//データベースへ接続
		Connection conn = DBManager.getConnection();
		UserDateBeans udb = new UserDateBeans();
		try {
			String sql = "SELECT * FROM user_info WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,userId );
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				udb.setUserId(rs.getInt("user_id"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setName(rs.getString("user_name"));
				udb.setBirthDate(rs.getDate("birth_date"));
				udb.setCreateDate(rs.getDate("create_date"));
				udb.setUpdateDate(rs.getDate("update_date"));
				udb.setMailAddress(rs.getString("mail_address"));
				udb.setStreetAddress(rs.getString("street_address"));

			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return udb;
	}

//	ユーザー新規登録用
	public static void UserEntry(String loginId,String name,String password,String birthDate,String mailAddress,String streetAddress) throws NoSuchAlgorithmException{
//		データベースへの接続
		Connection conn = DBManager.getConnection();
		try {
//			パスワードをMD5で暗号化
			String ps = FMHelper.psMD5(password);

			//INSERT文を準備
			String sql = "INSERT INTO user_info ("
					+ "login_id ,"
					+ "user_name,"
					+ "password,"
					+ "birth_date,"
					+ "mail_address,"
					+ "street_address,"
					+ "create_date,"
					+ "update_date)"
					+ "VALUES(?,?,?,?,?,?,now(),now())";

			//INSERT文に内容を入れる
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,loginId);
			pStmt.setString(2,name);
			pStmt.setString(3,ps);
			pStmt.setString(4,birthDate);
			pStmt.setString(5,mailAddress);
			pStmt.setString(6,streetAddress);

			pStmt.executeUpdate();

			pStmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

//	ユーザー更新用
	public static void UserUpdate(int userId,String name,String birthDate,String password,String mailAddress,String streetAddress) throws SQLException, NoSuchAlgorithmException {
//		データベースに接続
		Connection conn = DBManager.getConnection();
		try {

//			パスワードに変更がない時
			if(password.equals("")) {
//				SQLにUPDATE文を準備
					String sql = "UPDATE user_info SET "
							+ "user_name = ?,"
							+ "birth_date = ?,"
							+ "mail_address=?,"
							+ "street_address=?,"
							+ "update_date=now() "
							+ "WHERE "
							+ "user_id = ?";

//				PreparedStatementで？に値をセット
					PreparedStatement pStmt = conn.prepareStatement(sql);

					pStmt.setString(1,name);
					pStmt.setString(2,birthDate);
					pStmt.setString(3,mailAddress);
					pStmt.setString(4,streetAddress);
					pStmt.setInt(5,userId);

					pStmt.executeUpdate();

					pStmt.close();

			}else {
//		パスワードをMD5で暗号化
				String ps = FMHelper.psMD5(password);
//			SQLにUPDATE文を準備
				String sql = "UPDATE user_info SET "
						+ "user_name = ?,"
						+ "birth_date = ?,"
						+ "password = ?,"
						+ "mail_address=?,"
						+ "street_address=?"
						+ "update_date=now()"
						+ "WHHERE "
						+ "userId = ?";

//			PreparedStatementで？に値をセット
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1,name);
				pStmt.setString(2,birthDate);
				pStmt.setString(3,ps);
				pStmt.setString(4,mailAddress);
				pStmt.setString(5,streetAddress);
				pStmt.setInt(6,userId);

				pStmt.executeUpdate();

				pStmt.close();

			}
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

//	ユーザーリスト用
	public static List<UserDateBeans> UserAll(){
		Connection conn = DBManager.getConnection();
		List<UserDateBeans> userList = new ArrayList<UserDateBeans>();
		String sql = "SELECT user_info.*,\r\n" +
				"COUNT(f_item.exibit_user_id)\r\n" +
				" FROM user_info\r\n" +
				" LEFT OUTER JOIN f_item\r\n" +
				" ON user_info.user_id = f_item.exibit_user_id\r\n" +
				" AND f_item.status=1\r\n" +
				" GROUP BY \r\n" +
				" user_info.user_id";
		try {
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				 UserDateBeans udb = new UserDateBeans();
				udb.setUserId(rs.getInt("user_id"));
				udb.setName(rs.getString("user_name"));
				udb.setCount(rs.getInt("COUNT(f_item.exibit_user_id)"));

				userList.add(udb);
			 }

			return userList;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

		}
		return userList;
	}

	public static List<UserDateBeans> UserSeach(String name) {
        Connection conn = null;
        List<UserDateBeans> userList = new ArrayList<UserDateBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備

            String sql = "SELECT user_info.*,\r\n" +
            		"COUNT(f_item.exibit_user_id)\r\n" +
            		" FROM user_info\r\n" +
            		" LEFT OUTER JOIN f_item\r\n" +
            		" ON user_info.user_id = f_item.exibit_user_id\r\n" +
            		" AND f_item.status=1\r\n"+
            		 "WHERE user_name LIKE ? \r\n"+
            		" GROUP BY \r\n" +
            		" user_info.user_id";

            PreparedStatement pStmt = conn.prepareStatement(sql);

            if(!name.isEmpty()) {
            	pStmt.setString(1,"%" + name + "%");
            }else {
            	pStmt.setString(1,"%" + "" + "%");
            }


			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				 UserDateBeans udb = new UserDateBeans();
				udb.setUserId(rs.getInt("user_id"));
				udb.setName(rs.getString("user_name"));
				udb.setCount(rs.getInt("COUNT(f_item.exibit_user_id)"));

				userList.add(udb);
			 }

			return userList;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

		}
		return userList;
	}


}