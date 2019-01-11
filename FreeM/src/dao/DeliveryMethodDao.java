package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.DeliveryMethodDateBeans;

public class DeliveryMethodDao {
//	運送データ一覧
	public static List<DeliveryMethodDateBeans> DMD() throws SQLException{
//		DBに接続
		Connection conn = DBManager.getConnection();
//		リスト作成
		List<DeliveryMethodDateBeans> dmList = new ArrayList<DeliveryMethodDateBeans>();

		try {
			String sql = "SELECT * FROM f_delivery_method";
			 // SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	DeliveryMethodDateBeans umdb = new DeliveryMethodDateBeans();
            	umdb.setDeliveryId(rs.getInt("id"));
            	umdb.setDeliveryName(rs.getString("name"));

                dmList.add(umdb);
            }

            return dmList;

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
