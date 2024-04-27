package com.fottecmis.Notice;

import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeController  {
    public TableView<Notice> noticeTableView;
    private int noticeId;
    private Connection connection;
    List<Notice> notices= new ArrayList<>();

    public void initialize(int noticeId,Connection connection){
        this.noticeId=noticeId;
        this.connection=connection;
    }

    public void showNotice(){
        if(connection==null){
            System.out.println(noticeId);
            System.out.println("Connection is null");
            return;
        }
        try{
            PreparedStatement getNotice = connection.prepareStatement("SELECT date FROM notice;");
            getNotice.setInt(1, noticeId);
        }

        if(!getNotice.getResultSet().next()){
            Notice notice = new Notice();
            notice.setDate(notice.getResultSet().getDate("date"));
            notice.setTitle(notice.getResultSet().getString("description"));
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}


/*package com.fottecmis.Notice;

import com.fottecmis.Shared.DatabaseConnectionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class NoticeController {

    @FXML
    private Button about_us;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button dashbord;

    @FXML
    private TableColumn<Notice, String> date;

    @FXML
    private TableColumn<Notice, String> description;

    @FXML
    private Button faq;


    @FXML
    private Button logout;

    @FXML
    private Text notices_text;

    @FXML
    private TableView<Notice> table;

    private Stage stage;
    private Scene scene;

    public void initialize() throws DatabaseConnectionException {

        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

        loadTable();
    }
    public void showNotices(ActionEvent event) throws Exception {
        Parent loginscene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/fottecmis/Interfaces/Notice/view-notice.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }


    public void loadTable() throws DatabaseConnectionException {

        NoticeDatabaseConnection dc = new NoticeDatabaseConnection();
        Connection con = dc.getNoticeConnection();

        try {

            Statement stmt = con.createStatement();
            String myStatement = "SELECT * FROM notice";
            ResultSet rs = stmt.executeQuery(myStatement);

            while (rs.next()) {
                Notice noti = new Notice(rs.getString("date"), rs.getString("description"));
                table.getItems().add(noti);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}*/
























/*package com.fottecmis.Notice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class NoticeController {

    @FXML
    private Button about_us;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button dashbord;

    @FXML
    private TableColumn<Notice, String> date;

    @FXML
    private TableColumn<Notice, String> description;

    @FXML
    private Button faq;

    @FXML
    private Button logout;

    @FXML
    private Text notices_text;

    @FXML
    private TableView<Notice> table;

    private Stage stage;
    private Scene scene;

    public void showNotices(ActionEvent event) throws Exception {
        Parent loginscene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/fottecmis/Interfaces/Notice/view-notice.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(loginscene);
        stage.setScene(scene);
        stage.show();
    }

    public ResultSet getNotices() {

//        code here
//        create database connection - NoticeDatabaseConnection
        public void initialize() {

            date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
            description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

            loadTable();
        }
        public void loadTable() {

            NoticeDatabaseConnection dc = new NoticeDatabaseConnection();
            Connection con = dc.getConnection();

            try {

                Statement stmt = con.createStatement();
                String myStatement = "SELECT * FROM notice";
                ResultSet rs = stmt.executeQuery(myStatement);

                while (rs.next()) {
                    Notice noti = new Notice(rs.getString("date"), rs.getString("description"));
                    Notice.getItems().add(noti);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
//        get notices from database
        return null;
   }
}
*/