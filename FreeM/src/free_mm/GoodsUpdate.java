package free_mm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.CategoryDateBeans;
import beans.DeliveryMethodDateBeans;
import beans.GoodsDateBeans;
import dao.CategoryDao;
import dao.DeliveryMethodDao;
import dao.GoodsDao;

/**
 * Servlet implementation class GoodsUpdate
 */
@WebServlet("/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		URLから商品IDのを取得
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));

		try {
//			商品情報取得
			GoodsDateBeans gdb = GoodsDao.GR(goodsId);
//			カテゴリー一覧を取得
			List<CategoryDateBeans> categoryList = CategoryDao.CategoryList();
//			運送情報一覧を取得
			List<DeliveryMethodDateBeans> dmdList = DeliveryMethodDao.DMD();

//			jspに各情報をセット
			request.setAttribute("gdb", gdb);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("dmdList",dmdList);

			// フォワード
			request.getRequestDispatcher(FMHelper.GOODS_UPDATE_PAGE).forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

//		セッションからユーザーIDを取得（ログインユーザー特定）
		int userId = (int) session.getAttribute("userId");

//		jspの値を取得
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String goodsName = request.getParameter("goodsName");
		Part part = request.getPart("fileName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int deliveryMethodId = Integer.parseInt(request.getParameter("deliveryId"));
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("coment");

		String fileName = FMHelper.getFileName(part, userId);

		try {
			GoodsDao.GoodsUpdate(goodsName, fileName, categoryId, detail, price, deliveryMethodId, goodsId, userId);

			response.sendRedirect("Complete");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
