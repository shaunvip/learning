package hld;

import java.util.HashMap;
import java.util.Map;

public class URLService {
   static HashMap<String, String> shortToLong;
    public static void main(String[] args) {
        URLService u= new URLService();
      String[] u1=  {"https://medium.com/@sandeep4.verma/system-design-scalable-url-shortener-service-like-tinyurl-106f30f23a82",
              "https://console.dx.walmart.com/insights/team/metrics/plan?projectId=DX-03084&sso_redirect_ts=1667893174&teamId=3230&startDate=2022-05-12&endDate=2022-11-08&repoUrls=InternationalDA%2Fcalcpi-deviation-extract",
                "https://walmart.slack.com/ssb/signin_redirect?ssb_vid=.85cfe1fe0d27d2b99187687c649150e5&ssb_instance_id=282e7a1c-75e0-42e8-ac91-b8a95a9af7af&v=4.28.184&from_desktop_app=1"};
        for (String e:u1) {
            u.longToShort(e);
        }
        shortToLong.forEach((key, value) -> System.out.println(key + " " + value));
    }
    static Long COUNTER=100000000000L;
    String elements;
    URLService() {
        shortToLong = new HashMap<>();
        COUNTER = 100000000000L;
        elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    public String longToShort(String url) {
        String shorturl = base10ToBase62(COUNTER);
        shortToLong.put(shorturl, url);
        COUNTER++;
        return "http://tiny.url/" + shorturl;
    }
    public String shortToLong(String url) {
        url = url.substring("http://tiny.url/".length());
        return shortToLong.get(url);
    }

    public int base62ToBase10(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 62 + convert(s.charAt(i));
        }
        return n;

    }
    public int convert(char c) {
        if (c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
    public String base10ToBase62(Long n) {
        int tempn= (int) (n/62);
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt(tempn % 62));
            n /= 62;
        }
        while (sb.length() != 7) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}
