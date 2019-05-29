import java.util.List;

public class Item {
    
    //fill the code
	private Long id;
	private String name;
	private Double cost;
	private Integer quantity;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Item(Long id, String name, Double cost, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}
	public Item() {
		super();
	}
	public static Double calculateTotalBill(List<Item> itemList) {
        //fill the code
		Double total=0d;
		if(!itemList.isEmpty()){
			for(Item it:itemList){
				total+=(double)(it.getCost()*it.getQuantity());
			}
		}
		return total;
    }
    public static Double calculateTotalBill(List<Item> itemList, Integer deliveryType) {
        //fill the code
    	Double total=calculateTotalBill(itemList);
		if(deliveryType==1){
			total=total+(double)(total*0.15);
		}else if(deliveryType==2){
			total=total+(double)(total*0.08);
		}
		return total;
    }
    
}
