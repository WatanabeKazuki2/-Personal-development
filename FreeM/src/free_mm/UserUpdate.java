package free_mm;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		セッションに保存されてるユーザーIDを取得
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")==null) {
//			エラーページへ
			response.sendRedirect("Error");
		}else {

			int userId = (int) session.getAttribute("userId");
			try {

				UserDateBeans user = UserDao.AllUserDateBeans(userId);

//			値をJSPにセット
				request.setAttribute("user",user);
				// フォワード
				request.getRequestDispatcher(FMHelper.USER_UPDATE_PAGE).forward(request, response);

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

		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String mailAddress = request.getParameter("mailAddress");
		String streetAddress = request.getParameter("streetAddress");

//		入力ミスの条件
		if(name.equals("")||birthDate.equals("")||!(password.equals(password2))||mailAddress.equals("")||streetAddress.equals("")) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// ログインjspにフォワード
			doGet(request, response);
		}else {
			try {
				UserDao.UserUpdate(userId, name, birthDate, password, mailAddress, streetAddress);
			} catch (SQLException | NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			response.sendRedirect("UserReference");
		}

	}

}
