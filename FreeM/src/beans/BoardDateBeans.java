package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDateBeans {

	private int id;
	private int goodsId;
	private String boadComment;
	private Date createDate;
	private int userId;
	private String userName;


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getBoadComment() {
		return boadComment;
	}
	public void setBoadComment(String boadComment) {
		this.boadComment = boadComment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(createDate);
	}

}
