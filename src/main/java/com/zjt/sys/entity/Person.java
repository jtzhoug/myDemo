package com.zjt.sys.entity;

import com.zjt.model.BaseDo;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2018-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_person")
public class Person extends BaseDo {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private Integer score;


}
