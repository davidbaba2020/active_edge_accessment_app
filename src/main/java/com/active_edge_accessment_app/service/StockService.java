package com.active_edge_accessment_app.service;

import com.active_edge_accessment_app.dto.PageCreteria;
import com.active_edge_accessment_app.dto.StockDTO;
import org.springframework.data.domain.Page;

public interface StockService {

    StockDTO createStock(StockDTO stockDTO);

    StockDTO getStockById(Long id);
    Page<StockDTO> getStocks(PageCreteria pageCreteria);

}
