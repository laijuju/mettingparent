package com.juju.service.impl;

import com.juju.mapper.AdminMapper;
import com.juju.po.Admin;
import com.juju.result.AdminResult;
import com.juju.service.IAdminService;
import com.juju.utils.MD5Util;
import com.juju.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByAdminName(String adminName) throws Exception {
        return adminMapper.findAdminByAdminName(adminName);
    }

    @Override
    public void addAdmin(Admin admin) throws Exception {
        adminMapper.addAdmin(admin);
    }

    @Override
    public void deleteAdmin(int adminId) throws Exception {
        adminMapper.deleteAdmin(adminId);
    }

    @Override
    public List<Admin> findAdminAll() throws Exception {
        return adminMapper.findAdminAll();
    }

    @Override
    public AdminResult login(Admin admin){
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        //第一步，需要找到用户名，然后通过用户名找到用户对象
           try {
               Admin admin1 = adminMapper.findAdminByAdminName(admin.getAdminLoginName());
               if(null==admin1){//说明用户名不对
                   throw new RuntimeException("用户名不正确");
               }
               //执行到这里，说明用户名是对的
               //比较密码是否一致
               if(!(MD5Util.encrypt(admin.getAdminPassword()).equals(admin1.getAdminPassword()))){
                   throw new RuntimeException("密码不正确");
               }
               //用户整个身份合法
               //将用户信息生成唯一的token值储存到服务器上
               //设置生成的token信息
               String token = TokenUtils.getToken(admin1);
               //将token设置到admin上
               admin1.setToken(token);
               //设置过期时间
               //获取到时间戳
               long currentTimeMillis = System.currentTimeMillis();
               currentTimeMillis = currentTimeMillis+2592000;
               admin1.setExpireTokenTime(currentTimeMillis);
               adminMapper.updateTokenAndExpireTime(admin1);
               //执行到这里，说明整个流程是通的
               adminResult.setState(1);
               admin1.setAdminPassword("");
               adminResult.setAdmin(admin1);
               //第二步：将token和用户信息返回给客户端，客户端进行存储
               return adminResult;
           }catch (Exception err){
                adminResult.setState(0);
                adminResult.setMsg("登录失败："+err.getMessage());
               return adminResult;
           }
    }

    @Override
    public boolean tokenExistOrNot(String token) {
        Admin admin = adminMapper.tokenExistOrNot(token);
        if(null==admin){
            return false;
        }
        return true;
    }

    @Override
    public void logout(String token) throws Exception{
        adminMapper.updateToken(token);
    }
}
