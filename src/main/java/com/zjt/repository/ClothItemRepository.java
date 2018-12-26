package com.zjt.repository;

import com.zjt.model.Cloth;
import com.zjt.model.ClothItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 16:43 2018/11/18
 * @Description:
 */
public interface ClothItemRepository extends JpaRepository<ClothItem,Integer>{
    // @Query("select c.meetingId,c.auditorName,a.auditorRole,c.checkedLabel from ClothItem c join Auditor a on c.auditorName = a.auditorName and c.itemId = ?1")
    // Object findCloth(Integer clothItemId);

    @Query("SELECT  c.itemId,c.serialNum,c.auditorName,c.meetingId,c.score,c.checkedLabel,c.remark,a.auditorRole FROM ClothItem c,Auditor a WHERE c.meetingId = ?1 AND c.serialNum = ?2 AND c.auditorName = a.auditorName")
    List<Object[]> findClothItemAndAuditorRole(Integer meetingId, Integer serialNum);

    List<ClothItem> findBySerialNumAndMeetingId(Integer serialNum,Integer meetingId);
}
