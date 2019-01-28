package free_mm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.GoodsDateBeans;
import dao.GoodsDao;

/**
 * Servlet implementation class GoodsReference
 */
@WebServlet("/GoodsReference")
public class GoodsReference extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsReference() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int goodsId = Integer.parseInt(request.getParameter("goodsId"));

		try {
//		商品情報の呼び出し
			GoodsDateBeans gr = GoodsDao.GR(goodsId);
//		リクエストスコープにセット
			request.setAttribute("goods",gr);

			// フォワード
			request.getRequestDispatcher(FMHelper.GOODS_REFERENCE_PAGE).forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("Question");

	}
	 */

}
