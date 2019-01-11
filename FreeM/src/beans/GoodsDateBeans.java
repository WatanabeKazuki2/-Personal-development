package beans;

import java.util.Date;

public class GoodsDateBeans {

	private int id;
	private String name;
	private int categoryId;
	private String detail;
	private int price;
	private String fileName;
	private int byuUserId;
	private int exibitUserId;
	private int status;
	private Date createDate;
	private Date updateDate;
	private int deliveryMethodId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getByuUserId() {
		return byuUserId;
	}
	public void setByuUserId(int byuUserId) {
		this.byuUserId = byuUserId;
	}
	public int getExibitUserId() {
		return exibitUserId;
	}
	public void setExibitUserId(int exibitUserId) {
		this.exibitUserId = exibitUserId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}
	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}



}
