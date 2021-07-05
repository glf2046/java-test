import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
class Entity implements Serializable {

    private static final long serialVersionUID = -2348060514704687777L;

    private String field1;

    private String field2;

    private long field3;

    private byte field4;
}
