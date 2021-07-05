import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@NoArgsConstructor
class EntityCustom implements Externalizable {

    private static final long serialVersionUID = -2348060514704687777L;

    private String field1;

    private String field2;

    private long field3;

    private byte field4;

    public void writeExternal(ObjectOutput out) throws IOException {

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
