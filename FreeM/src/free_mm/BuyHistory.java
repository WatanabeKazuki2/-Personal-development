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

import beans.GoodsDateBeans;
import dao.GoodsDao;

/**
 * Servlet implementation class BuyHistory
 */
@WebServlet("/BuyHistory")
public class BuyHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		ユーザーIDの呼び出し
		if(session.getAttribute("userId")==null) {
//			エラーページへ
			response.sendRedirect("Error");
		}else {
			int userId = (int)session.getAttribute("userId");
			try {
//			リストでユーザーIDをもとに出品履歴を呼び出し


				ArrayList<GoodsDateBeans> bhList = GoodsDao.BuyHistory(userId);

//			リクエストスコープに値をセット
				request.setAttribute("bhList", bhList);

				// フォワード
				request.getRequestDispatcher(FMHelper.BUY_HISTORY_PAGE).forward(request, response);

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
