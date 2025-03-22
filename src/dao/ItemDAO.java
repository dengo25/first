package dao;

import com.sun.source.tree.BreakTree;
import common.ConnectionProvider;
import vo.ItemVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    // 아이템 리스트 전체 조회
    public List<ItemVO> findAll() {

        String sql = "select * from items";

        List<ItemVO> list = new ArrayList<>();

        try {
            Connection conn = ConnectionProvider.getConnection();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                int discountPer = rs.getInt(4);

                // ResultSet에서 TIMESTAMP 값을 가져와 LocalDateTime으로 변환
                Timestamp timestamp = rs.getTimestamp(5);
                LocalDateTime created = timestamp.toLocalDateTime();

                // ItemVO 객체 생성 후 리스트에 추가
                list.add(new ItemVO(id, name, price, discountPer, created));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // 이름으로 아이템 검색
    public ItemVO findByString(String name) {
        String sql = "select * from items where name = ? ";
        ItemVO itemVO = new ItemVO();
        Connection conn = ConnectionProvider.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                itemVO.setName(name);
                itemVO.setId(rs.getInt("id"));
                itemVO.setPrice(rs.getInt("price"));
                itemVO.setDiscountPer(rs.getInt("discount_per"));

                Timestamp timestamp = rs.getTimestamp("created");
                LocalDateTime created = timestamp.toLocalDateTime();
                itemVO.setCreated(created);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemVO;
    }
}
