package com.zjt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjt.model.Band;
import com.zjt.model.Result;
import com.zjt.model.ScoreCountVO;
import com.zjt.model.Student;
import com.zjt.repository.BandRepository;
import com.zjt.utils.ArrayUtils;
import com.zjt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhou.jingtao
 * @date created in 22:49 2018/11/21
 * @Description:
 */
@RequestMapping("/test")
@RestController
public class BandController {

    @Autowired
    private BandRepository bandRepository;

    @RequestMapping("/one")
    public Result test(){
        Band band = bandRepository.findById(1).get();
        String str = band.getBandRange();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Object[][] a = {{1,2},{2,2}};
        String s = ArrayUtils.ArraytoString(a);
        // System.out.println();
        return ResultUtil.success(s);
    }


    @RequestMapping("/band")
    public JSONObject testArray(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        Map<String,int[]> map = new HashMap<String, int[]>();
        int[][] list1 = {{1,2},{3,4}};



        JSONObject object = new JSONObject();
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1);
        jsonObject.put("name","波段一");
        jsonObject.put("value",list1);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","波段二");
        jsonObject2.put("value",jsonObject1);

        jsonArray.add(jsonObject);
        // jsonArray.add(jsonObject2);

        object.put("meetingId",111);
        object.put("meetingName","19春");
        object.put("data",jsonArray);

        return object;
    }

    @RequestMapping("/testGet")
    public String[] test2(@RequestBody JSONObject jsonObject){
        // JSONArray jsonArray = jsonObject.getJSONArray("data");
        // JSONObject jsonObject1 = jsonArray.getJSONObject(0);
        // JSONArray array = jsonObject1.getJSONArray("value");
        // return array.toJSONString();
        Band band =  bandRepository.findBySeries("NENO");
        String bandRange = band.getBandRange();
        Pattern p1 =Pattern.compile("(\\d{1,},\\d{1,})");
        Matcher m1 = p1.matcher(bandRange);
        while (m1.find()){
            String s = m1.group();
            System.out.println(s);
        }
        // JSONArray jsonArray = JSONArray.parseArray(bandRange);
        String[] s1 = bandRange.replace("],","]#").split("#");
        return  s1;
    }

    @RequestMapping("/testBand")
    public Result test3(@RequestBody JSONObject jsonObject){

        String series = jsonObject.getString("series");
        String band = jsonObject.getString("band");
        if (series.equals("全部") && band.equals("全部")){
            System.out.println("1");
        } else if (series.equals("全部") && !band.equals("全部") ){
            System.out.println("2");

        } else if (!series.equals("全部") && band.equals("全部")){
            System.out.println("3");
        } else {
            System.out.println("4");

        }
        return ResultUtil.success(111);
    }

    @RequestMapping("/testMap")
    public Result testMap(){
        Student student1 = new Student("ab", "12", "12", 1, 12, 100);
        Student student2 =new Student("abc", "12", "12", 1, 14, 100);
        Student student3 = new Student("abcd", "12", "12", 1, 12, 100);
        Student student4 =new Student("abcde", "12", "12", 1, 6, 100);
        List alist = new ArrayList();
        alist.add(student1);
        alist.add(student2);
        alist.add(student3);
        alist.add(student4);
List resultList = Arrays.asList(alist);
        List<Student> studentList = Arrays.asList(
                 new Student("ab", "12", "12", 1, 12, 100),
          new Student("abc", "12", "12", 1, 14, 100),
          new Student("abcd", "12", "12", 1, 12, 100),
          new Student("abcde", "12", "12", 1, 6, 100)
        );

       // Long result =  resultList.stream().map(student1 :: getAge ).reduce(Long::sum).get();
        List a = new ArrayList();
        Map<Integer,Long> collert = (Map<Integer, Long>) alist.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.counting()));
        System.out.println(collert.size());
        System.out.println(collert.get(12));
        System.out.println(collert.get(14));
        System.out.println(collert.get(6));
        for (Map.Entry entry : collert.entrySet()){
            ScoreCountVO scoreCountVO = new ScoreCountVO();
            scoreCountVO.setScore((Integer) entry.getKey());
            scoreCountVO.setScoresCounts((Long) entry.getValue());
            a.add(scoreCountVO);

        }

        return ResultUtil.success(a);

    }
}
