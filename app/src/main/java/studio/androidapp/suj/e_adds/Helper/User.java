package studio.androidapp.suj.e_adds.Helper;

public class User {



      private String f_name, l_name,email,phone,location,college,level,field_of_study,company,post,interest,id,reg_date,balance,status,age,sex;

    public User(String f_name, String l_name, String email, String phone, String location, String college, String level, String field_of_study, String company, String post, String interest, String id, String reg_date, String balance, String status, String age, String sex) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.college = college;
        this.level = level;
        this.field_of_study = field_of_study;
        this.company = company;
        this.post = post;
        this.interest = interest;
        this.id = id;
        this.reg_date = reg_date;
        this.balance = balance;
        this.status = status;
        this.age = age;
        this.sex = sex;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getCollege() {
        return college;
    }

    public String getLevel() {
        return level;
    }

    public String getField_of_study() {
        return field_of_study;
    }

    public String getCompany() {
        return company;
    }

    public String getPost() {
        return post;
    }

    public String getInterest() {
        return interest;
    }

    public String getId() {
        return id;
    }

    public String getReg_date() {
        return reg_date;
    }

    public String getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}

