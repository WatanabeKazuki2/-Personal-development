package free_mm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class GoodsList
 */
@WebServlet("/GoodsList")
public class GoodsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		検索ワードをセッションから取得
		String seach=(String) session.getAttribute("seachWord");
		int categoryId =(int) session.getAttribute("categoryId");
		try {
			// カテゴリーを表示
			List<CategoryDateBeans> categoryList = CategoryDao.CategoryList();

			ArrayList<GoodsDateBeans> gList = GoodsDao.seachGoods(categoryId,seach);

			//		jspにサーチワードをセット
			request.setAttribute("gList", gList);
			request.setAttribute("categoryList",categoryList);
			// フォワード
			request.getRequestDispatcher(FMHelper.GOODS_LIST_PAGE).forward(request, response);

//			フォワード後セッションを切る
			String searchWord = (String)session.getAttribute("searchWord");
			if(searchWord != null) {
				session.removeAttribute("searchWord");
			}

			session.removeAttribute("categoryId");
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


		String seach = request.getParameter("seach");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		try {

			ArrayList<GoodsDateBeans> gList = GoodsDao.seachGoods(categoryId,seach);

			//		jspにサーチワードをセット
			request.setAttribute("gList", gList);

			// フォワード
			request.getRequestDispatcher(FMHelper.GOODS_LIST_PAGE).forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
