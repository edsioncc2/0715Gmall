package com.atguigu.gmall0715.demo.service.impl;

import com.atguigu.gmall0715.demo.bean.UserInfo;
import com.atguigu.gmall0715.demo.mapper.UserInfoMapper;
import com.atguigu.gmall0715.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    //调用mapper
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> findAll() {

        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        //不能范围查询
       // return userInfoMapper.select(userInfo);
       return userInfoMapper.selectByExample(userInfo);
    }

    @Override
    public List<UserInfo> findByUser(UserInfo userInfo) {
        // Example 作用：构造查询条件 操作谁给谁的实体类
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
        return userInfoMapper.selectByExample(example);
    }
    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.selectOne(userInfo);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updUser(UserInfo userInfo) {
        // update userInfo set name=? where id = ?;

        // userInfoMapper.updateByPrimaryKeySelective(userInfo);

        // 根据name修改loginName
        // update userInfo set loginName = ? where name=?
        // 第一个参数：表示要修改的值 第二个是修改的条件
        // UserInfo userInfo1 = new UserInfo();
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void delUser(UserInfo userInfo) {
        // 根据id 删除数据
        // delete from userInfo  where id = ?
        // userInfoMapper.deleteByPrimaryKey(userInfo);
//        userInfoMapper.deleteByExample();
        userInfoMapper.delete(userInfo);
    }
}
