package com.java.orders.service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.java.orders.exception.CustomerIdNotFoundException;
import com.java.orders.exception.OrderIdIsNotFoundException;
import com.java.orders.exception.OrdersNotFoundException;
import com.java.orders.response.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.java.orders.client.CustomerClient;
import com.java.orders.client.ProductClient;
import com.java.orders.dto.Orderdto;
import com.java.orders.entity.Order;
import com.java.orders.repository.OrderDetailsRepository;
import com.java.orders.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService{

	private final OrderRepository orderRepository;
	private final OrderDetailsRepository orderDetailsRepository;
	private final CustomerClient customerClient;
	private final ProductClient productClient;
    private final ModelMapper modelMapper;

	@Override
	public OrderResponse saveOrder(Orderdto orderdto) {
		// TODO Auto-generated method stub
		//productClient.findCustomerById(orderdto.get)
        Order order = modelMapper.map(orderdto, Order.class);
        order.setOrderDate(LocalDate.now());
        order.setDeliveryDate(LocalDate.now().plusDays(3));
        order.getOrderDetails().forEach(orderDetails -> orderDetails.setOrder(order));
        Order savedOrder = orderRepository.save(order);
        return mapToResponse(savedOrder);


        /* Order order = new Order();
        order.setCustomerId(orderdto.getCustomerId());
		order.setOrderDate(LocalDate.now());
		order.setDeliveryDate(LocalDate.now().plusDays(5));
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		for(OrderDetailsDto orderDetailsDto : orderdto.getOrderDetails()) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrder(order);
			orderDetails.setProductId(orderDetailsDto.getProductId());
			orderDetails.setPrice(orderDetailsDto.getPrice());
			orderDetails.setQuantity(orderDetailsDto.getQuantity());	
			orderDetailsList.add(orderDetails);
		}
		order.setOrderDetails(orderDetailsList);
		
		return orderRepository.save(order);*/

	}

	@Override
	public OrderResponse updateOrder(Orderdto orderdto, long orderId) {
		// TODO Auto-generated method stub
		Order returningOrderId = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdIsNotFoundException("order id is not found to update "));

        modelMapper.map(orderdto, returningOrderId);
        returningOrderId.setOrderDate(LocalDate.now());
        returningOrderId.setDeliveryDate(LocalDate.now().plusDays(5));
        if(returningOrderId.getOrderDetails() == null || returningOrderId.getOrderDetails().isEmpty()) {
            throw new  RuntimeException("orderDetails are not found to update ");
        }
        returningOrderId.getOrderDetails()
                .forEach(orderDetails ->  orderDetails.setOrder(returningOrderId));
        Order updatedOrder = orderRepository.save(returningOrderId);
        return mapToResponse(updatedOrder);


       /* Order order = returningOrderId.get();
		order.setCustomerId(orderdto.getCustomerId());
		order.setOrderDate(LocalDate.now());
		order.setDeliveryDate(LocalDate.now().plusDays(5));

		List<OrderDetails> orderDetailsList = new ArrayList<>();
		for(OrderDetailsDto orderDetailsDto : orderdto.getOrderDetails()) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrder(order);
			orderDetails.setProductId(orderDetailsDto.getProductId());
			orderDetails.setPrice(orderDetailsDto.getPrice());
			orderDetails.setQuantity(orderDetails.getQuantity());
			orderDetailsList.add(orderDetails);
		}
		order.setOrderDetails(orderDetailsList);

		return orderRepository.save(order);*/
	}

	@Override
	public OrderResponse findByOrderId(long orderId) {
		// TODO Auto-generated method stub
		Order returningOrderId = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdIsNotFoundException("order id is not found"));
        modelMapper.map(returningOrderId, returningOrderId);
		return mapToResponse(returningOrderId);
	}

	@Override
	public List<OrderResponse> findAllOrders() {
		// TODO Auto-generated method stub
		List<Order> allOrders = orderRepository.findAll();
		if(allOrders.isEmpty()) {
			throw new OrdersNotFoundException("orders not found");
		}
        return allOrders.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
	}

	@Override
	public String deleteByOrderId(long orderId) {
		Order returningOrderId = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdIsNotFoundException("order id is not found to delete"));;
		orderRepository.deleteById(returningOrderId.getOrderId());
		return "order deleted with : " +orderId;
	}

	@Override
	public String deleteAllOrders() {
		// TODO Auto-generated method stub
		List<Order> allOrders = orderRepository.findAll();
		if(allOrders.isEmpty()) {
			throw new OrdersNotFoundException("orders not found to delete");
		}
        orderRepository.deleteAll();
		return "All records Deleted";
	}

	@Override
	public OrderDetailsWithCustomerAndProducts getOrderDetails(long orderId) {
		// TODO Auto-generated method stub
		
		Order returningOrderId = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdIsNotFoundException("order id is not found"));
		
//		if(returningOrderId.isEmpty()) {
//			throw new RuntimeException("");
//		}
		//Order order = returningOrderId.get();

		CustomerResponse customerResponse = customerClient.findByCustomerId(returningOrderId.getCustomerId());
		if(customerResponse == null) {
            throw new CustomerIdNotFoundException("customer id is not found");
        }
		//List<OrderDetails> returningOrderDetailsId = 

        List<ProductResponse> productResponse = orderDetailsRepository.findByOrder_OrderId(orderId).stream()
                .map(orderDetails -> productClient.findByProductId(orderDetails.getProductId()))
                .toList();


//		List<ProductDto> productDtoList = new ArrayList<>();
//		for(OrderDetails orderDetails : returningOrderDetailsId) {
//			ProductDto returningProductId = productClient.findProductById(orderDetails.getProductId());
//			productDtoList.add(returningProductId);
//		}

        OrderDetailsWithCustomerAndProducts orderDetailsWithCustomerAndProducts = modelMapper.map(returningOrderId, OrderDetailsWithCustomerAndProducts.class);
        orderDetailsWithCustomerAndProducts.setCustomers(customerResponse);
        orderDetailsWithCustomerAndProducts.setProducts(productResponse);
        return orderDetailsWithCustomerAndProducts;

//        OrderResponseDto orderResponseDto = new OrderResponseDto();
//		orderResponseDto.setOrderId(order.getOrderId());
//		orderResponseDto.setOrderDate(order.getOrderDate());
//		orderResponseDto.setDeliveryDate(order.getDeliveryDate());
//		orderResponseDto.setCustomers(customerDto);
//		orderResponseDto.setProducts(productDtos);

		
		//Optional<ProductDto> productDto = productClient.findProductById(order.getProductId());
		//ProductDto returningProductId = productDto.get();
	

//		Orderdto orderDto = new Orderdto();
//		orderDto.setOrderId(order.getOrderId());
//		orderDto.setCustomerId(order.getCustomerId());
//		orderDto.setProductId(order.getProductId());
//		orderDto.setOrderDate(order.getOrderDate());
//		orderDto.setDeliveryDate(order.getDeliveryDate());
//		
//		
//		OrderResponseDto orderResponseDto = new OrderResponseDto();
//		orderResponseDto.setOrderdto(orderDto);	
//		orderResponseDto.setCustomerDto(returningCustomerId);
//		orderResponseDto.setProductDto(returningProductId);
		
		
		
//		orderResponseDto.setOrderId(order.getOrderId());
//		orderResponseDto.setCustomerId(returningCustomerId.getCustomerId());
//		orderResponseDto.setCustomerName(returningCustomerId.getCustomerName());
//		orderResponseDto.setEmail(returningCustomerId.getEmail());
//		orderResponseDto.setMobileNumber(returningCustomerId.getMobileNumber());
//		orderResponseDto.setCustomerAddress(returningCustomerId.getAddress());
//		orderResponseDto.setProductId(returningProductId.getProductId());
//		orderResponseDto.setProductName(returningProductId.getProductName());
//		orderResponseDto.setProductPrice(returningProductId.getProductPrice());
//		orderResponseDto.setProductQuantity(returningProductId.getProductQuantity());
//		orderResponseDto.setOrderDate(order.getOrderDate());
//		orderResponseDto.setDeliveryDate(order.getDeliveryDate());
		//return Optional.of(orderResponseDto);
		
		
	}

	@Override
	public ResponseOfCustomerWithOrder getCustomerDetailsWithOrderId(long orderId) {
		
		Order returningOrderId = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderIdIsNotFoundException("order id is not found"));
//		if(returningOrderId.isEmpty()) {
//			throw new RuntimeException("Order id is not found");
//		}
//		Order order = returningOrderId.get();

		CustomerResponse customerResponse = customerClient.findByCustomerId(returningOrderId.getCustomerId());
        ResponseOfCustomerWithOrder responseOfCustomerWithOrder = modelMapper.map(returningOrderId, ResponseOfCustomerWithOrder.class);
        responseOfCustomerWithOrder.setCustomers(customerResponse);
        return responseOfCustomerWithOrder;


        /*ResponeOfCustomerWithOrder responeOfCustomerWithOrder = new ResponeOfCustomerWithOrder();
//		responeOfCustomerWithOrder.setOrderId(order.getOrderId());
//		responeOfCustomerWithOrder.setOrderDate(order.getOrderDate());
//		responeOfCustomerWithOrder.setDeliveryDate(order.getDeliveryDate());
		responeOfCustomerWithOrder.setCustomers(customerDto);

		// TODO Auto-generated method stub
		return Optional.of(responeOfCustomerWithOrder);*/
	}

        private OrderResponse mapToResponse(Order order) {
            OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
            if (order.getOrderDetails() != null) {
                List<OrderDetailsResponse> detailsResponse = order.getOrderDetails()
                        .stream()
                        .map(details -> modelMapper.map(details, OrderDetailsResponse.class))
                        .collect(Collectors.toList());

                orderResponse.setOrderDetailsResponse(detailsResponse);
            }
            return orderResponse;
        }
}

