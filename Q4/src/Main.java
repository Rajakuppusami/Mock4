import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Item> itemList = new ArrayList<Item>();
        System.out.println("Enter the number of items:");
        Integer noOfItems = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < noOfItems ; i++) {
            String itemDetails = br.readLine();
            String[] splited = itemDetails.split(",");
            itemList.add(new Item(Long.parseLong(splited[0]), splited[1], Double.parseDouble(splited[2]), Integer.parseInt(splited[3])));
        }
        System.out.println("1.Store\n2.Online\nEnter the choice:");
        //fill the code
        Integer choice=Integer.parseInt(br.readLine());
        if(choice==1){
        	System.out.printf("Total amount:%.2f",Item.calculateTotalBill(itemList));
        }else if(choice==2){
        	System.out.println("1.One day delivery");
        	System.out.println("2.Normal delivery");
        	System.out.println("Enter delivery type:");
        	Integer deliveryType=Integer.parseInt(br.readLine());
        	System.out.printf("Total amount:%.2f",Item.calculateTotalBill(itemList, deliveryType));
        }
    }
}
