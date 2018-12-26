package com.zjt.repository;

import com.zjt.model.Auditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author zhou.jingtao
 * @date created in 16:44 2018/11/18
 * @Description:
 */
public interface AuditorRepository extends JpaRepository<Auditor,Integer>{

    // @Query("select a.auditorName,a.meetingId,a.auditorRole,c.checkedLabel from Auditor a join ClothItem c on a.auditorName = c.auditorName ")
    // Object findAuditor();
}
