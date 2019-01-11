package free_mm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDateBeans;
import dao.UserDao;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<UserDateBeans> userList = UserDao.UserAll();

		request.setAttribute("userList", userList);
		// フォワード
		request.getRequestDispatcher(FMHelper.USER_LIST_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		検索タブの文字を取得
		String name = request.getParameter("name");

//		DBから検索したユーザー情報を取得
		List<UserDateBeans> seachUser = UserDao.UserSeach(name);

//		jspにセット
		request.setAttribute("userList", seachUser);

		// フォワード
		request.getRequestDispatcher(FMHelper.USER_LIST_PAGE).forward(request, response);

	}

}
