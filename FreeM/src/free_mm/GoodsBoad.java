package free_mm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardDateBeans;
import beans.GoodsDateBeans;
import dao.BoardDao;
import dao.GoodsDao;

/**
 * Servlet implementation class GoodsBoad
 */
@WebServlet("/GoodsBoad")
public class GoodsBoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsBoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			request.getRequestDispatcher(FMHelper.GOODS_BOAD_PAGE).forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
