import java.util.Date;
import java.util.Map;
public class Purchase {
	//fill the code
	private Long id;
	private Date purchaseDate;
	private Double totalAmount;
	private String user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Purchase(Long id, Date purchaseDate, Double totalAmount, String user) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.user = user;
	}
	public Purchase() {
		super();
	}
	public static void obtainPurchaseWithItem(Map<String, Integer> map,String purchaseDetail) {
		//fill the code
		String strArr[]=purchaseDetail.split(",");
		int index=3;
		while(index<strArr.length){
			if(map.containsKey(strArr[index])){
				Integer value=map.get(strArr[index]);
				map.put(strArr[index], value+Integer.parseInt(strArr[index+2]));
			}else{
				map.put(strArr[index], Integer.parseInt(strArr[index+2]));
			}
			index=index+3;
		}
	}
}
