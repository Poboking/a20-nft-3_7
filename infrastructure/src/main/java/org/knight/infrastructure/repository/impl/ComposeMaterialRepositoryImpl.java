package org.knight.infrastructure.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.knight.infrastructure.dao.domain.ComposeMaterialEntity;
import org.knight.infrastructure.dao.mapper.ComposeMaterialMapper;
import org.knight.infrastructure.repository.ComposeMaterialRepository;

/**
 * @author poboking
 * @description 针对表【compose_material】的数据库操作Service实现
 * @createDate 2024-03-07 17:31:43
 */
@Service
public class ComposeMaterialRepositoryImpl extends ServiceImpl<ComposeMaterialMapper, ComposeMaterialEntity>
        implements ComposeMaterialRepository {

}




