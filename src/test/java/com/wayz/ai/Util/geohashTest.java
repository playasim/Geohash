package com.wayz.ai.Util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Martin Ma
 * @Date 2018/10/19
 **/
public class geohashTest {

    private static final double lat = 30.280245;
    private static final double lon = 120.027162;
    @Test
    public void coordinate2BinaryTest() {
        Assert.assertEquals("101010110001000", GeoUtil.getLatfromCoor2Binary(lat));
        Assert.assertEquals("110101010101101", GeoUtil.getLonfromCoor2Binary(lon));
    }

    @Test
    public void combineLatLonBin() {
        String latstr =  GeoUtil.getLatfromCoor2Binary(lat);
        String lonstr = GeoUtil.getLonfromCoor2Binary(lon);

        Assert.assertEquals("101010110001000", latstr);
        Assert.assertEquals("110101010101101", lonstr);

        String result = GeoUtil.combineLatLon(latstr, lonstr);

        Assert.assertEquals("111001100110011100100011100010", result);
    }

    @Test
    public void binary2GeoHash() {
        String result = GeoUtil.convertBinary2Str("111001100110011100100011100010");
        Assert.assertEquals("wtmk72", result);
    }

    @Test
    public void finalTest() {
        String result = GeoUtil.coordinate2geoHash(lat, lon);
        Assert.assertEquals("wtmk72", result);
    }
}
