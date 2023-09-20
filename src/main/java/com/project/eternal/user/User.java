package com.project.eternal.user;

import com.project.eternal.userGames.UserGames;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long userNum;
    private String nickName;
    private List<UserGames> userGames;
}
