package spi;

import com.spi.service.Payment;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: wenqiang
 * @date: 2019-06-13 16:58
 *
 * SPI(service provider interface)
 * SPI实现可扩展和可插拔
 *
 */
public class SPICase {

    public static void main(String[] args) {
        //WxPay
        Payment wxPay = getPayment("com.spi.provider.WxPay");
        wxPay.pay();
        //ZfbPay
        Payment zfbPay = getPayment("com.spi.provider.ZfbPay");
        zfbPay.pay();
    }

    private static Payment getPayment(String className){
        ServiceLoader<Payment> serviceLoader = ServiceLoader.load(Payment.class);
        Iterator<Payment> it = serviceLoader.iterator();
        while (it.hasNext()){
            Payment payment = it.next();
            if(payment.getClass().getName().equals(className)){
                return payment;
            }
        }
        return null;
    }
}
