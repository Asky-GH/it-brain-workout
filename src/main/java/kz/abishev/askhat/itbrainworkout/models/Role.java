package kz.abishev.askhat.itbrainworkout.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    private byte id;
    @Column(nullable = false, length = 10)
    private String title;

    @Override
    public String getAuthority() {
        return getTitle();
    }
}
