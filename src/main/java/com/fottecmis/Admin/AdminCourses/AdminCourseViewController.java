package com.fottecmis.Admin.AdminCourses;

import com.fottecmis.Admin.AdminDashboard;
import com.fottecmis.Shared.Modules.Course.Course;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminCourseViewController extends AdminDashboard {
    private int admin_id;
    List<Course> Courses = new ArrayList<>();
    @FXML
    public TableView<Course> adminCourseView;
    private Connection connection;
    @FXML
    private TextField course_name;
    @FXML
    private TextField course_credit;
    @FXML
    private TextField course_level;
    @FXML
    private TextField course_semester;
    @FXML
    private TextField course_hour;
    @FXML
    private Pane courseEditor;
    @FXML
    private Button form_action_button;
    @FXML
    private Button delete_button;
    @FXML
    private Label feedback;


    public void initialize(int user_id, Connection connection) {
        this.admin_id = user_id;
        this.connection = connection;

        adminCourseView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                clearFields();
                // clear feedback label
                feedback.setText("");
                Course selectedCourse = newSelection;
                course_name.setText(selectedCourse.getCourse_name());
                course_credit.setText(String.valueOf(selectedCourse.getCredit()));
                course_level.setText(String.valueOf(selectedCourse.getLevel()));
                course_semester.setText(String.valueOf(selectedCourse.getSemester()));
                course_hour.setText(String.valueOf(selectedCourse.getCourse_hour()));
                courseEditor.setVisible(true);
                form_action_button.setText("Update Course");
                delete_button.setVisible(true);
            }
        });
    }

    public void showAdminCourses() {
        try {
            Courses = new AdminCourseController(connection).getAllCourses();
            adminCourseView.setItems(FXCollections.observableList(Courses));
            createTableView();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTableView() {
        if (this.Courses == null) {
            System.out.println("No courses found");
            return;
        }

        // course id
        TableColumn<Course, Integer> courseId = new TableColumn<>("ID");
        courseId.setCellValueFactory(new PropertyValueFactory<>("course_id"));

        // course name
        TableColumn<Course, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));

        // course level
        TableColumn<Course, Integer> courseLevel = new TableColumn<>("Level");
        courseLevel.setCellValueFactory(new PropertyValueFactory<>("level"));

        // course semester
        TableColumn<Course, Integer> courseSemester = new TableColumn<>("Semester");
        courseSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));

        // course credit
        TableColumn<Course, Integer> courseCredit = new TableColumn<>("Credit");
        courseCredit.setCellValueFactory(new PropertyValueFactory<>("credit"));

        // course hour
        TableColumn<Course, Integer> courseHour = new TableColumn<>("Hour");
        courseHour.setCellValueFactory(new PropertyValueFactory<>("course_hour"));

//        clear columns
        adminCourseView.getColumns().clear();
//        add columns to table view
        adminCourseView.getColumns().addAll(courseId, courseName, courseLevel, courseSemester, courseCredit, courseHour);

    }
    public void showNewCourse() {
        clearFields();
        courseEditor.setVisible(true);
        form_action_button.setText("Add Course");
        delete_button.setVisible(false);    //default
//        delete_button.setVisible(true);

    }
    public void actionButtonHandler() {
        if (form_action_button.getText().equals("Add Course")) {
            createCourse();
        } else {
            updateCourse();
        }
    }
    public void createCourse() {
//        hide feedback label
        feedback.setVisible(false);
//        feedback.setVisible(true);


        Course newCourse = new Course();
        newCourse.setCourse_name(course_name.getText());
        newCourse.setLevel(Integer.parseInt(course_level.getText()));
        newCourse.setSemester(Integer.parseInt(course_semester.getText()));
        newCourse.setCourse_hour(Integer.parseInt(course_hour.getText()));
        newCourse.setCredit(Integer.parseInt(course_credit.getText()));

//        implement department id - currenlty hared coded
        newCourse.setDepartmentId(1);
        newCourse.setIs_gpa(1);
        newCourse.setCourse_code("CSE101");

        try {
            new AdminCourseController(connection).createCourse(newCourse);
            feedback.setVisible(true);
            feedback.setStyle("-fx-text-fill: green");
            feedback.setText("Course added successfully");
            showAdminCourses();
            clearFields();

        } catch (Exception e) {
            feedback.setVisible(true);
            feedback.setStyle("-fx-text-fill: red");
            feedback.setText("Failed to add course");
            e.printStackTrace();
        }
    }
    public void updateCourse() {
        //hide feedback label
        feedback.setVisible(false);
        Course selectedCourse = adminCourseView.getSelectionModel().getSelectedItem();
        if (selectedCourse == null) {
            System.out.println("No notice selected");
            return;
        }
        try {
            Course updatedCourse = new Course();
            updatedCourse.setCourse_name(course_name.getText());
            updatedCourse.setLevel(Integer.parseInt(course_level.getText()));
            updatedCourse.setSemester(Integer.parseInt(course_semester.getText()));
            updatedCourse.setCourse_hour(Integer.parseInt(course_hour.getText()));
            updatedCourse.setCredit(Integer.parseInt(course_credit.getText()));

            new AdminCourseController(connection).updateCourse(selectedCourse.getCourse_id(), updatedCourse);

            //visible feedback lable in green color
            feedback.setVisible(true);
            feedback.setStyle("-fx-text-fill: green");
            feedback.setText("Course updated successfully");
            showAdminCourses();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    delete course
    public void deleteSelectedCourse() {
        //hide feedback label
        feedback.setVisible(false);
        Course selectedCourse = adminCourseView.getSelectionModel().getSelectedItem();
        if (selectedCourse == null) {
            System.out.println("No course selected");
            return;
        }
        try {
            new AdminCourseController(connection).deleteCourse(selectedCourse.getCourse_id());
            //visible feedback lable in green color
            feedback.setVisible(true);
            feedback.setStyle("-fx-text-fill: green");
            feedback.setText("Course deleted successfully");
            showAdminCourses();
            clearFields();
        } catch (Exception e) {
            feedback.setVisible(true);
            feedback.setStyle("-fx-text-fill: red");
            feedback.setText("Failed to delete course");
            e.printStackTrace();
        }
    }
    private void clearFields() {
        course_name.clear();
        course_credit.clear();
        course_level.clear();
        course_semester.clear();
        course_hour.clear();

    }

}
