package ru.yura.web.model;

import lombok.*;
import lombok.experimental.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

/*
 *
 *@Data 10.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor

public class Role  {


    private Long id;


    private String role;


    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(role.role, this.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }


}