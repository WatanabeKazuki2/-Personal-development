package beans;
import java.io.Serializable;
import java.util.Date;
public class UserDateBeans implements Serializable{
	private int userId;
	private String loginId;
	private String name;
	private String password;
	private Date birthDate;
	private String mailAddress;
	private String streetAddress;
	private Date createDate;
	private Date updateDate;
	private int count;


//	setter getter

	public int getUserId() {
		return userId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

//	全件取得用のコンストラクタ
	public UserDateBeans(int userId, String loginId, String name, String password, Date birthDate, String mailAddress,
			String streetAddress, Date createDate, Date updateDate) {
		super();
		this.userId = userId;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.birthDate = birthDate;
		this.mailAddress = mailAddress;
		this.streetAddress = streetAddress;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public UserDateBeans() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
