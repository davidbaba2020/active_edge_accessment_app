package com.active_edge_accessment_app.service.stockServiceImpl;

import com.active_edge_accessment_app.dto.PageCreteria;
import com.active_edge_accessment_app.dto.StockDTO;
import com.active_edge_accessment_app.entities.Stock;
import com.active_edge_accessment_app.exceptions.StockNotFoundException;
import com.active_edge_accessment_app.repositories.StockRepository;
import com.active_edge_accessment_app.service.StockService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    private final static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);


    @Override
    public StockDTO createStock(StockDTO stockDTO) {
        Stock savedStock = stockRepository.save(convertToStockEntity(stockDTO));
        return convertToDTO(savedStock);
    }

    @Override
    public StockDTO getStockById(Long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new StockNotFoundException("Stock with ID " + id + " was not found."));
        logger.info("fetched stock,{}",stock);
        return convertToDTO(stock);
    }
    @Override
    public Page<StockDTO> getStocks(PageCreteria pageCreteria) {
        pageCreteria.setSortBy("id");
        Sort sort = Sort.by(pageCreteria.getSortDirection(), pageCreteria.getSortBy());
        Pageable pageable = PageRequest.of(pageCreteria.getPageNumber(), pageCreteria.getPageSize(), sort);
        Page<Stock> stockPage = stockRepository.findAll(pageable);
        List<StockDTO> stockDTOList = stockPage.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        logger.info("fetched stocks from db,{}",stockDTOList);
        return new PageImpl<>(stockDTOList, pageable, stockPage.getTotalElements());
    }





    protected StockDTO convertToDTO(Stock stock) {
        return modelMapper.map(stock, StockDTO.class);
    }

    private Stock convertToStockEntity(StockDTO stockDto) {
        return modelMapper.map(stockDto, Stock.class);
    }
}
