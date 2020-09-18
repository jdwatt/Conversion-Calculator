
package practicegui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



public class PracticeGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane bp= new BorderPane();
        GridPane gp= new GridPane();
        Label feetLabel= new Label("Feet");
        Label inchLabel= new Label("Inches");
        TextField feet= new TextField("");
        TextField inches= new TextField("");
        Button convert= new Button("Convert");
        Label centi= new Label("Centimeters");
        TextField cm= new TextField("");
        Button clear= new Button("Clear");
        Button exit= new Button("Exit");
        Button swap= new Button("Swap");
        Button weight= new Button("Weight");
        weight.setStyle("-fx-background-color: LIGHTCYAN");
        gp.add(feetLabel, 0, 0);
        gp.add(inchLabel, 0, 1);
        gp.add(feet, 1, 0);
        gp.add(inches, 1, 1);
        gp.add(centi, 0, 2);
        gp.add(cm,1,2);
        gp.setHgap(15);
        gp.setVgap(10);
        bp.setStyle("-fx-background-color:LAVENDER");
        convert.setStyle("-fx-background-color: MINTCREAM");
        HBox hbox= new HBox(15);
        hbox.getChildren().addAll(convert,clear,exit,swap,weight);
        bp.setCenter(gp);
        bp.setBottom(hbox);      
        clear.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            feet.setText("");
            inches.setText("");
            cm.setText("");
        }
    });
        exit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.exit(0);
            }
            
        });
        convert.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                 double ft;
                double in;
                double cms;   
                Alert alert= new Alert(AlertType.ERROR);
                
                ft= Double.parseDouble(feet.getText());
                in= Double.parseDouble(inches.getText());
                
                    
                
                    if (in>=12||in<0){
                        alert.setContentText("Invalid Height");
                        alert.show();
                    }else if(centi.getText().equalsIgnoreCase("Centimeters")){
                    cms=2.54*(12*ft+in);
                    cm.setText(Double.toString(cms));
                            }
                        else if (centi.getText().equalsIgnoreCase("inches")){
                    
                    double holder=(double)ft/2.54;
                    double mod= (double)holder%12;
                    int feets=(int)(holder/12);               
                    String cmT= Double.toString(mod);
                    String feetT= Double.toString(feets);
                    cm.setText(cmT.substring(0, 1));
                    inches.setText(feetT.substring(0, 1));
                }
                    }
                 });
          swap.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                if(feetLabel.getText().equals("Feet")){
                feetLabel.setText("Centimeters");
                inchLabel.setText("Feet");
                centi.setText("Inches");
                feet.setText("0");
                inches.setText("0");
                cm.setText("0");
                }else{
                    feetLabel.setText("Feet");
                    inchLabel.setText("Inches");
                    centi.setText("Centimeters");
                    feet.setText("0");
                    inches.setText("0");
                    cm.setText("0");
                }
            }
        
    });
          weight.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            WeightConversion wc= new WeightConversion(); 
            wc.gui();
            primaryStage.close();
          }
    });
        StackPane root = new StackPane();
        root.getChildren().add(bp);
        
        Scene scene = new Scene(root, 320, 150);
        
        primaryStage.setTitle("CM conversion Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }  
       
    

    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
