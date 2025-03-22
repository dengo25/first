package vo;

import java.time.LocalDateTime;

public class MemberVO {

    private Integer id;
    private String name;
    private String loginId;
    private String loginPw;
    private LocalDateTime created;
    private String phone;

    public MemberVO() {
    }

    public MemberVO(int id, String name, int login_id, int login_pw, String phone) {
    }

    public MemberVO(Integer id, String loginId, String loginPw, String name, LocalDateTime created,String phone) {
        this.id = id;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.created = created;
        this.phone = phone;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "created=" + created +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", loginId='" + loginId + '\'' +
                ", loginPw='" + loginPw + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
