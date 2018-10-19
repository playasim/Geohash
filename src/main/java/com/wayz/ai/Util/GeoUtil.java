package com.wayz.ai.Util;

/**
 * @Author Martin Ma
 * @Date 2018/10/19
 **/
public class GeoUtil {

    final static
    char[] dict = {'0','1','2','3','4','5','6','7','8','9','b','c','d','e','f','g','h','j','k','m','n','p','q','r',
    's','t','u','v','w','x','y','z'};

    /*
    lat [-90,90]
    lon [-180,180]
     */
    public static String coordinate2geoHash(double lat, double lon) {
        String latstr = getLatfromCoor2Binary(lat);
        String lonstr = getLonfromCoor2Binary(lon);
        String binary = combineLatLon(latstr, lonstr);

        String result = convertBinary2Str(binary);
        return result;
    }

    public static String getLatfromCoor2Binary(double lat) {

        StringBuilder latstr = new StringBuilder();
        double high = 90;
        double low = -90;
        double mid = (high + low) / 2.0;

        int count = 15;
        while (count > 0) {
            if (lat > mid) {
                low = mid;
                latstr.append("1");
            } else {
                high = mid;
                latstr.append("0");
            }
            mid = (high + low) / 2.0;
            count --;
        }

        return latstr.toString();
    }

    public static String getLonfromCoor2Binary(double lon) {

        StringBuilder lonstr = new StringBuilder();
        double high = 180;
        double low = -180;
        double mid = (high + low) / 2.0;
        int count = 15;
        while (count > 0) {
            if (lon > mid) {
                low = mid;
                lonstr.append("1");
            } else {
                high = mid;
                lonstr.append("0");
            }
            mid = (high + low) / 2.0;
            count --;
        }

        return lonstr.toString();
    }

    /*
    偶数放经度，奇数放纬度
     */
    public static String combineLatLon(String lat, String lon) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lat.length(); i++) {
            stringBuilder.append(lon.charAt(i));
            stringBuilder.append(lat.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static String convertBinary2Str(String str) {
        int start = 0;
        int end = start + 5;
        StringBuilder stringBuilder = new StringBuilder();
        while (end <=str.length()) {
            String temp = str.substring(start, end);
            int position = Integer.valueOf(temp, 2);
            stringBuilder.append(dict[position]);
            start += 5;
            end = start + 5;
        }
        return stringBuilder.toString();
    }



}
