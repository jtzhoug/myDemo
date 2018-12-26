package com.zjt.repository;

import com.zjt.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhou.jingtao
 * @date created in 22:49 2018/11/21
 * @Description:
 */
public interface BandRepository extends JpaRepository<Band,Integer>{

    Band findBySeries(String series);
}
