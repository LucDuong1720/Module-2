package model;

public enum Role {
    ADMIN("ADMIN" ,1), Customer("CUSTOMER", 2);
    private String value;
    private long id;

    Role(String value, long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public static Role toRole(long id) {
        for (Role role : values()) {
            if (role.id == id) {
                return role;
            }
        }
        return null;
    }
    public static Role getRoleByName(String name) {
        for (Role role : values()) {
            if (role.toString().equals(name)) {
                return role;
            }
        }
        return null;
    }
}
