package com.aubrun.eric.projet7.springmvc.business.security;

import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieGenerator {

    public static final String HEADER = "access_token";


    private CookieGenerator(){}

    /**
     * This method generate a cookie with token as value
     *
     * @param token access token to store
     * @return a cookie
     */
    public static Cookie generateCookie (String token){

        Cookie cookie = new Cookie(HEADER, token);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(999999); // 12 days
        cookie.setDomain("localhost");
        cookie.setPath("/");

        return cookie;
    }

    /**
     * This method delete cookie stored
     *
     * @param httpServletResponse the HttpServletResponse with cookie to delete
     */
    public static void clear(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie(HEADER, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

    /**
     * This method delete cookie stored
     *
     * @param httpServletRequest HttpServletResponse with cookie to use
     * @param name the name of the value to find
     */
    public static String getValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }

    /*public static String getUsernameFromJWT(String token){
        String username = JwtToken.decode(token).getSubject();
        return username;
    }

    public static Integer getUserIdFromJWT(String token){
        Integer userId = JwtToken.decode(token).getClaim("userId").asInt();
        return userId;
    }*/
}