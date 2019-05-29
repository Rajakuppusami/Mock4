import java.util.ArrayList;
import java.util.List;

public class Item {

    //fill the code
	private Long id;
	private String name;
	private String itemCode;
	private Double cost;
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
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Item(Long id, String name, String itemCode, Double cost) {
		super();
		this.id = id;
		this.name = name;
		this.itemCode = itemCode;
		this.cost = cost;
	}
	
	public Item() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %s\n", this.name,this.itemCode,this.cost);
	}
	public static Item createItem(String itemDetail) {
        //fill the code
		String[] item=itemDetail.split(",");
		Item i=new Item(Long.parseLong(item[0]), item[1], item[2], Double.parseDouble(item[3]));
		return i;
    }
    
    public static Item searchItemByName(String itemName, List<Item> itemList) {
        //fill the code
    	for(Item it:itemList){
    		if(it.getName().equals(itemName)){
    			return it;
    		}
    	}
    	return null;
    }
    
    public static List<Item> findAllItemByPriceRange(List<Item> itemList, Double minRate, Double maxRate) {
        //fill the code
    	List<Item> li=new ArrayList<Item>();
    	for(Item it:itemList){
    		if(it.getCost()>=minRate && it.getCost()<=maxRate){
    			li.add(it);
    		}
    	}
    	return li;
    }
    
}
