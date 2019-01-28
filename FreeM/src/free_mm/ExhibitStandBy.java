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
 * Servlet implementation class ExhibitList
 */
@WebServlet("/ExhibitStandBy")
public class ExhibitStandBy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExhibitStandBy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int userId = (int)session.getAttribute("userId");

		try {
//			userIdから出品リストを取得
			ArrayList<GoodsDateBeans> ESB = GoodsDao.ExhibitStandBy(userId);

//		jspに値を引き渡す
			request.setAttribute("esb",ESB);

			// フォワード
			request.getRequestDispatcher(FMHelper.EXHIBIT_STAND_BY_PAGE).forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
