package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.UserDateBeans;

public class UserDao {

	//ユーザーIDを取得用
	@SuppressWarnings("null")
	public int getUserId(String loginId, String password) throws NoSuchAlgorithmException, SQLException {
		Connection conn = DBManager.getConnection();

		try {
			// データベースへ接続

			// SELECT文を準備
			String sql = "SELECT * FROM user_info WHERE login_id = ? and password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			//ハッシュを生成したい元の文字列
//			String source = password;
			//ハッシュ生成前にバイト配列に置き換える際のCharset
//			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
//			String algorithm = "MD5";

			//ハッシュ生成処理
//			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
//			String result = DatatypeConverter.printHexBinary(bytes);
			pStmt.setString(2, password);
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


			//INSERT文を準備
			String sql = "INSERT INTO user_info (login_id ,user_name,password,birth_date,mail_address,street_address,create_date,update_date)VALUES(?,?,?,?,?,?,now(),now())";

			//INSERT文に内容を入れる
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,loginId);
			pStmt.setString(2,name);
			pStmt.setString(3,password);
			pStmt.setString(4,birthDate);
			pStmt.setString(5,mailAddress);
			pStmt.setString(6,streetAddress);

			pStmt.executeUpdate();

			pStmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}