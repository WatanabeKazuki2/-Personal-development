package free_mm;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class Entry
 */
@WebServlet("/Entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		request.getRequestDispatcher(FMHelper.ENTRY_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String birthDate=request.getParameter("birthDate");
		String mailAddress=request.getParameter("mailAddress");
		String streetAddress=request.getParameter("streetAddress");
		if(loginId.equals("") || name.equals("") || password.equals("") || birthDate.equals("")|| !(password.equals(password2))||mailAddress.equals("")||streetAddress.equals("")){
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// ログインjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(FMHelper.ENTRY_PAGE);
			dispatcher.forward(request, response);
			return;
		}

		try {
			UserDao.UserEntry(loginId,name,password,birthDate,mailAddress,streetAddress);

//			登録終了後ログイン画面へリダイレクト
			response.sendRedirect("Login");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}finally {

		}
	}
}