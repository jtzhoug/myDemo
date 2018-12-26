package com.zjt.controller;

import com.alibaba.fastjson.JSONObject;
import com.zjt.model.ClothItem;
import com.zjt.model.Result;
import com.zjt.repository.ClothItemRepository;
import com.zjt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhou.jingtao
 * @date created in 20:17 2018/11/18
 * @Description:
 */

@RequestMapping("/test")
@RestController
public class ClothItemController {

    @Autowired
    private ClothItemRepository clothItemRepository;

    @RequestMapping("/save")
    public void testSave(@RequestBody JSONObject jsonObject){

        String auditorName = jsonObject.getString("auditorName");
        Integer meetingId = jsonObject.getInteger("meetingId");
        String remark = jsonObject.getString("remark");

        ClothItem clothItem = new ClothItem();
        // clothItem.set(auditorName);
        clothItem.setMeetingId(meetingId);
        clothItem.setRemark(remark);
        clothItemRepository.save(clothItem);
    }


    @RequestMapping("/countLabel")
    public Result countLabel(){
        Integer serialNum =1;
        Integer meetingId = 1;

        List<String> stringList = new ArrayList<>();

        List<ClothItem> clothItems = clothItemRepository.findBySerialNumAndMeetingId(serialNum,meetingId);
        clothItems.stream().map(ClothItem :: getCheckedLabel).forEach(
                s -> stringList.addAll(Arrays.asList(s.split(",")))
        );
        Map<String,Long> map = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map finalMap = new LinkedHashMap();
        map.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(),e.getValue()));
        return ResultUtil.success(finalMap);
    }
}
