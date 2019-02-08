package free_mm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CategoryDateBeans;
import beans.GoodsDateBeans;
import dao.CategoryDao;
import dao.GoodsDao;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			// カテゴリーを表示
			List<CategoryDateBeans> categoryList = CategoryDao.CategoryList();
//		TOPページに商品をランダムで4つ表示
			List<GoodsDateBeans> goods = GoodsDao.IndexGoods(4);

			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
			}

			// リクエストスコープ情報をセット
			request.setAttribute("goodsList", goods);
			request.setAttribute("categoryList",categoryList);

			// フォワード
			request.getRequestDispatcher(FMHelper.TOP_PAGE).forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String seachWord = request.getParameter("seach");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));

		session.setAttribute("seachWord", seachWord);
		session.setAttribute("categoryId", categoryId);
		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("GoodsList");


	}

}
