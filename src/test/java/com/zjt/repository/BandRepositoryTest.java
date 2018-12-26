package com.zjt.repository;

import com.zjt.model.Band;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhou.jingtao
 * @date created in 13:30 2018/11/22
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BandRepositoryTest {

    @Autowired
    private BandRepository bandRepository;
    @Test
    public void findBySeries() throws Exception {
        String series = "NENO";
        Band band = bandRepository.findBySeries(series);
        String bandRange = band.getBandRange();
        System.out.println(bandRange);


        String[] strings = bandRange.split("[ , ]");
        System.out.println(strings);
        System.out.println(strings[0] + "2" + strings[1]);

        String str = "aaa,bbb,cccc";
        String[] str2 = str.split(",");
        System.out.println(str2);
    }

}