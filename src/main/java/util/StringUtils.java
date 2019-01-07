package util;

import java.io.UnsupportedEncodingException;

/**
 * Created by lyl on 2016/9/11.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";

    /**
     * 字符串分隔符
     */
    public static final char DEFAULT_DELIMITER_CHAR = ',';

    /**
     * 注释字符串
     */
    public static final char DEFAULT_QUOTE_CHAR = '"';

    public StringUtils() {
    }

    public static boolean hasText(String str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String clean(String in) {
        String out = in;

        if (in != null) {
            out = in.trim();
            if (out.equals(EMPTY_STRING)) {
                out = null;
            }
        }

        return out;
    }

    public static boolean hasLength(String str) {
        return (str != null && str.length() > 0);
    }

    public static String replaceWithBlank(String sourceString, String replacedSymbol) {
        return sourceString.replace(replacedSymbol, "");
    }

    public static boolean isRangeLength(String s, int maxLength) {
        return getStringLength(s) > maxLength;
    }

    public static int getStringLength(String s) {
        int valueLength = 0;
        if(s == null) {
            return valueLength;
        } else {
            String chinese = "[一-龥]";

            for(int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i, i + 1);
                if(temp.matches(chinese)) {
                    valueLength += 2;
                } else {
                    ++valueLength;
                }
            }

            return valueLength;
        }
    }

    public static String full2HalfChange(String QJstr) {
        if(QJstr == null) {
            return null;
        } else {
            StringBuffer outStrBuf = new StringBuffer("");
            String Tstr = "";
            Object b = null;

            for(int i = 0; i < QJstr.length(); ++i) {
                Tstr = QJstr.substring(i, i + 1);

                try {
                    if(Tstr.equals("　")) {
                        outStrBuf.append(" ");
                    } else {
                        byte[] var7 = Tstr.getBytes("unicode");
                        if(var7[2] == -1) {
                            var7[3] = (byte)(var7[3] + 32);
                            var7[2] = 0;
                            outStrBuf.append(new String(var7, "unicode"));
                        } else {
                            outStrBuf.append(Tstr);
                        }
                    }
                } catch (UnsupportedEncodingException var6) {
                    outStrBuf.append(Tstr);
                }
            }

            return outStrBuf.toString();
        }
    }

    /**
     * Comment is created by lyl on 2017/11/2 上午10:47.
     *
     * 拼接字符串
     */
    public static String concat(String str1, String str2){
        /**
         * 没有多线程调用此方法 无需考虑
         */
        return new StringBuilder()
                .append(str1)
                .append(str2)
                .toString();
    }

    /**
     * 格式化姓名
     * @param name
     * @return
     */
    public static String formatName(String name){
        return name.replaceAll("^\\s*|\\s*$", "").replaceAll("\\s+", " ");
    }

    /**
     * 格式化印尼手机号
     * @param phoneNo
     * @return
     */
    public static String formatPhoneNo(String phoneNo){
        if(isBlank(phoneNo))
            return phoneNo;
        return phoneNo.replaceAll("[+ -]*", "").replaceAll("^(62)?(0)?([8]\\d{4,12})$", "$3");
    }

}
