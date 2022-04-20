package com.datawisher.misc.pojie;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author h407644
 * @date 2022-04-19
 */
public class StepOne {

    public static byte[] a(String var0, String var1) {
        try {
            byte[] var2 = Base64.getDecoder().decode(var1);
            byte[] var3 = Base64.getDecoder().decode(var0);
            KeyFactory var4 = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec var5 = new X509EncodedKeySpec(var3);
            PublicKey var6 = var4.generatePublic(var5);
            Cipher var7 = Cipher.getInstance(var4.getAlgorithm());
            var7.init(2, var6);
            return var7.doFinal(var2);
        } catch (Exception var8) {
            return null;
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] temp;

        temp = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHEhhLwdDhZ57SlLt/5JWFeGRy4r+NKgbA0VwkCXs7p0w1bNgKlRJOzUfjg6kMi4ygkVNNPWrXIhcdMniTbcHmawawLTa3cRM1jNdG0xg808KKNVdDilFHOFQz8AF6cvLDpsWkqzmoe2+64v0zlWbp5EpYxMMRxOwSMVKxLB8BwIDAQAB",
                "U5VwTnDVppT0puHtkE/Uj3/K4JUu+7l0Qa2Q0BRGCucOyujbPZYFmQEu76sx0fxnXA4OK8TgoaUXWaU3lnWm3skMMel6Q/jRJn8LzsP4FE7Q/g4mTJYU3WqxxRCzRNtQqgtFq/St6ujClGeuaxwIrWUB5HqVbaRoDJoRZ5ecl+0=");
        String d = new String(temp, "UTF-8");
        System.out.println("d = " + d);

        temp = StepOne.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHEhhLwdDhZ57SlLt/5JWFeGRy4r+NKgbA0VwkCXs7p0w1bNgKlRJOzUfjg6kMi4ygkVNNPWrXIhcdMniTbcHmawawLTa3cRM1jNdG0xg808KKNVdDilFHOFQz8AF6cvLDpsWkqzmoe2+64v0zlWbp5EpYxMMRxOwSMVKxLB8BwIDAQAB",
                "LVuEjlAGl2JzUyxk4if+PICodE5wcpHs59W21jayXfyWVB8e2ctlf8y4gFsp2Df0HEQSpUyd4cBDhGIKr5rNZ7m/60S26z54QCqAIcEpOWBuhDg8OwTVD3WpN8r4jIVxMmUQEEeWY/hdikZKjh8ASrrGoGbNvxxcquPYuyXx1R8=");
        String e = new String(temp, "UTF-8");
        System.out.println("e = " + e);

        temp = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHEhhLwdDhZ57SlLt/5JWFeGRy4r+NKgbA0VwkCXs7p0w1bNgKlRJOzUfjg6kMi4ygkVNNPWrXIhcdMniTbcHmawawLTa3cRM1jNdG0xg808KKNVdDilFHOFQz8AF6cvLDpsWkqzmoe2+64v0zlWbp5EpYxMMRxOwSMVKxLB8BwIDAQAB", "HwvseLgXb0ADdzRJc1GjH684ejHzHA2CvsU3DIIfceB1WzQlQ9pk9Xvp8U6X6SZZCXJGfUGO0ufvE6vRC2mNfYtaZBXcissamXmFft+8arpmCHB3NcwPwcWDnFmmjz5vWCWSeFN4pgwkxTzBZCDCedVnQfe69k+ztW4mQ5nkVcQ=");
        String f = new String(temp, "UTF-8");
        System.out.println("f = " + f);

        temp = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHEhhLwdDhZ57SlLt/5JWFeGRy4r+NKgbA0VwkCXs7p0w1bNgKlRJOzUfjg6kMi4ygkVNNPWrXIhcdMniTbcHmawawLTa3cRM1jNdG0xg808KKNVdDilFHOFQz8AF6cvLDpsWkqzmoe2+64v0zlWbp5EpYxMMRxOwSMVKxLB8BwIDAQAB", "qeRqo/rXGiHD4rcSAJ07ZlSIT8mKBltrDmOq/XgOoadOr28QK+fSIq/hAwDP3AKQv5eWMHQ+1iHxluJY30jVoyW6UK+2RqCrTx5cDF45/gP+8y5Les0JJUy0tQ7QvNLgRGiM6S4lSyBtBK7TQwJA04pyorNNN0jjaH42k2wP6Wk=");
        String g = new String(temp, "UTF-8");
        System.out.println("g = " + g);

        temp = a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxHEhhLwdDhZ57SlLt/5JWFeGRy4r+NKgbA0VwkCXs7p0w1bNgKlRJOzUfjg6kMi4ygkVNNPWrXIhcdMniTbcHmawawLTa3cRM1jNdG0xg808KKNVdDilFHOFQz8AF6cvLDpsWkqzmoe2+64v0zlWbp5EpYxMMRxOwSMVKxLB8BwIDAQAB", "Hpe2Y2xbC9O5/UTpTy7vo1b/uVB2TlRpshb1pTsOCdR+DJbrjCktyA37LCrUXaeMioqwmwkZqlg8cQKErWjhUKPjDN45o7wcCnYxmToc7rds9LTWGRszoTdzanz7LiIm0b6Nn7yRMZMKnkwYga+PIT9gqUsI0CLscU8XKN7HZcs=");
        String h = new String(temp, "UTF-8");
        System.out.println("h = " + h);
    }
}
