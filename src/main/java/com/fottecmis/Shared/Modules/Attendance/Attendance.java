package com.fottecmis.Shared.Modules.Attendance;

public class Attendance {
    protected int attendance_id;
    protected int student_id;
    protected int course_id;
    protected int medical_id;
    protected String attendance_staus;
    protected String attendance_date;

    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public int getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getMedical_id() {
        return medical_id;
    }

    public void setMedical_id(int medical_id) {
        this.medical_id = medical_id;
    }

    public String getAttendance_staus() {
        return attendance_staus;
    }

    public void setAttendance_staus(String attendance_staus) {
        this.attendance_staus = attendance_staus;
    }

}
