package com.fottecmis.Shared.Modules.Course;

public class Course {
    protected int course_id;
    protected String course_name;
    protected int departmentId;
    protected String is_gpa;
    protected int level;
    protected int semester;
    protected int course_hour;
    protected int credit;
    protected String course_code;

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_code() {
        return course_code;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getIs_gpa() {
        if (is_gpa.equals("GPA")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setIs_gpa(int is_gpa) {
        if (is_gpa == 1) {
            this.is_gpa = "GPA";
        } else {
            this.is_gpa = "CGPA";
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCourse_hour() {
        return course_hour;
    }

    public void setCourse_hour(int course_hour) {
        this.course_hour = course_hour;
    }
}
