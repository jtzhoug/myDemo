package com.zjt.sys.service.impl;

import com.zjt.sys.entity.OperLog;
import com.zjt.sys.mapper.OperLogMapper;
import com.zjt.sys.service.IOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
@Service
public class OperLogServiceImpl extends ServiceImpl<OperLogMapper, OperLog> implements IOperLogService {

}
