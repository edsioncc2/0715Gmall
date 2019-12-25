package com.atguigu.gmall0715.demo.mapper;

import com.atguigu.gmall0715.demo.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;

// Mapper<T> T ：表示操作哪个实体类
public interface UserInfoMapper extends Mapper<UserInfo> {

//    /**
//     * 查询所有用户信息
//     * @return
//     */
//    List<UserInfo> findAll();

}
