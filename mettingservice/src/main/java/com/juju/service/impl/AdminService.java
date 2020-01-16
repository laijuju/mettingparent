package com.juju.service.impl;

import com.juju.mapper.AdminMapper;
import com.juju.mapper.LogMapper;
import com.juju.po.Admin;
import com.juju.po.Log;
import com.juju.result.AdminResult;
import com.juju.service.IAdminService;
import com.juju.utils.MD5Util;
import com.juju.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private LogMapper logMapper;

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
    public AdminResult login(Admin admin) {
        Log log = new Log();
        //获取到时间戳
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        AdminResult adminResult = new AdminResult();
        adminResult.setState(0);
        //第一步，需要找到用户名，然后通过用户名找到用户对象
        try {
            Admin admin1 = adminMapper.findAdminByAdminName(admin.getAdminLoginName());
            if (null == admin1) {//说明用户名不对
                throw new RuntimeException("用户名不正确");
            }
            //执行到这里，说明用户名是对的
            //比较密码是否一致
            if (!(MD5Util.encrypt(admin.getAdminPassword()).equals(admin1.getAdminPassword()))) {
                /*
                    生成登录失败的日志
                 */
                log.setLoginState("密码错误");
                log.setNickName(admin1.getAdminNickName());
                log.setLoginName(admin1.getAdminLoginName());
                log.setLoginTime(date);
                logMapper.addLog(log);
                throw new RuntimeException("密码不正确");
            }
            //用户整个身份合法
            //将用户信息生成唯一的token值储存到服务器上
            //设置生成的token信息
            String token = TokenUtils.getToken(admin1);
            //将token设置到admin上
            admin1.setToken(token);
            //设置过期时间
            currentTimeMillis = currentTimeMillis + 2592000;
            admin1.setExpireTokenTime(currentTimeMillis);
            /*
                设置好登录后的koken
             */
            adminMapper.updateTokenAndExpireTime(admin1);
            admin1.setLastLoginTime(date);
            /*
                修改用户最后一次登录时间
             */
            adminMapper.updateLastLoginTime(admin1);
            /*
                添加登录日志
             */
            log.setLoginState("登录成功");
            log.setNickName(admin1.getAdminNickName());
            log.setLoginName(admin1.getAdminLoginName());
            log.setLoginTime(date);
            logMapper.addLog(log);
            //执行到这里，说明整个流程是通的
            adminResult.setState(1);
            admin1.setAdminPassword("");
            adminResult.setAdmin(admin1);
            adminResult.setMsg("登录成功");
            //第二步：将token和用户信息返回给客户端，客户端进行存储
            return adminResult;
        } catch (Exception err) {
            adminResult.setState(0);
            adminResult.setMsg("登录失败：" + err.getMessage());
            return adminResult;
        }
    }

    @Override
    public boolean tokenExistOrNot(String token) {
        Admin admin = adminMapper.tokenExistOrNot(token);
        if (null == admin) {
            return false;
        }
        return true;
    }

    @Override
    public void logout(String token) throws Exception {
        adminMapper.updateToken(token);
    }

    @Override
    public Admin findAdminById(int id) throws Exception {
        return adminMapper.findAdminById(id);
    }

    @Override
    public void updateAdminById(Admin admin) throws Exception {
        adminMapper.updateAdminById(admin);
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword, int id) throws Exception {
        adminMapper.updatePassword(oldPassword, newPassword, id);
    }

    @Override
    public int checkPassword(int id, String adminPassword) throws Exception {
        String password = adminMapper.checkPassword(id);
        adminPassword = MD5Util.encrypt(adminPassword);
        if (adminPassword.equals(password)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void addUserRole(int adminId, int roleId) throws Exception {
        adminMapper.addUserRole(adminId, roleId);
    }

}
