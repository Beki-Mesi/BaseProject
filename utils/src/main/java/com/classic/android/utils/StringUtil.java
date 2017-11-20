package com.classic.android.utils;

/**
 * 应用名称: BaseProject
 * 包 名 称: com.classic.android.utils
 *
 * 文件描述: 字符串工具类
 * 创 建 人: 续写经典
 * 创建时间: 2015/11/4 17:26
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class StringUtil {

    private StringUtil() { }

    /**
     * 描述：将null转化为“”.
     *
     * @param str 指定的字符串
     * @return 字符串的String类型
     */
    public static String parseEmpty(String str) {
        if (str == null || "null".equals(str.trim())) {
            str = "";
        }
        return str.trim();
    }

    /**
     * 描述：判断一个字符串是否为null或空值.
     *
     * @param str 指定的字符串
     * @return true or false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 描述：是否只是字母和数字.
     *
     * @param str 指定的字符串
     * @return 是否只是字母和数字:是为true，否则false
     */
    public static Boolean isNumberLetter(String str) {
        Boolean isNoLetter = false;
        String expr = "^[A-Za-z0-9]+$";
        if (str.matches(expr)) {
            isNoLetter = true;
        }
        return isNoLetter;
    }

    /**
     * 描述：判断字符串是否全是数字.
     *
     * @param str 指定的字符串
     * @return 是否只是数字:是为true，否则false
     */
    public static Boolean isNumber(String str) {
        Boolean isNumber = false;
        String expr = "^[0-9]+$";
        if (str.matches(expr)) {
            isNumber = true;
        }
        return isNumber;
    }

    /**
     * 描述：是否是中文.
     *
     * @param str 指定的字符串
     * @return 是否是中文:是为true，否则false
     */
    public static Boolean isChinese(String str) {
        Boolean isChinese = true;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            //获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                //获取一个字符
                String temp = str.substring(i, i + 1);
                //判断是否为中文字符
                if (!temp.matches(chinese)) {
                    isChinese = false;
                }
            }
        }
        return isChinese;
    }

    /**
     * 描述：是否包含中文.
     *
     * @param str 指定的字符串
     * @return 是否包含中文:是为true，否则false
     */
    public static Boolean isContainChinese(String str) {
        Boolean isChinese = false;
        String chinese = "[\u0391-\uFFE5]";
        if (!isEmpty(str)) {
            //获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
            for (int i = 0; i < str.length(); i++) {
                //获取一个字符
                String temp = str.substring(i, i + 1);
                //判断是否为中文字符
                if (temp.matches(chinese)) {
                    isChinese = true;
                }
            }
        }
        return isChinese;
    }

    /**
     * 检测String是否全是中文
     */
    public static boolean checkNameChinese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();

        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }

        return res;
    }

    /**
     * 判定输入汉字是否是中文
     */
    public static boolean isChinese(char c) {
        for (char param : chineseParam) {
            if (param == c) {
                return false;
            }
        }
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(c);
        return (unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ||
                unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS ||
                unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A ||
                unicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION ||
                unicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION ||
                unicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
    }

    private static char[] chineseParam = new char[]{'」', '，', '。', '？', '…', '：', '～', '【',
            '＃', '、', '％', '＊', '＆', '＄', '（', '‘', '’', '“', '”', '『', '〔', '｛', '【', '￥',
            '￡', '‖', '〖', '《', '「', '》', '〗', '】', '｝', '〕', '』', '”', '）', '！', '；', '—'};
}
