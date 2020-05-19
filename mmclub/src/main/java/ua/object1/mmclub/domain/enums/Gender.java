package ua.object1.mmclub.domain.enums;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String value;

    Gender(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static Gender fromValue(String value)
    {
        for (Gender gender: Gender.values())
        {
            if (gender.getValue().equals(value))
            {
                return gender;
            }
        }
        return null;
    }

}
