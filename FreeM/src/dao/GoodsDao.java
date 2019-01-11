package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

public class GoodsDao {

//	商品出品用
	public static void Exhibit(int userId,String goodsName, String fileName, int categoryId, int deliveryId, int price,
			String coment) throws SQLException {
//		DBに接続
		Connection conn = DBManager.getConnection();
		try {

//		INSERT文を準備
		String sql = "INSERT INTO f_iteM("
				+ "name,"
				+ "category_id,"
				+ "detail,"
				+ "price,"
				+ "file_name,"
				+ "exibit_user_id,"
				+ "status,"
				+ "create_date,"
				+ "update_date,"
				+ "delivery_method_id)"
				+ "VALUES(?,?,?,?,?,?,1,now(),now(),?)";

//		sql文に値をセット
		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, goodsName);
		pStmt.setString(2, fileName);
		pStmt.setInt(3,categoryId);
		pStmt.setInt(4, deliveryId);
		pStmt.setInt(5,price);
		pStmt.setString(6,coment);

		pStmt.executeUpdate();

		pStmt.close();

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



}
