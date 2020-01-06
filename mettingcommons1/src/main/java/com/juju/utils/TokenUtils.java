package com.juju.utils;


import com.juju.po.Admin;

/**
 * @Auther: xiaobobo
 * @Date: 2019/11/21 15:05
 * @Description:token的生成器
 */
public class TokenUtils {
    /**
     *生成管理员省份唯一的标识
     * @param admin
     * @return
     */
    public static String getToken(Admin admin){
       //做个简单的MD5
        String str=admin.getAdminLoginName()+admin.getAdminPassword();
        str=MD5Util.encrypt(str);
        return str;
    }
}
