package guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2020-09-03 14:24
 */
public class BloomFilterDemo {

    public static void main(String[] args) {

        StandAloneTest();
    }

    //单机版
    private static void StandAloneTest(){
        BloomFilter<Long> bloomFilter = BloomFilter.create(Funnels.longFunnel(),1000L);

        for (long i = 0; i < 1000; i++){
            bloomFilter.put(i);
        }

        for(long i = 0; i < 1000; i++){
            if(!bloomFilter.mightContain(i)){
                System.out.println(i + "逃脱了");
            }
        }

        List<Long> list = new ArrayList<>(1000);
        for (long i = 11000; i < 21000; i++){
            if(bloomFilter.mightContain(i)){
                list.add(i);
            }
        }
        System.out.println("误伤的数量：" + list.size());

    }
}
