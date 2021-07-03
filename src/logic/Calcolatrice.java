package logic;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane; 
import java.awt.event.ActionListener;
public class Calcolatrice extends Application {


	
	
	
	Button buttonsub;
	Button buttonmlt;
	Button buttondiv;
	Button buttonclear;
	Button buttonsum;
	Button buttoneq;
	
	int i=1;
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calcolatrice");
	
		
		
		
		TextField text=new TextField();
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.BASELINE_CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		
		
		Scene scene = new Scene(gridPane, 300, 200);//la prima coordinata è larghezza,la seconda altezza
		
		
	
		buttonsub=new Button("-");
		buttonmlt=new Button("*");
		buttondiv=new Button("/");
		buttonsum=new Button("+");
		buttoneq=new Button("=");
		buttonclear=new Button("Clear");

		gridPane.add(text,0,0, 4, 1);
		gridPane.add(buttonsub, 0, 1); 
		gridPane.add(buttonmlt, 2,1); 
		gridPane.add(buttondiv, 3, 1); 
		gridPane.add(buttonsum, 1,1);
		gridPane.add(buttoneq,0,2,4,1); 
		gridPane.add(buttonclear,0,3,4,1);

		class MyEventHandler implements EventHandler {
			 private double result;
			 private String op;
			 
			 
			 public MyEventHandler(double result) {
			 this.result = result;
			 op = "nop";
			 }
			 
			@Override
			public void handle(Event e) {

				
					double num;
					String operazione;
					num = Double.parseDouble(text.getText());//prelevo il testo dalla barra text
					if(e.getSource()==buttonclear) {
						text.setText("");
						text.requestFocus();
						result=0;
						op="nop";
						
					}
					if(e.getSource()==buttonsum) {
						text.setText("+");
						result=result+num;
						text.requestFocus();
						op="+";
					}
					if(e.getSource()==buttondiv) {
						text.setText("/");
						result=result+num;
						text.requestFocus();
						op="/";
					}
					if(e.getSource()==buttonsub) {
						text.setText("-");
						result=result+num;
						text.requestFocus();
						op="-";
					}
					if(e.getSource()==buttonmlt) {
						text.setText("*");
						result=result+num;
						text.requestFocus();
						op="*";
					}
					
					if(e.getSource()==buttoneq) {
						text.setText("=");
						if(op=="+") {
							result=result+num;
							text.setText(""+result);
							text.requestFocus();
						}
						if(op=="*") {
							result=result*num;
							text.setText(""+result);
							text.requestFocus();
						}
						if(op=="/") {
							if(num>0) {
							
							result=result/num;
							text.setText(""+result);
							text.requestFocus();
							}
							if(num==0) {
								Label label=new Label();
								label.setText("Impossibile dividere per 0");
								gridPane.add(label,0,6,5,1);
								text.requestFocus();
							}
						}
						if(op=="-") {
							result=result - num;
							text.setText(""+result);
							text.requestFocus();
						}
						
					}
					
				}
			}
					
		
		MyEventHandler eh=new MyEventHandler(0);
		buttonsum.setOnAction(eh);
		buttonsub.setOnAction(eh);
		buttonmlt.setOnAction(eh);
		buttondiv.setOnAction(eh);
		buttoneq.setOnAction(eh);
		buttonclear.setOnAction(eh);
		 
		stage.setScene(scene);
		stage.show();
		
	
	
	
	
}
}




