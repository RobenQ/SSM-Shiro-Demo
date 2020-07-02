package transaction;

public class DefaultFooService implements FooService{
    @Override
    public String getFoo(String fooName) {
        return "apple";
    }

    @Override
    public String getFoo(String fooName, String barName) {
        return "apple==apple";
    }

    @Override
    public void insertFoo(String foo) {

    }

    @Override
    public void updateFoo(String foo) {

    }
}
