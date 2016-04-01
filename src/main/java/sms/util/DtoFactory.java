package sms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sms.model.*;
import sms.model.dto.*;
import sms.repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by user on 22.02.16.
 */
@Component

public class DtoFactory {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderRowRepository orderRowRepository;
    @Autowired
    private PresenterRepository presenterRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private TradePointRepository tradePointRepository;


    /***********************************
     * RoutsDto
     ***********************************/
    public TradePointDto createTradePointDto(TradePoint entity) {
        TradePointDto dto = new TradePointDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setContact(entity.getContact());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setRegion(entity.getRegion());
        dto.setAddress(entity.getAddress());
        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        return dto;
    }

    public RouteDto createRouteDto(Route entity) {
        RouteDto dto = new RouteDto();
        dto.setId(entity.getId());
        if (Objects.nonNull(entity.getDate())) {
            dto.setDate(new Date(entity.getDate().getTime()));
        }
        dto.setPriority(entity.getPriority());
        dto.setDateTime(entity.getDateTime());
        if (Objects.nonNull(entity.getTradePoint())) {
            dto.setTradePoint(createTradePointDto(entity.getTradePoint()));
        }
        return dto;
    }

    public List<RouteDto> createListOfRoutsDto(Collection<Route> routs) {
        return routs.stream().map(route -> createRouteDto(route)).collect(Collectors.toList());
    }

    /********************************
     * PresenterDto
     ********************************/
    public CategoryDto createCategoryDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        if (Objects.nonNull(entity.getParent())) {
            dto.setParent(createCategoryDto(entity.getParent()));
        }
        return dto;
    }

    public ItemDto createItemDto(Item entity) {
        ItemDto dto = new ItemDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        if (Objects.nonNull(entity.getCategory())) {
            dto.setCategory(createCategoryDto(entity.getCategory()));
        }
        return dto;
    }

    public PresenterDto createPresenterDto(Presenter entity) {
        PresenterDto dto = new PresenterDto();
        dto.setId(entity.getId());
        dto.setPriority(entity.getPriority());
        dto.setImageURI(entity.getImage());
        if (Objects.nonNull(entity.getItem())) {
            dto.setItem(createItemDto(entity.getItem()));
        }
        return dto;
    }

    public List<PresenterDto> createListOfPresenterDto(Collection<Presenter> presenters) {
        return presenters.stream().map(presenter -> createPresenterDto(presenter)).collect(Collectors.toList());
    }

    /********************************
     * OrderDto
     ********************************/
    public OrderRow createOrderRow(OrderRowDto dto) {
        OrderRow orderRow = new OrderRow();
        if (dto.getId() != null && dto.getId() != 0) {
            orderRow.setId(dto.getId());
        }
        if (Objects.nonNull(dto.getItemId())) {
            orderRow.setItem(itemRepository.findOne(dto.getItemId()));
        }
        orderRow.setQuantity(dto.getQuantity());
        orderRow.setPrice(dto.getPrice());
        orderRow.setSum(dto.getSum());
        return orderRow;
    }

    public Order createOrder(OrderDto dto) {
        Order order = new Order();
        if (dto.getId() != null && dto.getId() != 0) {
            order.setId(dto.getId());
        }
        order.setDateTime(dto.getDateTime());
        order.setDescription(dto.getDescription());
        order.setSum(dto.getSum());
        order.setShippingDate(new java.sql.Date(dto.getShippingDate().getTime()));
        order.setPaymentDate(new java.sql.Date(dto.getPaymentDate().getTime()));
        if (Objects.nonNull(dto.getFirmId())) {
            order.setFirm(firmRepository.findOne(dto.getFirmId()));
        }
        if (Objects.nonNull(dto.getRouteId())) {
            order.setRoute(routeRepository.findOne(dto.getRouteId()));
        }
        //Saving Order Rows to DB and add to Order.
        order.setRows(
                dto.getRows().stream()
                        .map(rowDto -> {
                            OrderRow row = createOrderRow(rowDto);
                            row.setOrder(order);
                            return row;
                        })
                        .collect(Collectors.toSet())
        );
        orderRepository.save(order);
        return order;
    }

    public OrderRowDto createOrderRowDto(OrderRow entity) {
        OrderRowDto dto = new OrderRowDto();
        if (Objects.nonNull(entity.getId())) {
            dto.setId(entity.getId());
        }
        if (Objects.nonNull(entity.getOrder().getId())) {
            dto.setOrderId(entity.getOrder().getId());
        }
        if (Objects.nonNull(entity.getItem().getId())) {
            dto.setItemId(entity.getItem().getId());
        }
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        dto.setSum(entity.getSum());
        return dto;
    }


    public OrderDto createOrderDto(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setIntegrationId(entity.getIntegrationId());
        dto.setDateTime(entity.getDateTime());
        dto.setDescription(entity.getDescription());
        dto.setSum(entity.getSum());
        dto.setShippingDate(new java.util.Date(entity.getShippingDate().getTime()));
        dto.setPaymentDate(new java.util.Date(entity.getPaymentDate().getTime()));
        if (Objects.nonNull(entity.getFirm().getId())) {
            dto.setFirmId(entity.getFirm().getId());
        }
        if (Objects.nonNull(entity.getRoute().getId())) {
            dto.setRouteId(entity.getRoute().getId());
        }
        dto.setRows(
                entity.getRows().stream()
                        .map(row -> createOrderRowDto(row))
                        .collect(Collectors.toList())
        );
        return dto;
    }


}
