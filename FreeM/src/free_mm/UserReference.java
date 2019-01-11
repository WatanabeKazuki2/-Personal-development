package free_mm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDateBeans;
import dao.UserDao;

/**
 * Servlet implementation class UserReference
 */
@WebServlet("/UserReference")
public class UserReference extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserReference() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
 		try {
//			ユーザーリストの詳細から飛ぶとき

			if(request.getParameter("userId") == null) {
//				ユーザー情報参照から飛ぶとき
				UserDateBeans user = UserDao.AllUserDateBeans(userId);
				request.setAttribute("userDate", user);
				// フォワード
				request.getRequestDispatcher(FMHelper.USER_REFERENCE_PAGE).forward(request, response);

			}else {
				int userIdUrl = Integer.parseInt(request.getParameter("userId"));

				UserDateBeans user = UserDao.AllUserDateBeans(userIdUrl);
				request.setAttribute("userDate", user);
				// フォワード
				request.getRequestDispatcher(FMHelper.USER_REFERENCE_PAGE).forward(request, response);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{

		}

	}
}
