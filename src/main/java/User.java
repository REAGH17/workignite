import java.time.LocalDate;

/**
 * Created by 2 on 06.06.2019.
 */
public class User {
    private final String name;
    private final LocalDate birthday;
    private  final Company company;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", company=" + company +
                '}';
    }

    public User(String name, LocalDate birthday, Company company) {
        this.name = name;
        this.birthday = birthday;
        this.company = company;
    }
}
