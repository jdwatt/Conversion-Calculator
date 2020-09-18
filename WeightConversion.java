
package practicegui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class WeightConversion extends PracticeGUI{
    private double pounds;
    private double kilograms;
    
    
    public WeightConversion(){
        pounds=0;
        kilograms=0;
    }
    public void poundToKG(double pounds){
        kilograms=.453592*pounds;
    }
    public double getKG(){
        return kilograms;
    }
    public void kgToPound(double kilograms){
        pounds=2.20462*kilograms;
    }
    public double getLB(){
        return pounds;
    }
    public void gui(){
         BorderPane bp2= new BorderPane(); 
            WeightConversion wc= new WeightConversion();    
            GridPane gp2= new GridPane();
             HBox hb1= new HBox();
             HBox hb2= new HBox(30);
             StackPane root2= new StackPane();
             Label poundLabel= new Label ("Pounds");
             Label kgLabel= new Label ("Kilograms");
             TextField lbText= new TextField("");
             TextField kgText= new TextField("");
             Button con2= new Button("Convert");
             con2.setStyle("-fx-background-color:MINTCREAM");
             Button clear2= new Button("Clear");
             Button exit2= new Button("Exit");
             Button swap= new Button("Swap");
             Button height= new Button("Height");
             height.setStyle("-fx-background-color:LAVENDER");
             hb2.getChildren().addAll(con2,clear2,exit2,swap);
             hb1.getChildren().add(height);
             gp2.add(poundLabel, 0, 0);
             gp2.add(kgLabel,0,1);
             gp2.add(lbText,1,0);
             gp2.add(kgText,1,1);
             gp2.setHgap(25);
             gp2.setVgap(25);
             bp2.setTop(hb1);
             bp2.setCenter(gp2);
             bp2.setBottom(hb2);
             bp2.setStyle("-fx-background-color:LIGHTCYAN");
             root2.getChildren().add(bp2);
             Scene scene2= new Scene(root2, 320, 150);
             Stage secondaryStage= new Stage();
             secondaryStage.setTitle("Weight Conversion");
             secondaryStage.setScene(scene2);
             secondaryStage.show();
             con2.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event){
                     if (poundLabel.getText().equalsIgnoreCase("Pounds")){
                         pounds=Double.parseDouble(lbText.getText());
                         
                         wc.poundToKG(pounds);
                         kgText.setText(Double.toString(wc.getKG()));
                     } else{
                         kilograms= Double.parseDouble(lbText.getText());
                         wc.kgToPound(kilograms);
                         kgText.setText(Double.toString(wc.getLB()));
                     }
                 }
             });
             clear2.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event){
                     lbText.setText("0");
                     kgText.setText("0");
                 }
             });
             exit2.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event){
                     System.exit(0);
                 }
                 
             });
             swap.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event){
                     if(poundLabel.getText().equals("Pounds")){
                     poundLabel.setText("Kilograms");
                     kgLabel.setText("Pounds");
                     lbText.setText("0");
                     kgText.setText("0");
                     }else{
                         poundLabel.setText("Pounds");
                         kgLabel.setText("Kilograms");
                         lbText.setText("0");
                         kgText.setText("0");
                     }
                 }
             });
             height.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    PracticeGUI pg= new PracticeGUI();
                    Stage primaryStage= new Stage();
                    pg.start( primaryStage);
                    secondaryStage.close();
                    
                   
                }
             });
    }
    
}
