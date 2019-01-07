package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lyl on 2015-06-17.
 */
public class RegexUtils {

    private static final String ERROR_PATTERN = "^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$";
    public static final String PHONE_REGEX = "^[0-9]{6,20}$";

    /**
     * check is matched by input pattern
     *
     * @param str
     * @param pattern
     * @return
     */
    public static boolean isMatched(String str, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(str);
        return matcher.matches();
    }

    /**
     * check is error code
     *
     * @param errorCode
     * @return
     */
    public static boolean isErrorCode(String errorCode){
        return isMatched(errorCode,ERROR_PATTERN);
    }

    /**
     * 检查表情符
     * @param content
     * @return
     */
    public static boolean hasEmoji(String content){

        Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]");
        Matcher matcher = pattern.matcher(content);
        if(matcher .find()){
            return true;
        }
        return false;
    }

}
