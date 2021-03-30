package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.17.59.70");
        assertTrue(ipLocation.contains("RU"));
    }

    @Test
    public void testInvalidIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.17.59.xxx");
        assertTrue(ipLocation.contains("RU"));
    }
}
