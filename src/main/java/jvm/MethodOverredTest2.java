package jvm;

import com.sun.tools.doclets.internal.toolkit.util.ClassUseMapper;

/**
 * @author: wenqiang
 * @date: 2019-10-28 11:27
 */
public class MethodOverredTest2 {


    interface Customer {
        boolean isVIP();
    }

    class Merchant<T extends Customer>{
        public double actionPrice(double price,Customer customer){
            return 1d;
        }
    }

    class NaiveMerchant extends Merchant<VIP>{

        @Override
        public double actionPrice(double price, Customer customer) {
            return 1.1d;
        }
    }

    class VIP implements Customer{

        @Override
        public boolean isVIP() {
            return false;
        }
    }
}
