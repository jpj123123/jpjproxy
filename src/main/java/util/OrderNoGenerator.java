package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 2018/1/17
 * gpslw
 */
public class OrderNoGenerator {
    public static String getOrderNo(Long customerId){
        String customer = customerId.toString();
        Random random = new Random();
        int num = random.nextInt(10);
        if(customer.length()<8){
            customer = String.format("%08d",customerId);
        }
        customer = "O" + new Date().getTime() + customer+num ;
        return customer;
    }

    /**
     * 领券号
     * @param customerId
     * @return
     */
    public static String getVoucherNo(Long customerId){
        String customer = customerId.toString();
        Random random = new Random();
        int num = random.nextInt(10);
        if(customer.length()<8){
            customer = String.format("%08d",customerId);
        }
        customer = "V" + new Date().getTime() + customer+num ;
        return customer;
    }

    public static String getOrderNoDateFormat(Long customerId){
        String customer = customerId.toString();
        Random random = new Random();
        int num = random.nextInt(10);
        if(customer.length()<8){
            customer = String.format("%08d",customerId);
        }
        customer = "O" + getDateString() + customer+num ;
        return customer;
    }

    public static void main(String[] args) {
        System.out.println(getOrderNo(1L));
        System.out.println(getDateString());
        System.out.println(getOrderNoDateFormat(1L));
    }

    private static String getDateString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }

}
