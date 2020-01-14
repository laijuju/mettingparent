package com.juju.control;

import com.juju.po.Staff;
import com.juju.result.StaffResult;
import com.juju.service.IStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "职位功能接口测试",description = "职位功能接口测试")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    Logger logger = Logger.getLogger(StaffController.class);

    @ApiOperation(value = "查看全部职位信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @GetMapping("findStaffAll")
    public StaffResult findStaffAll(){
        StaffResult staffResult = new StaffResult();
        staffResult.setState(0);
        try {
            List<Staff> staffs = staffService.findStaffAll();
            staffResult.setState(1);
            staffResult.setStaffs(staffs);
            staffResult.setMsg("查看全部职位成功");
            logger.info("查看全部职位成功");
            return staffResult;
        } catch (Exception e) {
            staffResult.setMsg("查看全部职位失败："+e.getMessage());
            logger.error("查看全部职位失败："+e.getMessage());
            return staffResult;
        }
    }

    @ApiOperation(value = "通过职位名查看职位ID")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("findStaffIdByStaffName")
    public StaffResult findStaffIdByStaffName(@RequestBody Staff staff){
        StaffResult staffResult = new StaffResult();
        staffResult.setState(0);
        try {
            int id = staffService.findStaffIdByStaffName(staff.getStaffName());
            staffResult.setState(1);
            staffResult.setMsg("通过职位名查看职位ID成功:"+id);
            logger.info("通过职位名查看职位ID成功");
            return staffResult;
        } catch (Exception e) {
            staffResult.setMsg("通过职位名查看职位ID失败："+e.getMessage());
            logger.error("通过职位名查看职位ID失败："+e.getMessage());
            return staffResult;
        }
    }

}
