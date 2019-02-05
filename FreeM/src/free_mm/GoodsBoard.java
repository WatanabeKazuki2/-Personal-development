package free_mm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BoardDateBeans;
import beans.GoodsDateBeans;
import dao.BoardDao;
import dao.GoodsDao;

/**
 * Servlet implementation class GoodsBoad
 */
@WebServlet("/GoodsBoard")
public class GoodsBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")==null) {
//			エラーページへ
			response.sendRedirect("Error");
		}else {

//		jspから商品ID取得
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));

			try {
//			商品の情報呼び出し
				GoodsDateBeans gdb = GoodsDao.GR(goodsId);

//			商品の合計算出
				int total = FMHelper.total(gdb.getPrice(), gdb.getDeliveryMethodPrice());

//			掲示板の情報呼び出し
				ArrayList<BoardDateBeans> bdbList = BoardDao.boadIndicate(goodsId);

//			jspに値をセット
				request.setAttribute("gdb", gdb);
				request.setAttribute("tp", total);
				request.setAttribute("bdbList",bdbList);

				// フォワード
				request.getRequestDispatcher(FMHelper.GOODS_BOARD_PAGE).forward(request, response);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int userId = (int)session.getAttribute("userId");

		int goodsId = Integer.parseInt(request.getParameter("goodsId"));

		try {
//			商品情報を呼び出す
			GoodsDateBeans gdb = GoodsDao.GR(goodsId);

//			出品者か購入者をを判別してDaoの呼び出し
			if(userId == gdb.getExibitUserId()) {
//				出品者側の処理
				GoodsDao.ExhibitUserStatus(userId, goodsId);

			}else if(userId==gdb.getByuUserId()) {
//				購入者側の処理
				GoodsDao.BuyUserStatus(userId, goodsId);

			}

			GoodsDateBeans gdbc = GoodsDao.GR(goodsId);

//			両ユーザーが成立ボタンが押されてた場合に働く処理
			if(gdbc.getBuyUserStatus() ==1 && gdbc.getExhibitUserStatus() == 1) {

				GoodsDao.BuyComplete(goodsId);

			}

//			完了画面にリダイレクト
			response.sendRedirect("Complete");

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
