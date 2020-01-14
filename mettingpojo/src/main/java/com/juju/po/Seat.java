package com.juju.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private  int id;                //座次ID
    private int meetingNoticeId;    //会议通知Id
    private String seatNum;         //座次号
}
