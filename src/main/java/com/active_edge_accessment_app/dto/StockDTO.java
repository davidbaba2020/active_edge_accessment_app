package com.active_edge_accessment_app.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Long id;
    private String name;
    private Double currentPrice;
    private Date createDate;
    private Date lastUpdate;
}
