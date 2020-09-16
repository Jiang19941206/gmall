package com.jiangcl.gmall.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiangcl.gmall.pms.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jiangcl
 * @date 2020/9/16
 * @desc
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    void insertUserInfo(@Param("userInfo") UserInfo userInfo);
}
