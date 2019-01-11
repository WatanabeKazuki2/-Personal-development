package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.CategoryDateBeans;

public class CategoryDao {

//	header用のDao

//	カテゴリー検索タブ用
	public static List<CategoryDateBeans> CategoryList(){
		        Connection conn = null;
		        List<CategoryDateBeans> categoryList = new ArrayList<CategoryDateBeans>();

		        try {
		            // データベースへ接続
		            conn = DBManager.getConnection();

		            // SELECT文を準備

		            String sql = "SELECT * FROM category";


		            // SELECTを実行し、結果表を取得
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);

		            // 結果表に格納されたレコードの内容を
		            // Userインスタンスに設定し、ArrayListインスタンスに追加
		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                CategoryDateBeans category = new CategoryDateBeans(id,name);

		                categoryList.add(category);
		            }
		            return categoryList;

		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        } finally {
		            // データベース切断
		            if (conn != null) {
		                try {
		                    conn.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                    return null;
		                }
		            }
		        }
		    }
}
