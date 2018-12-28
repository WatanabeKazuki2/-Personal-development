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

			int userId = rs.getInt("id");
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

			String sql = "SELECT * FROM user_info WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,userId );
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				udb.set
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return udb;
	}

}