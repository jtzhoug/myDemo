package com.zjt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhou.jingtao
 * @date created in 17:35 2018/8/21
 * @Description:
 */
public class TimeUtils {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMMddHH:mm:ss");

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static Logger logger = LoggerFactory.getLogger(TimeUtils.class);


    /**
     * 获取当前日期
     * 输出如2018-08-22
     */
    public static String getNowDate(){
        LocalDate ld = LocalDate.now();
        String localDate = ld.format(dateFormatter);
        return localDate;
    }

    /**
     * 获取当前日期
     * 输出格式 yyyyMMdd
     */
    public static String getNowDateFormatter(){
        LocalDate ld = LocalDate.now();
        String nowDay = ld.format(dateFormatter1);
        return nowDay;
    }


    /**
     * 当前日期推迟几天
     */
    public static String getDelayDates(int dates){
        LocalDate ls = LocalDate.now().plusDays(dates);
        String delayDate = ls.format(dateFormatter);
        return delayDate;
    }

    /**
     * 当前日期推迟几周
     */
    public static String getDelayWeeks(int weeks){
        LocalDate ls = LocalDate.now().plusWeeks(weeks);
        String delayWeeks = ls.format(dateFormatter);
        return delayWeeks;
    }

    /**
     * 当前日期推迟几月
     */
    public static String getDelayMonths(int months){
        LocalDate ls = LocalDate.now().plusMonths(months);
        String delayMonth = ls.format(dateFormatter);
        return delayMonth;
    }

    /**
     * 当前日期推迟几年
     */
    public static String getDelayYears(int years){
        LocalDate ld = LocalDate.now().plusYears(years);
        String delayYear = ld.format(dateFormatter);
        return delayYear;
    }

    /**
     * 计算当年第n天是几月几号
     */
    public static String getDayOfYear(int n){
        LocalDate ld = LocalDate.now().withDayOfYear(n);
        String dayOfYear = ld.format(dateFormatter);
        return dayOfYear;
    }

    /**
     * 字符串转为日期
     */
    public static LocalDate stringToLocalDate(String dateStr){
        LocalDate ld = null;
        try {
            ld = LocalDate.parse(dateStr,dateFormatter);
        } catch (Exception e){
            logger.error("dateStr = "+dateStr+" can not change to LocalDate");
            logger.error(e.getMessage());
        }
        return ld;
    }

    /**
     * 字符串转为时间
     */
    public static LocalTime stringToTime(String dateStr){
        LocalTime ld = null;
        try {
            ld = LocalTime.parse(dateStr,timeFormatter);
        } catch (Exception e){
            logger.error("dateStr = "+dateStr+" can not change to LocalDate");
            logger.error(e.getMessage());
        }
        return ld;
    }

    /**
     *获取当前日期 精确到毫秒
     * 输出格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime(){
        LocalDateTime ldt = LocalDateTime.now();
        String localDateTime = ldt.format(dateTimeFormatter);
        return localDateTime;
    }

    /**
     * 获取当前日期时间
     * 输出格式 yyyyMMddHH:mm:ss
     */
    public static String getNowTimeFormatter(){

        String ldt = dateTimeFormatter1.format(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        return ldt;
    }


    /**
     * 通过字符串获取时间
     * 输出格式为 yyyy-MM-dd HH:mm:ss
     */
    public static LocalDateTime stringToLocalDateTime(String ldtStr){
        LocalDateTime resultDate = null;
        try {
             resultDate = LocalDateTime.parse(ldtStr,dateTimeFormatter);
        } catch (Exception e){
            logger.error("ldtStr = "+ldtStr+" can not change to LocalDateTime");
            logger.error(e.getMessage());
        }
        return resultDate;

    }

    /**
     * 两个日期之间的天，月，年差值
     */
    public static Map period(String date1, String date2){
        LocalDate ld1 = stringToLocalDate(date1);
        LocalDate ld2 = stringToLocalDate(date2);
        Period period = Period.between(ld1, ld2);
        Map map = new HashMap();
        map.put("periodDays",period.getDays());
        map.put("periodMonths",period.getMonths());
        map.put("periodYears",period.getYears());
        return map;
    }


    public static void main(String[] args) {
        LocalTime onLimitDate = LocalTime.parse("09:30:00", timeFormatter);
        System.out.println(onLimitDate);
        System.out.println(stringToTime("09:30:00"));
    }
}
