package org.sziit.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sziit.infrastructure.dao.domain.PayOrderEntity;
import org.sziit.infrastructure.dao.mapper.PayOrderMapper;
import org.sziit.infrastructure.repository.PayOrderRepository;

import java.util.Optional;

/**
 * @author poboking
 * @description 针对表【pay_order】的数据库操作Service实现
 * @createDate 2024-03-07 17:31:43
 */
@Service
public class PayOrderRepositoryImpl extends ServiceImpl<PayOrderMapper, PayOrderEntity>
        implements PayOrderRepository {
    @Autowired
    private PayOrderMapper payOrderMapper;

    /**
     * 获取我的支付订单分页列表 - 全部
     *
     * @param current  当前页
     * @param pageSize 每页大小
     * @return 分页列表
     */
    @Override
    public IPage<PayOrderEntity> getPayOrderPageList(long current, long pageSize) {
        return payOrderMapper.selectPage(new Page<>(current, pageSize), null);
    }

    /**
     * 获取我的支付订单分页列表 - 根据订单状态
     *
     * @param current  当前页
     * @param pageSize 每页大小
     * @param status   订单状态
     * @return 分页列表
     */
    @Override
    public IPage<PayOrderEntity> getPayOrderPageList(long current, long pageSize, String status) {
        return payOrderMapper.selectPage(new Page<>(current, pageSize), new QueryWrapper<PayOrderEntity>()
                .eq(Optional.ofNullable(status).isPresent(), "status", status));
    }

    /**
     * 获取我的支付订单分页列表 - 根据会员ID获取全部
     *
     * @param current  当前页
     * @param pageSize 每页大小
     * @return 分页列表
     */
    @Override
    public IPage<PayOrderEntity> getPayOrderPageListByMemberId(long current, long pageSize, String memberId) {
        return payOrderMapper.selectPage(new Page<>(current, pageSize), new QueryWrapper<PayOrderEntity>()
                .eq(Optional.ofNullable(memberId).isPresent(),"member_id", memberId));
    }

    /**
     * 获取我的支付订单分页列表 - 根据订单状态 & 会员ID
     *
     * @param current  当前页
     * @param pageSize 每页大小
     * @param status   订单状态
     * @return 分页列表
     */
    @Override
    public IPage<PayOrderEntity> getPayOrderPageListByMemberIdAndStatus(long current, long pageSize, String memberId, String status) {
        return payOrderMapper.selectPage(new Page<>(current, pageSize), new QueryWrapper<PayOrderEntity>()
                .eq(Optional.ofNullable(memberId).isPresent(),"member_id", memberId)
                .eq(Optional.ofNullable(status).isPresent(), "status", status));
    }


}



