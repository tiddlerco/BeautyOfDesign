package design.structure.decorate.example2;


/**
 * 抽象基础装饰(装饰类父类)
 */
public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

   public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
