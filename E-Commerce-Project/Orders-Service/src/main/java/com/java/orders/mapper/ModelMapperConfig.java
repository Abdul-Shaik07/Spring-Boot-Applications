package com.java.orders.mapper;

import com.java.orders.dto.OrderDetailsDto;
import com.java.orders.dto.Orderdto;
import com.java.orders.entity.Order;
import com.java.orders.entity.OrderDetails;
import com.java.orders.response.OrderDetailsResponse;
import com.java.orders.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setSkipNullEnabled(true);

        modelMapper.typeMap(OrderDetails.class, OrderDetailsResponse.class);

        modelMapper.typeMap(Order.class, OrderResponse.class)
                .addMappings(mapper -> mapper.skip(OrderResponse::setOrderDetailsResponse));

        modelMapper.typeMap(Orderdto.class, Order.class)
                .addMappings(mapper -> mapper.skip(Order::setOrderId));
        modelMapper.typeMap(OrderDetailsDto.class, OrderDetails.class)
                .addMappings(mapper -> mapper.skip(OrderDetails::setOrderDetailsId));
        return modelMapper;
    }
}
