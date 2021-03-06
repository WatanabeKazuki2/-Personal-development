package free_mm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GoodsDateBeans;
import dao.GoodsDao;

/**
 * Servlet implementation class GoodsDelete
 */
@WebServlet("/GoodsDelete")
public class GoodsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsDelete() {
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

			int goodsId = Integer.parseInt(request.getParameter("goodsId"));

			try {
				GoodsDateBeans gdb = GoodsDao.GR(goodsId);

//			合計金額算出
				int total = FMHelper.total(gdb.getPrice(), gdb.getDeliveryMethodPrice());

				request.setAttribute("gdb",gdb);
				request.setAttribute("tp",total);
				// フォワード
				request.getRequestDispatcher(FMHelper.GOODS_DELETE_PAGE).forward(request, response);
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userId");
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));

		try {
			GoodsDao.GoodsDelete(userId, goodsId);

			response.sendRedirect("Complete");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
