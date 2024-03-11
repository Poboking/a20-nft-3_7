package org.sziit.infrastructure.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.sziit.infrastructure.dao.domain.ChainSettingEntity;
import org.sziit.infrastructure.dao.mapper.ChainSettingMapper;
import org.sziit.infrastructure.repository.ChainSettingService;

/**
 * @author poboking
 * @description 针对表【chain_setting】的数据库操作Service实现
 * @createDate 2024-03-07 17:31:43
 */
@Service
public class ChainSettingServiceImpl extends ServiceImpl<ChainSettingMapper, ChainSettingEntity>
        implements ChainSettingService {

}




