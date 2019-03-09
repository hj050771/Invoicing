package com.dj.invoi.test;

import org.junit.Test;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest {

    public static void setCookie(HttpServletRequest request, HttpServletResponse response,
                                   String cookieName,String cookieValue) {
        Cookie cookie = new Cookie(cookieName,cookieValue);
        response.addCookie(cookie);
    }

    public static String getCookieValue(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        String retValue = null;
        for (int i = 0; i <cookies.length ; i++) {
            retValue = cookies[i].getValue();
            System.out.println(retValue);
        }
        return retValue;
    }

    @Test
    public void test(){
      //  setCookie(request,response,"test","hello");
    }
    @Test
    public void test1(){
     //   getCookieValue(request,"test");
    }
}
