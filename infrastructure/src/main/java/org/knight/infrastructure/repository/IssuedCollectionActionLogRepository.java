package org.knight.infrastructure.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import org.knight.infrastructure.dao.domain.IssuedCollectionActionLogEntity;

/**
 * @author poboking
 * @description 针对表【issued_collection_action_log】的数据库操作Service
 * @createDate 2024-03-07 17:31:42
 */
public interface IssuedCollectionActionLogRepository extends IService<IssuedCollectionActionLogEntity> {

    /**
     * 检查藏品是否被锁定 - 用户购买
     * @param issuedCollectionId 发行藏品ID
     * @return boolean
     */
    boolean checkCollectionLock(String issuedCollectionId);
}
