import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Entity entity = new Entity();

        Class<Entity> clazz = Entity.class;
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            System.out.println(field.isAccessible());
            try {
                field.set(entity, "abc");
                System.out.println(field.get(entity));
            } catch (IllegalAccessException e) {
                System.out.println(String.format("no access to: %s", field.getName()));
            }
        }
    }
}
