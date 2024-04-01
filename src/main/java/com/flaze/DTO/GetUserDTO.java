package com.flaze.DTO;

import com.flaze.entity.ArticleEntity;
import com.flaze.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDTO { // DTO для того чтобы получать пользователя по его username-у без пароля

    private String username;
    private Integer age;
    private String email;
    private List<GetArticleDTO> articles;
}
