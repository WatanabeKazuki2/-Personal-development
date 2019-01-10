package free_mm;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	static final String BOAD_COMPLETE_PAGE="/WEB-INF/jsp/BoadComplete.jsp";
//	ボード完了ページ
	static final String BOAD_FINAL_PAGE="/WEB-INF/jsp/BoadFinal.jsp";
//	ボード入力ページ
	static final String BOAD_INPUT_PAGE="/WEB-INF/jsp/BoadInput.jsp";
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
	static final String GOODS_BOAD_PAGE="/WEB-INF/jsp/GoodsBoad.jsp";
//	商品削除ページ
	static final String GOODS_DELETE_PAGE="/WEB-INF/jsp/GoodsDelete.jsp";
//	商品リストページ
	static final String GOODS_LIST_PAGE="/WEB-INF/jsp/GoodsList.jsp";
//	商品参照ページ
	static final String GOODS_REFERENCE_PAGE="/WEB-INF/jsp/GoodsReference.jsp";
//	商品更新ページ
	static final String GOODS_UPDATE_PAGE="/WEB-INF/jsp/GoodsUpdate.jsp";

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
}
