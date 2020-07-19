package com.points.mall.common.utils;

import java.security.MessageDigest;

/**
 * Md5Utils
 *
 * @author chentudong
 * @date 2020/4/27 0:26
 * @since 1.0
 */
public class Md5Utils
{
    private static final int DEFAULT_SIZE = 16;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5sign(String source, String encode)
    {
        String result = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes(encode));
            byte[] tmp = md.digest();
            char[] str = new char[DEFAULT_SIZE * 2];
            int k = 0;
            for (int i = 0; i < DEFAULT_SIZE; i++)
            {
                byte byte0 = tmp[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
