package ch.noseryoung.grocerie.domain.authority;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private int authorityId;

    @Column(name = "authority_name")
    private String authorityName;
}
