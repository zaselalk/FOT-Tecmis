package com.fottecmis.TestMap;

import com.fottecmis.Authenticate.AuthController;
import com.fottecmis.Notice.NoticeController;
import javafx.event.ActionEvent;

public class TestMapController {
    public void showLoginScene(ActionEvent event) {
        AuthController auth = new AuthController();
        try {
            auth.showLoginScreen(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showNoticeScene(ActionEvent event) {
        NoticeController notice = new NoticeController();
        try {
            notice.showNotices(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
