package org.knight.infrastructure.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.knight.infrastructure.dao.domain.IssuedCollectionActionLogEntity;
import org.knight.infrastructure.dao.mapper.IssuedCollectionActionLogMapper;
import org.knight.infrastructure.repository.IssuedCollectionActionLogRepository;

/**
 * @author poboking
 * @description 针对表【issued_collection_action_log】的数据库操作Service实现
 * @createDate 2024-03-07 17:31:42
 */
@Service
public class IssuedCollectionActionLogRepositoryImpl extends ServiceImpl<IssuedCollectionActionLogMapper, IssuedCollectionActionLogEntity>
        implements IssuedCollectionActionLogRepository {

}




