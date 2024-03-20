package org.sziit.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sziit.infrastructure.dao.domain.MemberEntity;
import org.sziit.infrastructure.dao.mapper.MemberMapper;
import org.sziit.infrastructure.repository.MemberRepository;

/**
 * @author poboking
 * @description 针对表【member】的数据库操作Service实现
 * @createDate 2024-03-07 17:31:43
 */
@Service
public class MemberRepositoryImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberRepository {

    @Autowired
    private MemberMapper memberMapper;

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
}




