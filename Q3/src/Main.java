import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Item> itemList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. Add items\n2. Search item by name\n3. Get item between price range\n4. Exit\nEnter your choice:");
        Integer choice = Integer.parseInt(br.readLine());
        do {
	        switch (choice) {
	            case 1:
	                System.out.println("Enter the number of items:");
	                Integer noOfItems = Integer.parseInt(br.readLine());
	                for (int i = 0; i < noOfItems; i++) {
	                    Item item = Item.createItem(br.readLine());
	                    itemList.add(item);
	                }
	                break;
	            case 2:
	                //fill the code
	            	System.out.println("Enter the name:");
	            	String name=br.readLine();
	            	Item item=Item.searchItemByName(name, itemList);
	            	if(item!=null){
	            		System.out.println("Item Detail");
	            		System.out.println("Item name: "+item.getName());
	            		System.out.println("Item code: "+item.getItemCode());
	            		System.out.println("Item Cost: "+item.getCost());
	            	}
	            	else
	            		System.out.println("Item "+name+" not found");
	            	break;
	            case 3:
	                //fill the code
	            	System.out.println("Enter the min and max cost:");
	            	Double min=Double.parseDouble(br.readLine());
	            	Double max=Double.parseDouble(br.readLine());
	            	List<Item> li=Item.findAllItemByPriceRange(itemList, min, max);
	            	if(li.isEmpty()){
	            		
	            	}else{
	            		System.out.format("%-10s %-10s %s\n", "Name", "Code", "Cost");
	            		for(Item it:li){
	            			System.out.print(it);
	            		}
	            	}
	            	break;
	            case 4:
	                //fill the code
	            	break;
	        }

	        System.out.println("1. Add items\n2. Search item by name\n3. Get item between price range\n4. Exit\nEnter your choice:");
	        choice = Integer.parseInt(br.readLine());
        }while(choice!=4);
    }

}
