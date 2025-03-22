package dao;

import common.ConnectionProvider;
import vo.ItemVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDAO {
    List<ItemVO> list;

    public void manageItem(Scanner scanner) {
        while (true) {
            System.out.println("\n 제품 관리 메뉴");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 삭제");
            System.out.println("3. 제품 목록 보기");
            System.out.println("4. 이전 메뉴로");

            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("제품 ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("제품 명: ");
                    String name = scanner.nextLine();

                    System.out.print("가격: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("재고: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("할인율 ");
                    int discount_per = scanner.nextInt();
                    saveItem(id, name, price, quantity, discount_per);
                    break;
                case 2:
                    System.out.print("삭제할 제품의 ID: ");
                    int i = scanner.nextInt();
                    removeItems(i);
                    break;
                case 3:
                    List<ItemVO> all = findAll();
                    for (ItemVO itemVO : all) {
                        System.out.println("제품 ID: " + itemVO.getId());
                        System.out.println("제품 이름: " + itemVO.getName());
                        System.out.println("제품 가격: " + itemVO.getPrice());
                        System.out.println("제품 수량: " + itemVO.getQuantity());
                        System.out.println("제품 할인: "+itemVO.getDiscountPer());
                        System.out.println();
                    }
            }
        }
    }

    private void removeItems(int id) {
        String sql = "delete from items where id = ?";
        Connection conn = ConnectionProvider.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
            if (i == 1) {
                System.out.println("삭제완료");
            } else {
                System.out.println("제품 삭제에 실패했습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //아이템 등록
    public void saveItem(Integer id, String name, int price, int discount_per, int quantity) {
        String sql = "INSERT INTO items (id, name, price, discount_per, quantity) VALUES (?, ?, ?, ?, ?)";


        Connection conn = ConnectionProvider.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, price);
            pstmt.setInt(4, discount_per);
            pstmt.setInt(5,quantity);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("제품이 정상 등록 되었습니다.");
            } else {
                System.out.println("제품 등록에 실패했습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    // 아이템 리스트 전체 조회
    public List<ItemVO> findAll() {

        String sql = "select * from items";

        list = new ArrayList<>();

        try {
            Connection conn = ConnectionProvider.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                int discountPer = rs.getInt(4);
                int quantity = rs.getInt("quantity");

                // ResultSet에서 TIMESTAMP 값을 가져와 LocalDateTime으로 변환
                Timestamp timestamp = rs.getTimestamp(5);
                LocalDateTime created = timestamp.toLocalDateTime();

                // ItemVO 객체 생성 후 리스트에 추가
                list.add(new ItemVO(id, name, price, discountPer, created, quantity));
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
                itemVO.setQuantity(rs.getInt("quantity"));

                Timestamp timestamp = rs.getTimestamp("created");
                LocalDateTime created = timestamp.toLocalDateTime();
                itemVO.setCreated(created);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemVO;
    }

    // id로 아이템 검색
    public ItemVO findById(int id) {
        String sql = "select * from items where id = ? ";
        ItemVO itemVO = new ItemVO();
        Connection conn = ConnectionProvider.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                itemVO.setName(rs.getString("name"));
                itemVO.setId(rs.getInt("id"));
                itemVO.setPrice(rs.getInt("price"));
                itemVO.setDiscountPer(rs.getInt("discount_per"));
                itemVO.setQuantity(rs.getInt("quantity"));

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
