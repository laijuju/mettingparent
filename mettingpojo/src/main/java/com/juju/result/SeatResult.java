package com.juju.result;

import com.juju.po.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatResult extends BaseResult {
    private List<Seat> seats;
    private Seat seat;
}
