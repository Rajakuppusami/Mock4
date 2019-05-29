import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<String, Integer>();
        System.out.println("Enter the number of purchase:");
        Integer purchaseCount = Integer.parseInt(buff.readLine());
        //fill the code
        for (int i = 0; i < purchaseCount; i++) {
        	String purchaseDetail=buff.readLine();
			Purchase.obtainPurchaseWithItem(map, purchaseDetail);
		}
        System.out.format("%-15s %s\n","Item name","Quantity");
        //fill the code
        for(Map.Entry<String,Integer> entry:map.entrySet()){
        	System.out.format("%-15s %s\n",entry.getKey(),entry.getValue());
        }
    }
}
