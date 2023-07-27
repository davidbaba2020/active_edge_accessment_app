package com.active_edge_accessment_app.controllers;


import com.active_edge_accessment_app.dto.PageCreteria;
import com.active_edge_accessment_app.dto.StockDTO;
import com.active_edge_accessment_app.entities.Stock;
import com.active_edge_accessment_app.repositories.StockRepository;
import com.active_edge_accessment_app.service.StockService;
import com.active_edge_accessment_app.service.stockServiceImpl.StockServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;
    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    private final static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @GetMapping
//    @ApiOperation("Get a list of stocks with pagination")
    public ResponseEntity<Page<StockDTO>> getStocks(PageCreteria pageCreteria) {
        return new ResponseEntity<>(stockService.getStocks(pageCreteria), HttpStatus.OK);
    }
    @GetMapping("/{id}")
//    @ApiOperation("Get one stock from the list")
    public ResponseEntity<StockDTO> getStock(@PathVariable Long id) {
        return new ResponseEntity<>(stockService.getStockById(id),HttpStatus.OK);
    }




}
