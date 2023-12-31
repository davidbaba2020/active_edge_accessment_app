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
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;
    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    private final static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);


    @PostMapping
//    @ApiOperation("Create a new stock")
    public ResponseEntity<StockDTO> createStock(@RequestBody StockDTO stockDTO) {
        return new ResponseEntity<>(stockService.createStock(stockDTO),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
//    @ApiOperation("Get one stock from the list")
    public ResponseEntity<StockDTO> getStock(@PathVariable Long id) {
        return new ResponseEntity<>(stockService.getStockById(id),HttpStatus.OK);
    }
    @GetMapping
//    @ApiOperation("Get a list of stocks with pagination")
    public ResponseEntity<Page<StockDTO>> getStocks(@ParameterObject PageCreteria pageCreteria) {
        return new ResponseEntity<>(stockService.getStocks(pageCreteria), HttpStatus.OK);
    }





}
