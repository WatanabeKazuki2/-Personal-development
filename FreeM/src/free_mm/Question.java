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
 * Servlet implementation class Question
 */
@WebServlet("/Question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Question() {
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

			//		URLからIDを取得
			int goodsId = Integer.parseInt(request.getParameter("goodsId"));
			GoodsDateBeans gdb = new GoodsDateBeans();
			try {
//
				gdb = GoodsDao.GR(goodsId);

				int price = gdb.getPrice();
				int dmp = gdb.getDeliveryMethodPrice();
				int totalPrice =
						FMHelper.total(price, dmp);

				session.setAttribute("goodsId", goodsId);
				request.setAttribute("gr",gdb);
				request.setAttribute("tp",totalPrice);
				// フォワード
				request.getRequestDispatcher(FMHelper.Question_Page).forward(request, response);

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
		int goodsId = (int) session.getAttribute("goodsId");

		try {
			GoodsDao.Standby(goodsId,userId);

//			完了画面にリダイレクト
			response.sendRedirect("Complete");

//			商品IDのセッションを切る
			session.removeAttribute("goodsId");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}catch(NumberFormatException e){
			e.printStackTrace();

		}

	}

}
