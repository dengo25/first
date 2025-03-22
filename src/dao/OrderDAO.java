package dao;

import vo.ItemVO;
import vo.MemberVO;
import vo.OrderVO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    MemberDAO memberDAO = new MemberDAO();
    ItemDAO itemDAO = new ItemDAO();

    public void createOrder(int orderId, int memberId, int itemId) {
        MemberVO member = memberDAO.findById(memberId);
        ItemVO item = itemDAO.findById(itemId);

        if (member != null && item != null && item.getQuantity() > 0) {
            LocalDateTime now = LocalDateTime.now();
            int totalPrice = item.getPrice() * item.getQuantity();
            OrderVO order = new OrderVO(now, orderId, memberId, item.getQuantity(), totalPrice);

        }
    }
}
