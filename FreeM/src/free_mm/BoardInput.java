package free_mm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;

/**
 * Servlet implementation class BoardInput
 */
@WebServlet("/BoardInput")
public class BoardInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int goodsId = Integer.parseInt(request.getParameter("goodsId"));

		request.setAttribute("gid", goodsId);
		// フォワード
		request.getRequestDispatcher(FMHelper.BOARD_INPUT_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userId");

//		jspの値を取得
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String comment = request.getParameter("comment");

		try {
//			Daoに値を送る
			BoardDao.boardInput(goodsId, comment, userId);

			response.sendRedirect("Complete");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
