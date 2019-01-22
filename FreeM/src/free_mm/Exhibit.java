package free_mm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.CategoryDateBeans;
import beans.DeliveryMethodDateBeans;
import dao.CategoryDao;
import dao.DeliveryMethodDao;
import dao.GoodsDao;

/**
 * Servlet implementation class Exibit
 */
@WebServlet("/Exhibit")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class Exhibit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Exhibit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// カテゴリーリストを取得
			List<CategoryDateBeans> categoryList = CategoryDao.CategoryList();
//			運送リストを取得
			List<DeliveryMethodDateBeans> dmList = DeliveryMethodDao.DMD();
			// リクエストスコープにカテゴリー情報をセット
			request.setAttribute("categoryList",categoryList);
			// リクエストスコープに運送情報をセット
			request.setAttribute("dmList", dmList);

			// フォワード
			request.getRequestDispatcher(FMHelper.EXHIBIT_PAGE).forward(request, response);
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
//		セッションから自身のIDを取得
		int userId = (int) session.getAttribute("userId");
		request.getAttribute("userId");
//		jspの値を取得
		String goodsName = request.getParameter("goodsName");
		Part part = request.getPart("fileName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int deliverId = Integer.parseInt(request.getParameter("deliveryId"));
		int price = Integer.parseInt(request.getParameter("price"));
		String coment = request.getParameter("coment");

//		画像ファイルを保存する
		String fileName = this.getFileName(part);

		part.write(getServletContext().getRealPath("/img") + "/" + fileName);


		try {
			GoodsDao.Exhibit(userId,goodsName,fileName,categoryId,deliverId,price,coment);

			response.sendRedirect("Complete");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}

}
