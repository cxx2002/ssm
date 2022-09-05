package com.cxx.mapper;

import com.cxx.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 陈喜喜
 * @date 2022-08-02 16:41
 * 对照接口文档来写接口方法
 * 多个参数需要用到注解@param(),用来给mybatis的实现mapper接口的xml指定声明参数
 */
public interface UserMapper {
    /**
     * url: /user/ selectUserPage?userName=z&userSex=男&page=null
     * 参数
     * userName:表单中用户名称
     * userSex:表单中用户性别
     * page:提交的页码(第一次访问为null)
     * 结果有数据时:
     * [{
     * "userId": "15968954638794962",
     * "cardType":" 身份证"，”
     * cardNo": "343343554654，
     * "userName": "撒撒旦"，
     * "userSex": ”女”
     * "userAge": "29",
     * "userRole":"生产、 运输设备操作人员及有关人员"}，
     * {..}
     * }]
     * 无数据时:
     * []
     * select * from user
     * #limit (当前页码-1)*每页条数,每页条数
     * limit 10,5;
     */
    List<User> selectUserPage(
            @Param("userName") String userName,
            @Param("userSex") String userSex,
            @Param("startRow") int startRow);

    /**
     * url /user/createUser (参数见下面)
     * 参数
     * cardType: this. ruleForm. cardType,//证件类型
     * cardNo: this. ruleForm . cardNo,//证件号码
     * userName: this. ruleForm. userName,//用户姓名
     * userSex: this. ruleForm. userSex,//用户性别
     * userAge: this. ruleForm. userAge,//用户年龄
     * userRole: this. ruleForm. userRole,//用户角色
     * 结果增加成功时:
     * 1
     * 增加失败时:
     * 0
     */
    int createUser(User user);

    /**
     * url /user/deleteUserById?userId=15968162087363060
     * 参数
     * userId:删除用户的id
     * 结果
     * 删除成功时:
     * 1
     * 删除失败时:
     * 0
     */
    int deleteUserById(String userId);

    /**
     * url / user/ge t RowCount ?use rName=Z &userSex=男
     * 参数
     * userName:表单中用户名称
     * userSex:表单中用户性别
     * 结果有数据时:
     * 12
     * 无数据时:
     * 0
     */
    int getRowCount(
            @Param("use rName")
                    String userName,
            @Param("userSex")
                    String userSex);

}
