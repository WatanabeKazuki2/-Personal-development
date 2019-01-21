package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.GoodsDateBeans;

public class GoodsDao {
//	ホーム用
	public static ArrayList<GoodsDateBeans> IndexGoods(int limit) throws SQLException{
		Connection conn = DBManager.getConnection();
		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,category.name,user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"WHERE f_item.status=1\r\n" +
					"ORDER BY RAND() LIMIT ?;");
			pStmt.setInt(1,limit);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

//			DBの値を持ってくる
			while(rs.next()) {
				GoodsDateBeans goods = new GoodsDateBeans();
				goods.setId(rs.getInt("f_item.id"));
				goods.setName(rs.getString("f_item.name"));
				goods.setCategoryName(rs.getString("category.name"));
				goods.setPrice(rs.getInt("f_item.price"));
				goods.setFileName(rs.getString("f_item.file_name"));
				goods.setExibitUserName(rs.getString("user_info.user_name"));
				goodsList.add(goods);
			}

			return goodsList;
		}finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

//	商品検索用
	public static ArrayList<GoodsDateBeans> seachGoods(String name) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
			PreparedStatement pStmt = conn.prepareStatement("");

			pStmt.setString(1,"%" + name + "%");

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setFileName(rs.getString(""));
				gdb.setName(rs.getString(""));
				gdb.setCategoryName(rs.getString(""));
				gdb.setDeliveryMethodName(rs.getString(""));
				gdb.setPrice(rs.getInt(""));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {

		}



	}

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
		pStmt.setInt(2,categoryId);
		pStmt.setString(3,coment);
		pStmt.setInt(4,price);
		pStmt.setString(5,fileName);
		pStmt.setInt(6,userId);
		pStmt.setInt(7,deliveryId);

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
