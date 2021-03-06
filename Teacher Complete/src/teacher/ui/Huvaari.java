package teacher.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import teacher.launch.Launcher;

public class Huvaari {
    
    private FlowPane leftFp;
    
    public Huvaari(){
        
        leftFp = new FlowPane(20,20);
        leftFp.setPrefSize(250, 708);
        leftFp.setStyle("-fx-background-color: #F6F6F7");
        leftFp.setAlignment(Pos.CENTER);
         
        Label nameLbl = new Label("Хичээлийн хуваарь");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(270, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setId("text");
       
        FlowPane huvaariFp = new FlowPane();
        
        huvaariFp.setPrefSize(220, 500);
        huvaariFp.getChildren().add(new Label("adasd as"));       
        huvaariFp.setId("panel");
                
        FlowPane textFp = new FlowPane(10,5);
        textFp.setPrefSize(200, 180);
       
        
        Label irtsLb = new Label("Ирц бүртгэх");
        irtsLb.setPrefSize(200, 20);
        irtsLb.setId("btns");
        irtsLb.setOnMousePressed(boov -> {
            TeacherMain.changeLeft(Launcher.getHUVAARI().getContainer());
            TeacherMain.changeCenter(Launcher.getIDEVHI().getContainer());
            TeacherMain.changeRight(null);
        });
        
        irtsLb.setAlignment(Pos.CENTER);
        Label dunLb = new Label("Явцын дүн оруулах");
        dunLb.setPrefSize(200, 20);
        dunLb.setId("btns");
        
        dunLb.setAlignment(Pos.CENTER);
        Label idevhLb = new Label("Идэвхийн дүн оруулах");
        idevhLb.setPrefSize(200, 20);
        idevhLb.setId("btns");
        
        idevhLb.setAlignment(Pos.CENTER);
        Label allLb = new Label("Нийт ирц");
        allLb.setPrefSize(200, 20);
        allLb.setAlignment(Pos.CENTER);
        allLb.setId("btns");
        
        ///events
        
        textFp.getChildren().addAll(irtsLb,dunLb,idevhLb,allLb);
        leftFp.getChildren().addAll(nameLbl, new Inner_huvaari().getContainer(), textFp);
        leftFp.setId("border");
    }
    public FlowPane getContainer() {
        return this.leftFp;
    }
}