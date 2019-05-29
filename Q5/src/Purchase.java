import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase implements Comparable {
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
	
	@Override
	public String toString() {
		return String.format("%-10s %-15s %s\n",this.id,this.user,this.totalAmount);
	}
	public static Purchase obtainPurchaseWithAmount(String str) throws InvalidWholeSaleException, ParseException{
		Purchase p=new Purchase();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		String strArr[]=str.split(",");
		int itemLength=(strArr.length/3)-1;
		if(itemLength>=5){
			p.setId(Long.parseLong(strArr[0]));
			/*try {*/
				p.setPurchaseDate(sdf.parse(strArr[1]));
			/*} catch (ParseException e) {
			}*/
			p.setUser(strArr[2]);
			Double total=0d;
			int index=4;
			while(index<strArr.length){
				total+=(Double.parseDouble(strArr[index])*Double.parseDouble(strArr[index+1]));
				index=index+3;
			}
			p.setTotalAmount(total);
		}else{
			//throw new InvalidWholeSaleException(InvalidWholeSaleException.class.getName()+"InvalidWholeSaleException: Purchase "+strArr[0]+" is not a whole sale");
			throw new InvalidWholeSaleException("Purchase "+strArr[0]+" is not a whole sale");
		}
		return p;
	}
	@Override
	public int compareTo(Object o) {
		Purchase p=(Purchase)o;
		if(p.getTotalAmount()==this.totalAmount)
			return 0;
		else if(this.totalAmount>p.getTotalAmount())
			return 1;
		else
			return -1;
	}
}
