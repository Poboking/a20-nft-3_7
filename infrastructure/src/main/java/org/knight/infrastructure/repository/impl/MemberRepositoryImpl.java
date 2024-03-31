package org.knight.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.knight.infrastructure.common.NftConstants;
import org.knight.infrastructure.dao.domain.MemberEntity;
import org.knight.infrastructure.dao.mapper.MemberMapper;
import org.knight.infrastructure.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author poboking
 * @description 针对表【member】的数据库操作Service实现
 * @createDate 2024-03-07 17:31:43
 */
@Service
public class MemberRepositoryImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberRepository {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberRepositoryImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    /**
     * 获取用户账户信息
     *
     * @param memberId 用户ID
     * @return MemberEntity 账号实体
     */
    @Override
    public MemberEntity getAccountInfo(String memberId) {
        return memberMapper.selectById(memberId);
    }

    /**
     * 更新用户昵称
     *
     * @param memberId 用户ID
     * @param nickName 昵称
     * @return 是否更新成功
     */
    @Override
    public boolean updateNickName(String memberId, String nickName) {
        return memberMapper.update(null,
                new UpdateWrapper<MemberEntity>().
                        eq("id", memberId).set("nick_name", nickName)) > 0;
    }

    /**
     * 用户实名认证
     *
     * @param realName 真实姓名
     * @param ssn      身份证号
     * @param mobile   手机号
     * @return 是否更新成功
     */
    @Override
    public boolean bindReadName(String realName, String ssn, String mobile, String memberId) {
        return memberMapper.update(new UpdateWrapper<MemberEntity>()
                .eq(!memberId.isEmpty(), "id", memberId)
                .eq(!mobile.isEmpty(), "mobile", mobile)
                .set(!realName.isEmpty(), "real_name", realName)
                .set(!ssn.isEmpty(), "identity_card", ssn)) > 0;
    }

    /**
     * 减少用户余额
     *
     * @param memberId 用户ID
     * @param amount   金额
     * @return 是否更新成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean reduceBalance(String memberId, Double amount) {
        if (amount < 0) {
            return false;
        }
        if (memberMapper.selectById(memberId).getBalance() < amount) {
            return false;
        }
        return memberMapper.update(null,
                new UpdateWrapper<MemberEntity>()
                        .eq("id", memberId)
                        .setSql("balance = balance - " + amount)) > 0;
    }

    /**
     * 更新区块链地址
     *
     * @param blockAddress 区块链地址
     * @param memberId     用户ID
     * @return 是否更新成功
     */
    @Override
    public boolean updateBlockChainAddr(String blockAddress, String memberId) {
        String nowString = LocalDateTime.now().format(NftConstants.DATE_FORMAT);
        Timestamp now = Timestamp.valueOf(nowString);
        return memberMapper.update(null,
                new UpdateWrapper<MemberEntity>()
                        .eq("id", memberId)
                        .set("block_chain_addr", blockAddress)
                        .set("sync_chain_time", now)) > 0;
    }
}




