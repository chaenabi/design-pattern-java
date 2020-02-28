package chapter1;

public class Person {

    private Phone[] phone;
    private Phone homePhone;
    private Phone officePhone;

    public Person() {
        this.phone = new Phone[2];
    }

    public Phone getPhoneType(String phoneType) {

        switch(phoneType) {
            case "homePhone" : return phone[0];
            case "officePhone" : return phone[1];
            default: throw new Error("그런 용도의 핸드폰은 없습니다");
        }
    }

    public Phone[] getPhone() {
        return phone;
    }

    public Phone getHomePhone() {
        return homePhone;
    }

    public Phone getOfficePhone() {
        return officePhone;
    }
}

class Phone {
    private String phoneNumber;
    private String role;
}

