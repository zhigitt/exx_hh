package java12.enitity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter

public class BaseEntityId {
    @Id
    @GeneratedValue(generator = "base_id", strategy = GenerationType.SEQUENCE)
    private Long id;
}
