package com.avcdata.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Created by huangcheng on 2017/3/24.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "user")
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    @Column(name = "username")
    private String username;
    private String password;
}