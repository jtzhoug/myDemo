package com.zjt.controller;

import com.zjt.enums.ResultEnum;
import com.zjt.model.Result;
import com.zjt.model.Student;
import com.zjt.repository.StudentRepository;
import com.zjt.repository.UserInfoRepository;
import com.zjt.service.StudentService;
import com.zjt.utils.ExcelImportUtils;
import com.zjt.utils.ResultUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhou.jingtao
 * @date created in 22:05 2018/10/4
 * @Description:
 */

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    UserInfoRepository userInfoRepository;





    /**
     * test
     */
    // @RequestMapping("/test")
    // public Result findTest(){
    //     List<MyUserInfo> userInfoList = userInfoRepository.findAll();
    //     List list = new ArrayList();
    //     for (MyUserInfo user : userInfoList){
    //         Integer userId = user.getUid();
    //         List<Student> studentList = studentRepository.findStudentByUserId(userId);
    //         user.setStudent(studentList);
    //         list.add(user);
    //     }
    //     // List<Student> studentList = studentRepository.findStudentByUserId(userId);
    //     return ResultUtil.success(list);
    // }


    /**
     * 所有信息
     */
    @CrossOrigin
    @GetMapping("/students")
    public Result findAll() {
        return ResultUtil.success(studentService.getStudentList());
    }

    /**
     * 单个信息
     */
    // @PostMapping("/student/{id}")
    // public Result findOne(@PathVariable("id") Integer id) {
    //     try {
    //         Student student = studentService.getStudent(id);
    //         return ResultUtil.success(student);
    //     } catch (Exception e) {
    //         throw new MyExpection(ResultEnum.STUDENT_NOT_EXIT);
    //     }
    //     // return ResultUtil.success(studentService.getStudent(id));
    // }

    @GetMapping("/student/{id}")
    public Student findOne(@PathVariable("id") Integer id) {
        Student student = studentService.getStudent(id);
        // student.setName(StringEscapeUtils.unescapeJavaScript(student.getName()));
        return student;
        // return ResultUtil.success(studentService.getStudent(id));
    }

    /**
     * 单个信息
     */
    // @GetMapping("/students/name")
    // public Result findOneStudent(HttpServletRequest request, HttpServletResponse response) {
    //     String name = request.getParameter("name");
    //     // Student student = studentRepository.findStudentByUserId(name);
    //     return ResultUtil.success(student);
    //
    // }


    /**
     * 保存
     */
    @PostMapping("/student")
    public Student save(Student student) {
        Map map = new HashMap();
        return studentService.addStudent(student);
    }

    /**
     * 删除
     */
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }

    /**
     * 修改
     */
    @PatchMapping("/student/{id}")
    public Student update(@PathVariable("id") Integer id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @RequestMapping("/importExcel")
    public Object importExcel(@RequestParam(value="filename") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return ResultUtil.error(403, "文件为空！");
        }
        InputStream is = null;
        try
        {
            is = file.getInputStream();
            //获取文件名
            String fileName = file.getOriginalFilename();

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            Sheet sheetAt = null;
            //根据文件名判断文件是2003版本还是2007版本
            if(ExcelImportUtils.isExcel2007(fileName)){
                wb = new XSSFWorkbook(is);
                sheetAt = wb.getSheetAt(0);
            }else{
                wb = new HSSFWorkbook(is);
                sheetAt = wb.getSheetAt(0);
            }

            List<Student> userlist = new ArrayList<Student>();
            //用于密码加密
            // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //用于生日转换
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //double转String
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            //false则不分组显示数据, 如：999999999
            //true则分组显示数据，即每三位数为一个分组，分组间以英文半角逗号分隔, 如：999,999,999

            for (Row row : sheetAt) {
                int rowNum = row.getRowNum();
                if (rowNum == 0) {
                    continue;
                }

                String name = row.getCell(0).getStringCellValue();//用户名
                String phone = row.getCell(1).getStringCellValue();//手机号

                //判断是否重复用户名重复
                List<Student> studentList = studentRepository.findStudentByName(name);
                if(!studentList.isEmpty()){
                    return ResultUtil.error(403, "该用户名重复:"+ name);
                }

                //数据封装 ，存到数据库
                Student student = new Student();
                student.setName(name);
                student.setMobile(phone);



                userlist.add(student);
            }

            //保存数据到DB
            if(userlist.size()>0)
                studentService.save(userlist);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return ResultUtil.error(1,"error");
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResultUtil.error(1,"error");
                }
            }
        }

        return ResultUtil.success(ResultEnum.SUCCESS);
    }


}
