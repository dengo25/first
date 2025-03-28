package dao;

import common.ConnectionProvider;
import vo.ItemVO;
import vo.MemberVO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    List<MemberVO> members = new ArrayList<>();

    //멤버저장
    public void save(String name, String loginId, String loginPW, String phone) {
        String sql = "INSERT INTO members (name, login_id, login_pw, phone) VALUES (?, ?, ?, ?)";
        MemberVO member;
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, loginId);
            pstmt.setString(3, loginPW);
            pstmt.setString(4, phone);
            int result = pstmt.executeUpdate();
            System.out.println("멤버 등록 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<MemberVO> findAll() {

        String sql = "select * from members";

        try {
            Connection conn = ConnectionProvider.getConnection();
            System.out.println(conn);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {


                System.out.println(rs.getInt("id"));

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String  login_id = rs.getString("login_id");
                String  login_pw = rs.getString("login_pw");
                String phone = rs.getString("phone");

                // ResultSet에서 TIMESTAMP 값을 가져와 LocalDateTime으로 변환
                Timestamp timestamp = rs.getTimestamp("CREATED");
                LocalDateTime created = timestamp.toLocalDateTime();
                System.out.println(created);
                System.out.println(new MemberVO(id, name, login_id, login_pw, created,phone));  // 디버깅 출력

//                // ItemVO 객체 생성 후 리스트에 추가
                members.add(new MemberVO(id, name, login_id, login_pw, created, phone));
            }
        } catch (SQLException e) {
           e.printStackTrace();
            e.getMessage();
        }
        return members;
    }

    public MemberVO findById(int id) {

        String sql = "select * from members where id = ? ";
        MemberVO member = new MemberVO();
        Connection conn = ConnectionProvider.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                member.setName(rs.getString("name"));
                member.setId(rs.getInt("id"));
                member.setLoginId(rs.getString("login_id"));
                member.setLoginPw(rs.getString("login_pw"));
                member.setPhone(rs.getString("phone"));

                Timestamp timestamp = rs.getTimestamp("created");
                LocalDateTime created = timestamp.toLocalDateTime();
                member.setCreated(created);


            }


        } catch (SQLException e) {
            System.out.println("예외발생 "+e.getMessage());

        }
        return member;
    }

}
