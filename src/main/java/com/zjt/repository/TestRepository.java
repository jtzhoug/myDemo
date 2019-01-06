package com.zjt.repository;

import com.zjt.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: zhou.jingtao
 * @Date: 2018-12-29 09:25
 * @Description:
 */

public interface TestRepository extends JpaRepository<Test,Integer> {
}
