package com.juju.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.juju.service.IAdminService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthticationFilter implements HandlerInterceptor {

    @Autowired
    private IAdminService adminService;

    private Logger logger = Logger.getLogger(AuthticationFilter.class);

    //什么不需要拦截的地址
    private String[] noInterceptorPath = {
        "login",
        "register",
        "swagger-ui.html"
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        //获取请求url地址
        String requestURI = request.getRequestURI();
        //取出最终的地址
        requestURI = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        //判断是否包含？
        if (requestURI.contains("?")){
            requestURI = requestURI.substring(0,requestURI.indexOf("?")-1);
        }
        //释放所有静态资源
        if (requestURI.endsWith(".js")||requestURI.endsWith(".css")||requestURI.endsWith(".jpg")||requestURI.endsWith(".png")){
            return true;
        }
        logger.info("分离出来的这个地址是："+requestURI);
        //判断地址是否需要拦截
        for (String path: noInterceptorPath) {
            if (path.equals(requestURI)){
                return true;
            }
        }
        //如果执行到这里，说明地址需要拦截
        //第一步：先找到token
        String token = request.getHeader("token");
        if (null == token|| token.equals("")){//说明非法请求，因为没有token
            //返回一个JSON格式，告诉身份不合法
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state",0);
            jsonObject.put("msg","没有token，身份不合法");
            response.getWriter().write(jsonObject.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return false;
        }
        //执行到这里是，说明token有值，但是需要进行数据库的校验
        //第二步：查看这个token是否在数据库中存在
        boolean existOrNot = adminService.tokenExistOrNot(token);
        if(!existOrNot){//说明token不存在
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state",0);
            jsonObject.put("msg","token不存在，或者已经过期");
            response.getWriter().write(jsonObject.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
