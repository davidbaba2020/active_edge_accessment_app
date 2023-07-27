package com.active_edge_accessment_app.service.stockServiceImpl;

import com.active_edge_accessment_app.dto.PageCreteria;
import com.active_edge_accessment_app.dto.StockDTO;
import com.active_edge_accessment_app.entities.Stock;
import com.active_edge_accessment_app.repositories.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock
    private ModelMapper mapper;
    @Mock
    private StockRepository stockRepository;
    @InjectMocks
    private StockServiceImpl stockService;

    private Stock stock;

    @BeforeEach
    void setUp() {
        stock = new Stock();
        stock.setId(1L);
        stock.setName("Example Stock");
        stock.setCurrentPrice(100.00);
        stock.setCreateDate(new Date(System.currentTimeMillis()));
        stock.setLastUpdate(new Date(System.currentTimeMillis()));
    }


    @Test
    void getStockById() {
        Long stockId = 1L;
        StockDTO stockDTO = new StockDTO();
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));

        when(mapper.map(stock, StockDTO.class)).thenReturn(stockDTO);
        StockDTO returnedStock = stockService.getStockById(stockId);
        assertThat(returnedStock).isNotNull();
    }

    @Test
    void getStocks() {
        PageCreteria pageCreteria = new PageCreteria();
        pageCreteria.setPageSize(5);
        pageCreteria.setPageNumber(0);
        pageCreteria.setSortBy("id");
        pageCreteria.setSortDirection(Sort.Direction.ASC);

        Stock stock1 = Stock.builder()
                .name("Stock 1")
                .currentPrice(120.87)
                .build();
        Stock stock2 = Stock.builder()
                .name("Stock 2")
                .currentPrice(100.01)
                .build();
        Stock stock3 = Stock.builder()
                .name("Stock 3")
                .currentPrice(200.25)
                .build();

        List<Stock> page = Arrays.asList(stock1, stock2, stock3);

        Sort sort = Sort.by(pageCreteria.getSortDirection(), pageCreteria.getSortBy());
        Pageable pageable = PageRequest.of(pageCreteria.getPageNumber(), pageCreteria.getPageSize(), sort);
        when(stockRepository.findAll(pageable)).thenReturn(new PageImpl<>(page));
        Page<StockDTO> returnedPage = stockService.getStocks(pageCreteria);
        assertThat(returnedPage).isNotNull();
        assertThat(returnedPage.getTotalElements()).isEqualTo(page.size());
    }

    @Test
    void updateStockPrice() {
        StockDTO stockDTO = new StockDTO();
        when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
        when(stockService.convertToDTO(stock)).thenReturn(stockDTO);
        StockDTO returnedStock = stockService.updateStockPrice(1L,200.00);
        assertNotEquals(100.00,stock.getCurrentPrice());
    }

}