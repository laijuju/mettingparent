package com.juju.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private  int id;
    private int meetingNoticeId;
    private String seatNum;
}
