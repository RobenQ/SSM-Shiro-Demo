package transaction;

public interface FooService {

    String getFoo(String fooName);

    String getFoo(String fooName, String barName);

    void insertFoo(String foo);

    void updateFoo(String foo);
}
