package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.BoardDateBeans;

public class BoardDao {

//	掲示板コメント表示用
	public static ArrayList<BoardDateBeans> boadIndicate(int goodsId) throws SQLException {
//		DBに接続
		Connection conn = DBManager.getConnection();


		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT f_board.*,\r\n" +
					"user_info.user_name\r\n" +
					"FROM f_board\r\n" +
					"INNER JOIN user_info\r\n" +
					"ON f_board.user_id = user_info.user_id\r\n" +
					"WHERE f_board.item_id=?;");

			pStmt.setInt(1,goodsId);

			ResultSet rs = pStmt.executeQuery();

			ArrayList<BoardDateBeans> boardList= new ArrayList<BoardDateBeans>();

			while(rs.next()) {
				BoardDateBeans bdb = new BoardDateBeans();
				bdb.setId(rs.getInt("f_board.id"));
				bdb.setGoodsId(rs.getInt("f_board.item_id"));
				bdb.setBoadComment(rs.getString("f_board.board_comment"));
				bdb.setCreateDate(rs.getDate("f_board.create_date"));
				bdb.setUserName(rs.getString("user_info.user_name"));

				boardList.add(bdb);
			}

			return boardList;


		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}


	}


	public static void boardInput(int goodsId,String comment,int userId) throws SQLException {
		Connection conn = DBManager.getConnection();

		try {
//			INSERT文を準備
			PreparedStatement pStmt=conn.prepareStatement("INSERT INTO f_board("
					+ "item_id,"
					+ "board_comment,"
					+ "create_date,"
					+ "user_id) "
					+ "VALUES(?,?,now(),?)");

//			？に値をセット
			pStmt.setInt(1,goodsId);
			pStmt.setString(2,comment);
			pStmt.setInt(3,userId);

			pStmt.executeUpdate();

			pStmt.close();
		}finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}

}
