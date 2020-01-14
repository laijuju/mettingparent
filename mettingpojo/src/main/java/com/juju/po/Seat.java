package com.juju.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private  int id;                //座次ID
    private MeetingNotice meetingNotice;    //会议通知信息
    private String seatNum;         //座次号
    private Admin admin;            //用户信息
}
