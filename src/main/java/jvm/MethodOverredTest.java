package jvm;

/**
 * @author: wenqiang
 * @date: 2019-10-28 11:27
 */
public class MethodOverredTest {


    interface Customer {
        boolean isVIP();
    }

    class Merchant{
        public Number actionPrice(double price,Customer customer){
            return 1;
        }
    }

    class NaiveMerchant extends Merchant{

        @Override
        public Double actionPrice(double price, Customer customer) {
            return 1.1d;
        }
    }

}
