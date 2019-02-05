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
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.name,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.status=1\r\n" +
					"AND\r\n" +
					"f_item.name LIKE ?;");
			if(!name.isEmpty()) {
				pStmt.setString(1,"%" + name + "%");
			}else {
				pStmt.setString(1,"%" + "" + "%");
			}

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setId(rs.getInt("f_item.id"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {
			if (conn != null) {
				conn.close();
			}
		}



	}

//	商品出品用
	public static void Exhibit(int userId,String goodsName, String fileName, int categoryId, int deliveryId, int price,
			String coment) throws SQLException {
//		DBに接続
		Connection conn = DBManager.getConnection();
		try {

//		INSERT文を準備
			String sql = "INSERT INTO f_item("
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

//	商品詳細用
	public static GoodsDateBeans GR(int goodsId) throws SQLException {
//		DBに接続
		Connection conn = DBManager.getConnection();
		try {
//			SELECT文を準備
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.*,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.id=?;");

//			？に値を代入
			pStmt.setInt(1,goodsId);

			ResultSet rs = pStmt.executeQuery();

			GoodsDateBeans gdb = new GoodsDateBeans();
			if(rs.next()) {

				gdb.setId(rs.getInt("f_item.id"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				gdb.setDetail(rs.getString("f_item.detail"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setDeliveryMethodPrice(rs.getInt("f_delivery_method.price"));
				gdb.setExibitUserId(rs.getInt("f_item.exibit_user_id"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setByuUserId(rs.getInt("f_item.buy_user_id"));
				gdb.setBuyUserStatus(rs.getInt("f_item.buy_user_status"));
				gdb.setExhibitUserStatus(rs.getInt("f_item.exibit_user_status"));
				gdb.setUpdateDate(rs.getDate("f_item.update_date"));

			}

			return gdb;
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

//	商品を購入待機中に移行
	public static void Standby(int goodsId,int userId) throws SQLException {
		Connection conn = DBManager.getConnection();

		try{
//			UPDATE文を準備
			PreparedStatement pStmt = conn.prepareStatement("UPDATE f_item\r\n"
					+ "SET status=2,buy_user_id=?\r\n"
					+ "WHERE id=?;");

			pStmt.setInt(1,userId);
			pStmt.setInt(2,goodsId);

			pStmt.executeUpdate();

			conn.close();

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

//	商品に購入者のIDを入力
	public static void BuyUser(int userId,int goodsId) throws SQLException {
		Connection conn = DBManager.getConnection();

		try {
//			INSERT文を準備
			PreparedStatement pStmt = conn.prepareStatement("INSERT INTO f_item(buy_user_id)\r\n"
					+ "VALUES(?) \r\n"
					+ "WHERE id=?;");
			pStmt.setInt(1,userId);
			pStmt.setInt(2,goodsId);

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

//	出品待機用
	public static ArrayList<GoodsDateBeans> ExhibitStandBy(int userId) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.name,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.status=2 AND f_item.exibit_user_id=?;");

			pStmt.setInt(1,userId);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setId(rs.getInt("f_item.id"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

//	出品履歴用
	public static ArrayList<GoodsDateBeans> ExhibitHistory(int userId) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.name,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.status=3 AND f_item.exibit_user_id=?;");

			pStmt.setInt(1,userId);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setId(rs.getInt("f_item.id"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

//	購入履歴用
	public static ArrayList<GoodsDateBeans> BuyHistory(int userId) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.name,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.status=3 AND f_item.buy_user_id=?;");

			pStmt.setInt(1,userId);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setId(rs.getInt("f_item.id"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}


//	出品物リスト
	public static ArrayList<GoodsDateBeans> ExhibitList(int userId) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.name,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.status=1 AND f_item.exibit_user_id=?;");

			pStmt.setInt(1,userId);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setId(rs.getInt("f_item.id"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}



//	購入待機用
	public static ArrayList<GoodsDateBeans> BuyStandBy(int userId) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_item.*,\r\n" +
					"category.name,\r\n" +
					"f_delivery_method.name,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_item INNER JOIN category\r\n" +
					"ON f_item.category_id = category.id\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_item.exibit_user_id=user_info.user_id\r\n" +
					"INNER JOIN f_delivery_method\r\n" +
					"ON f_item.delivery_method_id=f_delivery_method.id\r\n" +
					"WHERE\r\n" +
					"f_item.status=2 AND f_item.buy_user_id=?;");

			pStmt.setInt(1,userId);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<GoodsDateBeans> goodsList = new ArrayList<GoodsDateBeans>();

			while(rs.next()) {
				GoodsDateBeans gdb = new GoodsDateBeans();
				gdb.setId(rs.getInt("f_item.id"));
				gdb.setFileName(rs.getString("f_item.file_name"));
				gdb.setName(rs.getString("f_item.name"));
				gdb.setExibitUserName(rs.getString("user_info.user_name"));
				gdb.setCategoryName(rs.getString("category.name"));
				gdb.setDeliveryMethodName(rs.getString("f_delivery_method.name"));
				gdb.setPrice(rs.getInt("f_item.price"));
				goodsList.add(gdb);
			}
			return goodsList;

		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

//	商品更新用
	public static void GoodsUpdate(String goodsName,String fileName,int categoryId,String detail,int price,int deliveryMethodId,int goodsId,int userId) throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();

		try {
//		UPDATE文を準備
			PreparedStatement pStmt = conn.prepareStatement("UPDATE f_item "
					+ "SET "
					+ "name=?,"
					+ "file_name=?,"
					+ "category_id=?, "
					+ "detail=?, "
					+ "price=?, "
					+ "delivery_method_id=?, "
					+ "update_date=now() "
					+ "WHERE "
					+ "id=? AND exibit_user_id=?");

//			?に値をセット
			pStmt.setString(1,goodsName);
			pStmt.setString(2, fileName);
			pStmt.setInt(3, categoryId);
			pStmt.setString(4, detail);
			pStmt.setInt(5, price);
			pStmt.setInt(6, deliveryMethodId);
			pStmt.setInt(7, goodsId);
			pStmt.setInt(8, userId);

			pStmt.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

//	商品削除用
	public static void GoodsDelete(int userId,int goodsId) throws SQLException {
		Connection conn = DBManager.getConnection();

		try {
//			DELETE文を準備
			PreparedStatement pStmt = conn.prepareStatement("DELETE FROM f_item "
					+ "WHERE "
					+ "exibit_user_id=? AND id=?;");
//			？に値をセット
			pStmt.setInt(1,userId);
			pStmt.setInt(2,goodsId);

			pStmt.executeUpdate();

//			DBを閉じる
			conn.close();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public static void ExhibitUserStatus(int userId,int goodsId) throws SQLException {
//		DBに接続
		Connection conn = DBManager.getConnection();
		try {
//			UPDATE文にてexibit_user_statusを購入承認状態にする
			PreparedStatement pStmt = conn.prepareStatement("UPDATE f_item SET "
					+ "exibit_user_status=1 "
					+ "WHERE "
					+ "id=?;");

			pStmt.setInt(1, goodsId);

			pStmt.executeUpdate();

			conn.close();

		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}

	public static void BuyUserStatus(int userId,int goodsId) throws SQLException{
		Connection conn = DBManager.getConnection();
		try {
//			UPDATE文にてbuy_user_statusを購入承認状態にする
			PreparedStatement pStmt = conn.prepareStatement("UPDATE f_item SET "
					+ "buy_user_status=1 "
					+ "WHERE "
					+ "id=? ");

			pStmt.setInt(1, goodsId);

			pStmt.executeUpdate();

			conn.close();
		}finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}

//	商品を購入済みの状態にする処理
	public static void BuyComplete(int goodsId) throws SQLException {
//		DB接続
		Connection conn = DBManager.getConnection();
		try {
//			UPDATE文にてf_itemのstatusを３（購入済み）に変更
			PreparedStatement pStmt = conn.prepareStatement("UPDATE f_item SET "
					+ "status=3 "
					+ "WHERE id=?");

			pStmt.setInt(1, goodsId);

			pStmt.executeUpdate();

			conn.close();

		}finally {
			if(conn!=null) {
				conn.close();
			}
		}

	}
}
