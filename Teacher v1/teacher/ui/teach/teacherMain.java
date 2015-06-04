package teacher.ui;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import teacher.launch.Launcher;


public class teacherMain {
    
    private BorderPane rootNode;
    private Scene scene;
    private TextArea txtarea;
    
    
    public teacherMain(){
        Pane root = new Pane();
   
        rootNode = new BorderPane();        
        scene = new Scene(root, teacher.config.Config.STAGE_WIDTH, teacher.config.Config.STAGE_HEIGHT);
        
        ///// menu bar
        StackPane main = new StackPane();
        scene.getStylesheets().add(getClass().getResource("teacherUiStyle.css").toExternalForm());
        main.setStyle("-fx-background-color: #666666");
        main.setPrefHeight(60);
        
       
        FlowPane topFp = new FlowPane();
        topFp.setPrefSize(1024, 60);
        
        FlowPane centerPro = new FlowPane();
        FlowPane centerFp = new FlowPane();
        
        VBox s = new VBox();
        s.setAlignment(Pos.BASELINE_RIGHT);
        s.setPrefSize(150, 160);   
        s.setPadding(new Insets(2, 10, 10, 10));
        s.setVisible(false);
        s.setLayoutX(teacher.config.Config.STAGE_WIDTH-164);
        s.setLayoutY(60);
        s.setStyle("-fx-background-color: #666666 ");
        
        
//        centerPro.setVisible(true);
        
        
        main.getChildren().addAll(topFp);
        
           ////*Top*/////
        Label mainBtn = new Label("Үндсэн");
        mainBtn.setPrefSize(120, 60);
        mainBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        mainBtn.setAlignment(Pos.CENTER);
        mainBtn.setId("btn");
        
        Label hwBtn = new Label("Даалгавар");
        hwBtn.setPrefSize(120, 60);
        hwBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        hwBtn.setAlignment(Pos.CENTER);
        hwBtn.setId("btn");
        
        
        Label examBtn = new Label("Шалгалт авах");
        examBtn.setPrefSize(120, 60);
        examBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        examBtn.setAlignment(Pos.CENTER);
        examBtn.setId("btn");
        
        Label scoreBtn = new Label("Дүн оруулах");
        scoreBtn.setPrefSize(120, 60);
        scoreBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        scoreBtn.setAlignment(Pos.CENTER);
        scoreBtn.setId("btn");
        
        Label tailanBtn = new Label("Тайлан гаргах");
        tailanBtn.setPrefSize(120, 60);
        tailanBtn.setFont(javafx.scene.text.Font.font("Arial", 12));
        tailanBtn.setAlignment(Pos.CENTER);
        tailanBtn.setId("btn");
        
        FlowPane t = new FlowPane();
        t.setPrefSize(120, 60);
        
        
        Label teach = new Label("Багш ");
        teach.setPrefSize(150, 60);
//        teach.setTextFill(null);
        teach.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        teach.setAlignment(Pos.BASELINE_CENTER);
        teach.setId("downmenu");
        
      

     
        
        t.getChildren().add(teach);        
        t.setPadding(new Insets(0, 0, 0, 260));
        
        
        Label other = new Label(" Бусад");
        other.setPrefSize(150, 32);
        other.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        other.setStyle("-fx-text-fill:darkgrey");
        other.setId("downmenu");
//        other.setAlignment(Pos.CENTER_LEFT);
        other.setOnMouseExited(ae ->{
            s.setCursor(Cursor.DEFAULT);
            
        });
        other.setOnMouseMoved(ae-> {
      
        s.setCursor(Cursor.MOVE);
        });
   
   
        Label profile =new Label(" Мэдээлэл");
        profile.setPrefSize(150, 32);
        profile.setId("downmenu");
//        profile.setAlignment(Pos.BOTTOM_LEFT);
        profile.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,14));
        profile.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                rootNode.setCenter(new CenterPro().getContainer());
                if(s.isVisible()){
                    s.setVisible(false);
                }
            }
        });
        
        
        Label homework = new Label (" Даалгавар");
        homework.setPrefSize(150, 32);
//        homework.setAlignment(Pos.CENTER_LEFT);
        homework.setFont(Font.font("Arial",FontWeight.BOLD, 14));
        homework.setId("downmenu");
        homework.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (centerFp.isVisible()){
                    rootNode.setCenter(new homework().getContainer());
                    if(s.isVisible()){
                        s.setVisible(false);
                    }
                }
            }
        });
        
        Label set = new Label(" Тохиргоо");
        set.setPrefSize(150, 32);
        set.setAlignment(Pos.CENTER_LEFT);
        set.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        set.setId("downmenu");
        set.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Passwords sett = new Passwords(Launcher.getLogoutStage());
                if(s.isVisible()){
                    s.setVisible(false);
                }
               
            }
        });
        
        Label log = new Label(" Гарах");
//        log.setAlignment(Pos.CENTER_LEFT);
        log.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 14));
        log.setPrefSize( 150, 32);
//        log.setStyle("-fx-Background-color:#808080");
        log.setId("downmenu");
        log.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Logout log = new Logout(Launcher.getLogoutStage());
                                           
            }
        });
     
        
        s.getChildren().addAll(other, profile, homework, set, log);

        
        teach.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {  
                
                if (s.isVisible()) {
                    s.setVisible(false);
                    
                } 
                else { 
                    
                    s.setVisible(true);
                    
                }
            }
        });
      

//        Image logo = new Image("Logo.png");
//        ImageView Logo = new ImageView(logo);
//        Logo.setFitHeight(60);
//        Logo.setFitWidth(200);
//        Logo.setLayoutX(10);
//        Logo.setEffect(null);
              
        
        topFp.getChildren().addAll(mainBtn, hwBtn, examBtn, scoreBtn, tailanBtn, t);
       
        
        
        ////Center////
        
        
        
        centerFp.setPrefSize(524, 708);
        Label tessb = new Label("Оюутан 1-ын Гэрийн Даалгавар");
        tessb.setFont(new Font("Arial", 30));
        tessb.setPadding(new Insets(15, 10, 15, 30));
        centerFp.getChildren().add(tessb);
        centerFp.setStyle("-fx-background-color: white");
        txtarea = new TextArea();
        txtarea.setPrefSize(524, 643);
        centerFp.getChildren().add(txtarea);
        
      
        centerPro.setPrefSize(524, 708);
        Label Profile = new Label("Багшийн мэдээлэл");
        Profile.setFont(new Font("Arial", 30));
        Profile.setPadding(new Insets(15, 10, 15, 30));
        centerPro.getChildren().add(Profile);
        centerPro.setStyle("-fx-background-color: white");
        txtarea = new TextArea();
        txtarea.setPrefSize(524, 643);
        centerPro.getChildren().add(txtarea);
        
        rootNode.setTop(main);
        rootNode.setLeft(new homework().getContainer());
        rootNode.setRight(new Tree().getContainer());
        
        
        
        root.getChildren().addAll(rootNode, s);
        
        
    }
    
    public Scene getScene() {
        return this.scene;
    }
    
        
}