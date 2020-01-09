package life.majiang.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int userId;
    private String accountId;
    private String userName;
    private String userPassword;
    private Date userCreate;
    private int userActive;
}
