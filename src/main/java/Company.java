/**
 * Created by 2 on 06.06.2019.
 */
public class Company{
    private final String name;
    private final String inn;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                '}';
    }

    public Company(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }
}
