package com.quanquan.checkboxandrecyclerview.second;

/**
 * @DateTime: 2016-07-26 14:33
 * @Author: duke
 * @Deacription:
 */
public class UserBean {

    //后台返回的json字段
    public String userName;
    public String userPwd;
    //...


    //本地字段，用户recyclerview保存状态
    public boolean isSelected = false;
}
