package org.knight.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import org.knight.infrastructure.dao.domain.SystemSettingEntity;

/**
 * @author poboking
 * @description 针对表【system_setting】的数据库操作Service
 * @createDate 2024-03-07 17:31:43
 */
public interface SystemSettingRepository extends IService<SystemSettingEntity> {

    /**
     * 获取最新的系统设置项
     *
     * @return 最新的系统设置项
     */
    SystemSettingEntity getLatestByLatestUpdateTime();
}
