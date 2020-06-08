package com.boot.dao;

import com.boot.domain.BrokerLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author l.tian@aftership.com
 * @date 2020/6/8
 */
@Mapper
public interface BrokerLinkMapper {
    List<BrokerLink> getBrokerLink();
}
