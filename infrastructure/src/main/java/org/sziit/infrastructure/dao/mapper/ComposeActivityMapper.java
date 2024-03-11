package org.sziit.infrastructure.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.sziit.infrastructure.dao.domain.ComposeActivityEntity;

/**
 * @author poboking
 * @description 针对表【compose_activity】的数据库操作Mapper
 * @createDate 2024-03-07 17:31:43
 * @Entity domain.ComposeActivityEntity
 */

@Mapper
public interface ComposeActivityMapper extends BaseMapper<ComposeActivityEntity> {

}




