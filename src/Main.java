import dao.ItemDAO;
import dao.MemberDAO;
import vo.ItemVO;
import vo.MemberVO;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //아이템 전체목록 불러오기
//        ItemDAO itemDAO = new ItemDAO();
//        List<ItemVO> all = itemDAO.findAll();
//        System.out.println(all);


//        //개별 아이템 가져오기
//        ItemVO item = itemDAO.findByString("딸기");
//        System.out.println(item);
//
//
//
//        //멤버 등록
//        MemberDAO memberDAO = new MemberDAO();
//        //향후 멤버 등록시 스캐너로 구현 아래명령어로 멤버 생성 확인
//        List<MemberVO> members = memberDAO.findAll();

//        memberDAO.save("ten","insert@insert","1234","010-0000-1234");
//        System.out.println(memberDAO);

        Scanner sc = new Scanner(System.in);
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.manageItem(sc);



    }

}