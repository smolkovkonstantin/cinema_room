
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.equals("")) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.equals("")) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        String result = "Unknown";
        if (!firstName.equals("")) {
            result = firstName;
        }
        if (!lastName.equals("")) {
            if (result.equals(firstName)) {
                result += " " + lastName;
            } else {
                result = lastName;
            }
        }
        return result;
    }
}