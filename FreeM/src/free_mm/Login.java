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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
				//		すでにログインセッションがあるならエラーページへ
		if(session.getAttribute("userId")!=null) {

//			エラーページへ
			response.sendRedirect("Error");
		}else {

		// フォワード
		request.getRequestDispatcher(FMHelper.LOGIN_PAGE).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		try {
			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
			UserDao userDao = new UserDao();
			int userId = userDao.getUserId(loginId, password);

			UserDateBeans user = UserDao.UserDateBeans(userId);

			/** テーブルに該当のデータが見つからなかった場合 **/
			if (user == null) {
				// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

				// ログインjspにフォワード
				request.getRequestDispatcher(FMHelper.LOGIN_PAGE).forward(request, response);
			return;
			}
			/** テーブルに該当のデータが見つかった場合 **/
			// セッションにユーザの情報をセット
			session.setAttribute("userId", userId);
			session.setAttribute("userInfo", user);


			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("Index");


		}catch(SQLException | NoSuchAlgorithmException e){
			e.printStackTrace();

		}

	}
}