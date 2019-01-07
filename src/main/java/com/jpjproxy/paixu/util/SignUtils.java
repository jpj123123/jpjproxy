package com.jpjproxy.paixu.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SignUtils {

    private static final String objectClass = "java.lang.Object";

    /**
       私钥文件路径
	 */
    private static final String privateKey= "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIIH4XALpMDMozLX3/mqvyVg8zVnJOz6vr+T94xrJ9s0uyJBum8ZExdWww/Zq3Brsx7OHV5MredXU8gEucxeyd9x6O8fxX8g249FVER/0kwjUxUfYgqFSyKKQSjGGXQslIzzKvRtCYgfRVBAI6vXZExJBJVyFWXexiBc/gMk8mIZAgMBAAECgYAvGJ2dkIoOzs+5ZZkY+7AZ4MCWMhKcxsD58KTztggMjE/PO5FEFgflJyalgghnQorw+GSIuCswpF+TDasiC58AC+DYA/jodygEHPXlVObq4D2otYj6+r0AFblTWtjnnfe6l4+eRXJ2llVPnAQpntFNV2vCcH0FApSgAZ7PD+KGkQJBAMSK/saq7jzmKDZoV/mgjp7MhhcTxQvw5PLM0lspOMx7FxBOIz/eNq9/T9hz9Aj+acU10uiAHRxVvgL4fAD0iLUCQQCpXfCkKAgSujDal+gjDqjaKY+9/Z3hZ6ttcWn9iLmG9BtEzCrGug4kLvtgMYG987FvngkUFokH4DS6pSLmEcZVAkA3naFktF+/6dz9MF+cqrtQ4k0bYKPEskEHF8B6vVpuOnKXUZUV8JqG5L7CYGVw2hUyEf4Bfqc+KmEfVBM67fd1AkBzw3TnD0GtYzxfPTN7Otro+z131DEkz1JaJQoYNGrzNkipNpAKc0OVMdO6BTy0FCx0qWV1KI4TJwmDhbob3YxdAkEAhDhB0SE6OnZayGK3CtfBz2n4ZGFIAV8sQ7+LbCfn1wOfheMSHhyK4QuIf3K4Ha+GanNpmK4Q5Vrn9GGbpobNbQ==";


    final public static List<String> toArray(Object target){

        List<String> res = new ArrayList<String>();
        Class thisClass = target.getClass();
        Field[] fields = new Field[0];
        while (!objectClass.equals(thisClass.getName())) {
            Field[] fieldTemp = thisClass.getDeclaredFields();
            thisClass = thisClass.getSuperclass();
            fields = ArrayUtils.addAll(fields, fieldTemp);
        }
        for (Field field : fields) {
            Object obj;
            try {
                field.setAccessible(true);
                obj = field.get(target);
                if(field.getGenericType() instanceof ParameterizedType){
                    ParameterizedType pt = (ParameterizedType) field.getGenericType();
                    if(pt.getRawType().equals(List.class)){
                        for(Object items : (List)obj){
                            res.addAll(toArray(items));
                        }
                    }
                } else if (obj != null && StringUtils.isNotEmpty(obj.toString())) {
                    if("sign".equals(field.getName())
                            ||"riskData".equals(field.getName())
                            ||"log".equals(field.getName())
                            ||"serialVersionUID".equals(field.getName()))
                        continue;
                    res.add(field.getName() + obj.toString());
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    final public static String getSign(Object object){
        List<String> requestMap = SignUtils.toArray(object);
        //私钥加密
        String sign = SignatrueUtil.getSign(requestMap,privateKey);
        return sign;
    }

    /**
     * @param object
     * @return
     */
    final public static String getSlpSign(Object object){
        List<String> requestMap = SignUtils.toArray(object);
        //私钥加密
        String sign = SignatrueUtil.getSign(requestMap,privateKey);
        return sign;
    }
}
