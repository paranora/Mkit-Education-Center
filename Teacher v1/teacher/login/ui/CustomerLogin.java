package teacher.login.ui;
//Bold-Erdene//
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import teacher.launch.Launcher;

/*
    CustomerLogin object үүсгэж байхад
    өөрийн зарлагдсан scene object-г
    getScene() функцээр авна.
*/
public class CustomerLogin implements teacher.config.Config {
    
    private Scene myScene;

    public CustomerLogin(Stage myStage) {
        myStage.setTitle("");
        Pane root =new Pane();
        FlowPane rootNode = new FlowPane(40, 20);
        rootNode.setAlignment(Pos.CENTER);
        myScene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);
        rootNode.setMaxSize(400, 500);
        rootNode.setLayoutX((STAGE_WIDTH - 400) / 2);
        rootNode.setLayoutY((STAGE_HEIGHT - 500) / 2);
        root.setStyle("-fx-background-color: #fff");
     
       
     
        myStage.setScene(myScene);
        myStage.setResizable(false);
       

        /*Гарчиг*/
        Label lbl = new Label("Хэрэглэгчийн Нэвтрэх Хэсэг");
        lbl.setFont(new Font("Arial", 30));
        lbl.setStyle("-fx-text-fill: white;");
        
        
        Image wall = new Image("teacher/resource/wall5.jpg");
        ImageView wall2 = new ImageView(wall);
        wall2.setFitHeight(780);
        wall2.setFitWidth(1050);
        root.getChildren().add(wall2);
        root.getChildren().add(rootNode);
        
        /*Хэрэглэгчийн нэрээ оруулах талбар*/
        TextField fld = new TextField();
        fld.setPromptText("Хэрэглэгчийн Нэр/Username");
        fld.setPrefSize(230, 30);

        /*Хэрэглэгчийн нууц үгээ оруулах талбар*/
        PasswordField fld2 = new PasswordField();
        fld2.setPromptText("Хэрэглэгчийн Нууц үг/Password");
        fld2.setPrefSize(230, 30);

        /*Хэрэглэгчийн нэр, нууц үгийг санана*/
        CheckBox box1 = new CheckBox("Намайг cана/Remember Me");
        box1.setStyle("-fx-text-fill: white;");
        box1.setPrefSize(200, 30);

        /*Шууд нэвтэрнэ*/
        CheckBox box2 = new CheckBox("Шууд нэвтрэх/Auto Login");
        box2.setStyle("-fx-text-fill: white;");
        box2.setPrefSize(200, 30);

        /*Нууц үгээ мартсан хэсэг, хулганаар даралт хийхэд нэмэлт цонх гарж ирнэ*/
        Label lbl2 = new Label("Нууц үгээ мартсан/Forget Password");
        lbl2.setStyle("-fx-text-fill: white;");
        lbl2.setPrefSize(200, 30);
        lbl2.setOnMousePressed(ae -> {
            lbl2.setStyle("-fx-text-fill: #E0E0EB;");
            Stage stage = new Stage();
            new PasswordReset().start(stage);
        });
        lbl2.setOnMouseMoved(ae -> {
            lbl2.setStyle("-fx-text-fill:#40AFFF;");
            myScene.setCursor(Cursor.HAND);
        });
        lbl2.setOnMouseExited(ae -> {
            myScene.setCursor(Cursor.DEFAULT);
            lbl2.setStyle("-fx-text-fill: white;");
        });

        /*Нэвтрэх button дээр дархад нэр нууц үг буруу байна гэсэн бичиг гарж ирнэ*/
        Pane pnl = new Pane();
        pnl.setVisible(false);
        pnl.setPrefSize(200, 30);
        Label aa = new Label("Username or Password Incorrect");
        aa.setStyle("-fx-text-fill: #F21624;");
        aa.setPadding(new Insets(5.5));
        pnl.getChildren().addAll(aa);

        /*Нэвтрэх button*/
        Button btn = new Button("Нэвтрэх");
        btn.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn.setPrefSize(200, 40);
        btn.setOnAction(ae -> {
            Launcher.setScene(Launcher.getTEACHER().getScene());
            String fld1 = (fld.getText());
            pnl.setVisible(true);
        });

        /*Болих button*/
        Button btn2 = new Button("Болих");
        btn2.setStyle("-fx-background-color: #2C53BF; -fx-text-fill: white;");
        btn2.setPrefSize(200, 40);
        btn2.setOnAction(ae -> {
            myStage.close();
            
        });
        
        rootNode.requestFocus();
        rootNode.getChildren().addAll(lbl, pnl, fld, fld2, box1, box2, lbl2, btn, btn2);
    }


    public Scene getScene() {
        return this.myScene;
    }
}