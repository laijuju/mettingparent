package com.juju.control;

import com.juju.po.Seat;
import com.juju.result.SeatResult;
import com.juju.service.ISeatService;
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
@Api(value = "座次功能接口测试",description = "座次功能接口测试")
public class SeatController {
    @Autowired
    private ISeatService seatService;

    Logger logger = Logger.getLogger(SeatController.class);

    @ApiOperation(value = "查看所有座次信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @GetMapping("findSeatAll")
    public SeatResult findSeatAll(){
        SeatResult seatResult = new SeatResult();
        seatResult.setState(0);
        try {
            List<Seat> seats = seatService.findSeatAll();
            seatResult.setState(1);
            seatResult.setSeats(seats);
            seatResult.setMsg("查看所有座次信息成功");
            logger.info("查看所有座次信息成功");
            return seatResult;
        } catch (Exception e) {
            seatResult.setMsg("查看所有座次信息失败："+e.getMessage());
            logger.error("查看所有座次信息失败："+e.getMessage());
            return seatResult;
        }
    }

    @ApiOperation(value = "通过ID查看所有座次信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("findSeatById")
    public SeatResult findSeatById(@RequestBody Seat seat){
        SeatResult seatResult = new SeatResult();
        seatResult.setState(0);
        try {
            Seat seat1 = seatService.findSeatById(seat.getId());
            seatResult.setState(1);
            seatResult.setMsg("通过ID查看所有座次信息成功");
            seatResult.setSeat(seat1);
            logger.info("通过ID查看所有座次信息成功");
            return seatResult;
        } catch (Exception e) {
            seatResult.setMsg("通过ID查看所有座次信息失败："+e.getMessage());
            logger.error("通过ID查看所有座次信息失败："+e.getMessage());
            return seatResult;
        }
    }

    @ApiOperation(value = "增加座次信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("addSeat")
    public SeatResult addSeat(@RequestBody Seat seat){
        SeatResult seatResult = new SeatResult();
        seatResult.setState(0);
        try {
            seatService.addSeat(seat);
            seatResult.setState(1);
            seatResult.setMsg("增加座次信息成功");
            logger.info("增加座次信息成功");
            return seatResult;
        } catch (Exception e) {
            seatResult.setMsg("增加座次信息失败："+e.getMessage());
            logger.error("增加座次信息失败："+e.getMessage());
            return seatResult;
        }
    }

    @ApiOperation(value = "修改座次信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("updateSeat")
    public SeatResult updateSeat(@RequestBody Seat seat){
        SeatResult seatResult = new SeatResult();
        seatResult.setState(0);
        try {
            seatService.updateSeat(seat);
            seatResult.setState(1);
            seatResult.setMsg("修改座次信息成功");
            logger.info("修改座次信息成功");
            return seatResult;
        } catch (Exception e) {
            logger.error("修改座次信息失败："+e.getMessage());
            seatResult.setMsg("修改座次信息失败："+e.getMessage());
            return seatResult;
        }
    }

    @ApiOperation(value = "删除座次信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("deleteSeat")
    public SeatResult deleteSeat(@RequestBody Seat seat){
        SeatResult seatResult = new SeatResult();
        seatResult.setState(0);
        try {
            seatService.deleteSeat(seat.getId());
            seatResult.setState(1);
            seatResult.setMsg("删除座次信息成功");
            logger.info("删除座次信息成功");
            return seatResult;
        } catch (Exception e) {
            seatResult.setMsg("删除座次信息失败："+e.getMessage());
            logger.error("删除座次信息失败："+e.getMessage());
            return seatResult;
        }
    }

}
