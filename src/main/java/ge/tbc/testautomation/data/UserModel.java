package ge.tbc.testautomation.data;

// POJO -> Plain Old Java Object
public class UserModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;

//    public UserModel(Integer id, String firstName, String lastName, String username) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserModel() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
