package util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.*;

/**
 * Created by lyl on 2016/9/13.
 */
//@Slf4j
public class SerializeUtils extends org.apache.commons.lang3.ObjectUtils {

    /**
     * 序列化对象
     */
    public static byte[] serialize(Object object) {
        Assert.notNull(object,"object can not be null!");
        if(!(object instanceof Serializable)) {
            throw new IllegalArgumentException("requires a Serializable payload " + "but received an object of type [" + object.getClass().getName() + "]");
        }
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
           // log.error("serialize fail",e);
        }
        return null;
    }

    /**
     * 反序列化对象
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            if (bytes != null && bytes.length > 0){
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            }
        } catch (Exception e) {
            //log.error("unserialize fail",e);
        }
        return null;
    }
}
