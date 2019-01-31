package free_mm;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

public class FMHelper {
//	TOPページ
	static final String TOP_PAGE = "/WEB-INF/jsp/index.jsp";
//	ログインページ
	static final String LOGIN_PAGE="/WEB-INF/jsp/Login.jsp";
//	ログアウトページ
	static final String LOGOUT_PAGE="/WEB-INF/jsp/Logout.jsp";
//	ユーザー情報参照ページ
	static final String USER_REFERENCE_PAGE="/WEB-INF/jsp/UserReference.jsp";
//	ユーザー情報更新ページ
	static final String USER_UPDATE_PAGE="/WEB-INF/jsp/UserUpdate.jsp";
//	ユーザー一覧ページ
	static final String USER_LIST_PAGE="/WEB-INF/jsp/UserList.jsp";
//	購入ページ
	static final String BUY_PAGE="/WEB-INF/jsp/Buy.jsp";
//	購入完了ページ
	static final String BUY_COMPLETE_PAGE="/WEB-INF/jsp/BuyComplete.jsp";
//	購入待機ページ
	static final String BUY_STAND_BY_PAGE="/WEB-INF/jsp/BuyStandBy.jsp";
//	購入履歴ページ
	static final String BUY_HISTORY_PAGE="/WEB-INF/jsp/BuyHistory.jsp";
//	カートページ
	static final String CART_PAGE="/WEB-INF/jsp/Cart.jsp";
//	商談成立ページ
	static final String BOARD_COMPLETE_PAGE="/WEB-INF/jsp/BoardComplete.jsp";
//	ボード完了ページ
	static final String BOARD_FINAL_PAGE="/WEB-INF/jsp/BoardFinal.jsp";
//	ボード入力ページ
	static final String BOARD_INPUT_PAGE="/WEB-INF/jsp/BoardInput.jsp";
//	新規登録ページ
	static final String ENTRY_PAGE="/WEB-INF/jsp/Entry.jsp";
//	エラーページ
	static final String ERROR_PAGE="/WEB-INF/jsp/Error.jsp";
//	出品ページ
	static final String EXHIBIT_PAGE="/WEB-INF/jsp/Exhibit.jsp";
//	出品履歴ページ
	static final String EXHIBIT_HISTORY_PAGE="/WEB-INF/jsp/ExhibitHistory.jsp";
//	出品リストページ
	static final String EXHIBIT_LIST_PAGE="/WEB-INF/jsp/ExhibitList.jsp";
//	出品待機ページ
	static final String EXHIBIT_STAND_BY_PAGE="/WEB-INF/jsp/ExhibitStandBy.jsp";
//	商談画面
	static final String GOODS_BOARD_PAGE="/WEB-INF/jsp/GoodsBoard.jsp";
//	商品削除ページ
	static final String GOODS_DELETE_PAGE="/WEB-INF/jsp/GoodsDelete.jsp";
//	商品リストページ
	static final String GOODS_LIST_PAGE="/WEB-INF/jsp/GoodsList.jsp";
//	商品参照ページ
	static final String GOODS_REFERENCE_PAGE="/WEB-INF/jsp/GoodsReference.jsp";
//	商品更新ページ
	static final String GOODS_UPDATE_PAGE="/WEB-INF/jsp/GoodsUpdate.jsp";
//	完了ページ
	static final String Complete_PAGE="/WEB-INF/jsp/Complete.jsp";
//	申請確認ページ
	static final String Question_Page="/WEB-INF/jsp/Question.jsp";

	//MD5暗号化用のメソッド
	public static String psMD5(String ps) throws NoSuchAlgorithmException {
		//ハッシュを生成したい元の文字列
		String source = ps;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		String result = DatatypeConverter.printHexBinary(bytes);
		return result;
	}

//	合計金額算出メソッド
	public static int total(int goodsPrice,int deliveryPrice) {
		int totalPrice = goodsPrice + deliveryPrice;
		return totalPrice;

	}

//	画像ファイルに名前を付けるメソッド
	public static String getFileName(Part part,int userId) {
		Date createDate = new Date();
		String time = new SimpleDateFormat("yyyy_MM_dd hh_mm_ss").format(createDate);
		String id = String.valueOf(userId);
		String fileName = id + part + time;
		return fileName;

	}
}
