package com.zjt.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjt.model.Auditor;
import com.zjt.model.Cloth;
import com.zjt.model.ClothItem;
import com.zjt.model.Result;
import com.zjt.repository.AuditorRepository;
import com.zjt.repository.ClothItemRepository;
import com.zjt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 16:55 2018/11/18
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class AuditorController {

    @Autowired
    private AuditorRepository auditorRepository;


    @Autowired
    private ClothItemRepository clothItemRepository;


    @RequestMapping("/test")
    public Result test() throws Exception {
        List<Object> list = new ArrayList<>();
        List<Object[]> auditors = clothItemRepository.findClothItemAndAuditorRole(1, 1);

        List<Cloth> cloths = castEntity(auditors,Cloth.class);
        // for (int i = 0; i < auditors.size(); i++) {
        //     Cloth clothItem = (Cloth) auditors.get(i);
        //     list.add(clothItem);
        // }
        return ResultUtil.success(cloths);
    }


    @RequestMapping("/test1")
    public Result test1() {
        Object auditors = auditorRepository.findAll();
        return ResultUtil.success(auditors);
    }

    @RequestMapping("/saveAuditor")
    public void testSave(@RequestBody JSONObject jsonObject) {

        String auditorName = jsonObject.getString("auditorName");
        String auditorRole = jsonObject.getString("auditorRole");
        Integer meetingId = jsonObject.getInteger("meetingId");

        Auditor auditor = new Auditor();
        auditor.setMeetingId(meetingId);
        auditor.setMeetingId(meetingId);
        auditor.setAuditorName(auditorName);
        auditorRepository.save(auditor);


    }

    public static <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) throws Exception {
        List<T> returnList = new ArrayList<T>();
        Object[] co = list.get(0);
        Class[] c2 = new Class[co.length];

        //确定构造方法
        for (int i = 0; i < co.length; i++) {
            c2[i] = co[i].getClass();
        }

        for (Object[] o : list) {
            Constructor<T> constructor = clazz.getConstructor(c2);
            returnList.add(constructor.newInstance(o));
        }

        return returnList;
    }
}
