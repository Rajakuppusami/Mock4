import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
public class Main {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String couponCode;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the coupon code:");
        couponCode = br.readLine();
        System.out.println("1.Validate coupon code\n2.Check validity of coupon code\nEnter the choice:");
        //fill the code
        int choice=Integer.parseInt(br.readLine());
        if(choice==1){
        	if(validateCouponCode(couponCode)){
        		System.out.println("Coupon code validated");
        	}else{
        		System.out.println("Coupon code is invalid");
        	}
        }else if(choice==2){
        	System.out.println("Enter the bought date:");
        	String strDate = br.readLine();
        	Date boughtDate=sdf.parse(strDate);
        	if(checkValidityOfCouponCode(couponCode,boughtDate)){
        		System.out.println("Coupon code is valid");
        	}else{
        		System.out.println("The validity of coupon code is over ");
        	}
        }
    }
    
    public static boolean validateCouponCode(String couponCode) {
        //fill the code
    	if(couponCode.matches("^[A-Za-z]{1}[A-Za-z0-9]{1}[0-9]{2}[A-Za-z0-9]{5}[A-Za-z]{1}$")){
    		return true;
    	}
    	return false;
    }
    
    public static boolean checkValidityOfCouponCode(String couponCode, Date boughtDate) throws Exception {
        //fill the code
    	SimpleDateFormat sdfdd = new SimpleDateFormat("dd");
    	SimpleDateFormat sdfMM=new SimpleDateFormat("MM");
    	SimpleDateFormat sdfYYYY=new SimpleDateFormat("YYYY");
    	LocalDate bd= LocalDate.of(Integer.parseInt(sdfYYYY.format(boughtDate)), Integer.parseInt(sdfMM.format(boughtDate)), Integer.parseInt(sdfdd.format(boughtDate)));
    	if(validateCouponCode(couponCode)){
    		bd=bd.plusDays(Long.parseLong(couponCode.substring(2,4)));
    		LocalDate cur = LocalDate.of(2018, 01, 01);
    		long dif=ChronoUnit.DAYS.between(cur, bd);
    		//System.out.println(dif);
    		if(dif>0){
    			return true;
    		}
    	}
    	
		return false;
    }
    
}
