package kaikeba.zhibo0704;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * @author: wenqiang
 * @date: 2020-07-03 21:12
 *
 * 安全相关的辅助类
 */
public class HashFuncUtil {


    /**
     * md5
     * @param msg
     * @return
     */
    public static String md5(String msg){
        if(StringUtils.isEmpty(msg)){
            return null;
        }
        MD5Digest md5Digest = new MD5Digest();
        byte[] msgBytes = msg.getBytes();
        md5Digest.update(msgBytes,0,msgBytes.length);
        byte[] retBytes = new byte[md5Digest.getDigestSize()];
        md5Digest.doFinal(retBytes,0);
        return new String(Hex.encode(retBytes));
    }

    /**
     * sha256
     * @param msg
     * @return
     */
    public static String sha256(String msg){
        if(StringUtils.isEmpty(msg)){
            return null;
        }
        SHA256Digest sha256Digest = new SHA256Digest();
        byte[] msgBytes = msg.getBytes();
        sha256Digest.update(msgBytes,0,msgBytes.length);
        byte[] retBytes = new byte[sha256Digest.getDigestSize()];
        sha256Digest.doFinal(retBytes,0);
        return new String(Hex.encode(retBytes));
    }


}
