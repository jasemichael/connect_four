import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.animation.FillTransition;
import javafx.util.Duration;

public class ConnectFour extends Application {
	static int WIDTH = 492;
	static int HEIGHT = 421;
	static boolean turn = true;
	
	@Override
	public void start(Stage stage) {
		FlowPane pane = new FlowPane();
		pane.setHgap(5);
		pane.setStyle("-fx-background-color: rgba(2, 2, 2, 0.5);");
		for(int i=0; i<7; i++){
			VBox v = new VBox();
			v.setSpacing(5);
			v.setOnMouseClicked(e -> {
				//SET COLORS;PLACE CHIPS
				Color color = null;
				if(turn == true){
					color = Color.YELLOW;
				}
				else {
					color = Color.RED;
				}
				for(int k=5; k>=0; k--){
					Circle c = (Circle) v.getChildren().get(k);
					if(c.getFill() != Color.YELLOW && c.getFill() != Color.RED){
						c.setFill(color);
						turn = !turn;
						break;
					}
				}

				//LOGIC
				checkWin(pane, color);
			});

			//Add circle to VBox then VBox to pane
			for(int j=0; j<6; j++){
				Circle c = new Circle(33);
				c.setFill(Color.WHITE);
				v.getChildren().add(c);
			}
			pane.getChildren().add(v);
		}

		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		stage.setTitle("Connect Four");
		stage.setScene(scene);
		stage.show();
	}

	public void flashDisk(Circle c1 , Color color){
		FillTransition fillTrans = new FillTransition(Duration.millis(1000));
		fillTrans.setShape(c1);
		fillTrans.setFromValue(Color.BLACK);
		fillTrans.setToValue(color);
		fillTrans.setCycleCount(50);
		fillTrans.setAutoReverse(true);
		fillTrans.play();
	}

	public void flashDisks(Circle c1, Circle c2, Circle c3, Circle c4, Color color){
		flashDisk(c1, color);
		flashDisk(c2, color);
		flashDisk(c3, color);
		flashDisk(c4, color);
	}

	public void disableClick(FlowPane pane){
		for(int q=0; q<7; q++){
			VBox vq = (VBox) pane.getChildren().get(q);
			vq.setOnMouseClicked(null);
		}
	}

	public void verticalLogic(FlowPane pane, Color color){
		for(int i=0; i<6; i++){
			VBox v = (VBox) pane.getChildren().get(i);
			for(int j=5; j>2; j--){
				Circle c1 = (Circle) v.getChildren().get(j);
				Circle c2 = (Circle) v.getChildren().get(j-1);
				Circle c3 = (Circle) v.getChildren().get(j-2);
				Circle c4 = (Circle) v.getChildren().get(j-3);
				if((c1.getFill() == Color.YELLOW && c2.getFill() == Color.YELLOW && c3.getFill() == Color.YELLOW && c4.getFill() == Color.YELLOW) || (c1.getFill() == Color.RED && c2.getFill() == Color.RED && c3.getFill() == Color.RED && c4.getFill() == Color.RED)){
					//FLASHING WIN
					flashDisks(c1, c2, c3, c4, color);
					//Disable clicking
					disableClick(pane);
				}
			}
		}
	}

	public void horizontalLogic(FlowPane pane, Color color){
		for(int i=0; i<4; i++){
			VBox v1 = (VBox) pane.getChildren().get(i);
			VBox v2 = (VBox) pane.getChildren().get(i+1);
			VBox v3 = (VBox) pane.getChildren().get(i+2);
			VBox v4 = (VBox) pane.getChildren().get(i+3);
			for(int j=5; j>=0; j--){
				Circle c1 = (Circle) v1.getChildren().get(j);
				Circle c2 = (Circle) v2.getChildren().get(j);
				Circle c3 = (Circle) v3.getChildren().get(j);
				Circle c4 = (Circle) v4.getChildren().get(j);
				if((c1.getFill() == Color.YELLOW && c2.getFill() == Color.YELLOW && c3.getFill() == Color.YELLOW && c4.getFill() == Color.YELLOW) || (c1.getFill() == Color.RED && c2.getFill() == Color.RED && c3.getFill() == Color.RED && c4.getFill() == Color.RED)){
					//FLASHING WIN
					flashDisks(c1, c2, c3, c4, color);
					//Disable clicking
					disableClick(pane);
				}
			}
		}
	}

	public void diagonalLeftToRight(FlowPane pane, Color color){
		for(int i=0; i<4; i++){
			VBox v1 = (VBox) pane.getChildren().get(i);
			VBox v2 = (VBox) pane.getChildren().get(i+1);
			VBox v3 = (VBox) pane.getChildren().get(i+2);
			VBox v4 = (VBox) pane.getChildren().get(i+3);
			for(int j=5; j>2; j--){
				Circle c1 = (Circle) v1.getChildren().get(j);
				Circle c2 = (Circle) v2.getChildren().get(j-1);
				Circle c3 = (Circle) v3.getChildren().get(j-2);
				Circle c4 = (Circle) v4.getChildren().get(j-3);
				if((c1.getFill() == Color.YELLOW && c2.getFill() == Color.YELLOW && c3.getFill() == Color.YELLOW && c4.getFill() == Color.YELLOW) || (c1.getFill() == Color.RED && c2.getFill() == Color.RED && c3.getFill() == Color.RED && c4.getFill() == Color.RED)){
					//FLASHING WIN
					flashDisks(c1, c2, c3, c4, color);
					//Disable clicking
					disableClick(pane);
				}
			}
		}
	}

	public void diagonalRightToLeft(FlowPane pane, Color color){
		for(int i=6; i>2; i--){
			VBox v1 = (VBox) pane.getChildren().get(i);
			VBox v2 = (VBox) pane.getChildren().get(i-1);
			VBox v3 = (VBox) pane.getChildren().get(i-2);
			VBox v4 = (VBox) pane.getChildren().get(i-3);
			for(int j=5; j>2; j--){
				Circle c1 = (Circle) v1.getChildren().get(j);
				Circle c2 = (Circle) v2.getChildren().get(j-1);
				Circle c3 = (Circle) v3.getChildren().get(j-2);
				Circle c4 = (Circle) v4.getChildren().get(j-3);
				if((c1.getFill() == Color.YELLOW && c2.getFill() == Color.YELLOW && c3.getFill() == Color.YELLOW && c4.getFill() == Color.YELLOW) || (c1.getFill() == Color.RED && c2.getFill() == Color.RED && c3.getFill() == Color.RED && c4.getFill() == Color.RED)){
					//FLASHING WIN
					flashDisks(c1, c2, c3, c4, color);
					//Disable clicking
					disableClick(pane);
				}
			}
		}
	}

	public void checkWin(FlowPane pane, Color color){
		//VERTICAL
		verticalLogic(pane, color);
		//HORIZONTAL
		horizontalLogic(pane, color);
		//DIAGONAL: LEFT TO RIGHT
		diagonalLeftToRight(pane, color);
		//DIAGONAL: RIGHT TO LEFT
		diagonalRightToLeft(pane, color);
	}
	public static void main(String[] args) {
		System.out.println("Running GUI...");
		launch(args);
	}
}
