package com.zjt.repository;

import com.zjt.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 10:39 2018/11/19
 * @Description:
 */
// public interface ClothRepository extends JpaRepository<Cloth,Integer>{
//     @Query("SELECT  c.itemId,c.serialNum,c.auditorName,c.meetingId,c.score,c.checkedLabel,c.remark,a.auditorRole FROM ClothItem c,Auditor a WHERE c.meetingId = ?1 AND c.serialNum = ?2 AND c.auditorName = a.auditorName")
//     List<Object> findClothItemAndAuditorRole(Integer meetingId, Integer serialNum);
// }
