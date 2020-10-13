package com.example.sprint2be.service.payment;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.payment.CartItem;
import com.example.sprint2be.model.payment.Order;
import com.example.sprint2be.model.payment.OrderDTO;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.repository.payment.OrderRepository;
import com.example.sprint2be.service.payment.CartService;
import com.example.sprint2be.service.payment.OrderService;
import com.example.sprint2be.service.payment.constant.ECartItemStatus;
import com.example.sprint2be.service.payment.constant.EOrderStatus;
import com.example.sprint2be.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Override
    public Optional<Order> findOrderByCartId(Integer cartId) {
        return orderRepository.findOrderByCart_CartId(cartId);
    }

    @Override
    public void save(OrderDTO orderDTO) {
        ModelMapper mapper = new ModelMapper();
        Order order = mapper.map(orderDTO, Order.class);
        Cart cart = cartService.findById(orderDTO.getCartId()).orElse(null);

        // Thien: cartId == userId
        User owner = userService.findByIdUser(orderDTO.getCartId());

        if (cart != null) {
            cart.setStatus(false);
            List<CartItem> cartItemList = cart.getCartItemList();
            cartItemList.removeIf(item -> !item.getStatus().equals(ECartItemStatus.ITEM_ENABLED.name()));
            for (CartItem item : cartItemList) {
                item.setStatus(ECartItemStatus.ITEM_PAID.name());
            }
            order.setCart(cart);
            order.setOrderStatus(EOrderStatus.ORDER_ASSIGNED.name());
            order.setDeliveryDate((LocalDate.now()).toString());
            order.setOrderCode("ORD" + Math.random() * 1000000);

            orderRepository.save(order);

            Cart cartFreshed = new Cart();

            cartFreshed.setStatus(true);
            owner.setCart(cartFreshed);
        }
    }
}
