package com.datawisher.misc.pattern;

import java.util.regex.Pattern;

/**
 * @author h407644
 * @date 2022-04-29
 */
public class RegPattern {

    private static final Pattern DOMAIN_PATTERN = Pattern.compile("[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?");


    public static void main(String[] args) {
        String str = "mom.nacos";
        boolean matches = DOMAIN_PATTERN.matcher(str).matches();
        System.out.println("matches = " + matches);
    }
}
