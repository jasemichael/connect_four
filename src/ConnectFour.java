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
				//VERTICAL
				for(int vi=0; vi<6; vi++){
					VBox vv = (VBox) pane.getChildren().get(vi);
					for(int vj=5; vj>2; vj--){
						Circle c1 = (Circle) vv.getChildren().get(vj);
						Circle c2 = (Circle) vv.getChildren().get(vj-1);
						Circle c3 = (Circle) vv.getChildren().get(vj-2);
						Circle c4 = (Circle) vv.getChildren().get(vj-3);
						if((c1.getFill() == Color.YELLOW && c2.getFill() == Color.YELLOW && c3.getFill() == Color.YELLOW && c4.getFill() == Color.YELLOW) || (c1.getFill() == Color.RED && c2.getFill() == Color.RED && c3.getFill() == Color.RED && c4.getFill() == Color.RED)){
							//FLASHING WIN
							//DISK 1
							FillTransition fillTrans1 = new FillTransition(Duration.millis(1000));
							fillTrans1.setShape(c1);
							fillTrans1.setFromValue(Color.BLACK);
							fillTrans1.setToValue(color);
							fillTrans1.setCycleCount(50);
							fillTrans1.setAutoReverse(true);
							fillTrans1.play();
							//DISK 2
							FillTransition fillTrans2 = new FillTransition(Duration.millis(1000));
							fillTrans2.setShape(c2);
							fillTrans2.setFromValue(Color.BLACK);
							fillTrans2.setToValue(color);
							fillTrans2.setCycleCount(50);
							fillTrans2.setAutoReverse(true);
							fillTrans2.play();
							//DISK 3
							FillTransition fillTrans3 = new FillTransition(Duration.millis(1000));
							fillTrans3.setShape(c3);
							fillTrans3.setFromValue(Color.BLACK);
							fillTrans3.setToValue(color);
							fillTrans3.setCycleCount(50);
							fillTrans3.setAutoReverse(true);
							fillTrans3.play();
							//DISK 4
							FillTransition fillTrans4 = new FillTransition(Duration.millis(1000));
							fillTrans4.setShape(c4);
							fillTrans4.setFromValue(Color.BLACK);
							fillTrans4.setToValue(color);
							fillTrans4.setCycleCount(50);
							fillTrans4.setAutoReverse(true);
							fillTrans4.play();
							//Disable clicking
							for(int q=0; q<7; q++){
								VBox vq = (VBox) pane.getChildren().get(q);
								vq.setOnMouseClicked(null);
							}
						}
					}
				}
				//HORIZONTAL
				for(int hi=0; hi<4; hi++){
					VBox hv1 = (VBox) pane.getChildren().get(hi);
					VBox hv2 = (VBox) pane.getChildren().get(hi+1);
					VBox hv3 = (VBox) pane.getChildren().get(hi+2);
					VBox hv4 = (VBox) pane.getChildren().get(hi+3);
					for(int hj=5; hj>=0; hj--){
						Circle hc1 = (Circle) hv1.getChildren().get(hj);
						Circle hc2 = (Circle) hv2.getChildren().get(hj);
						Circle hc3 = (Circle) hv3.getChildren().get(hj);
						Circle hc4 = (Circle) hv4.getChildren().get(hj);
						if((hc1.getFill() == Color.YELLOW && hc2.getFill() == Color.YELLOW && hc3.getFill() == Color.YELLOW && hc4.getFill() == Color.YELLOW) || (hc1.getFill() == Color.RED && hc2.getFill() == Color.RED && hc3.getFill() == Color.RED && hc4.getFill() == Color.RED)){
							//FLASHING WIN
							//DISK 1
							FillTransition fillTrans1 = new FillTransition(Duration.millis(1000));
							fillTrans1.setShape(hc1);
							fillTrans1.setFromValue(Color.BLACK);
							fillTrans1.setToValue(color);
							fillTrans1.setCycleCount(50);
							fillTrans1.setAutoReverse(true);
							fillTrans1.play();
							//DISK 2
							FillTransition fillTrans2 = new FillTransition(Duration.millis(1000));
							fillTrans2.setShape(hc2);
							fillTrans2.setFromValue(Color.BLACK);
							fillTrans2.setToValue(color);
							fillTrans2.setCycleCount(50);
							fillTrans2.setAutoReverse(true);
							fillTrans2.play();
							//DISK 3
							FillTransition fillTrans3 = new FillTransition(Duration.millis(1000));
							fillTrans3.setShape(hc3);
							fillTrans3.setFromValue(Color.BLACK);
							fillTrans3.setToValue(color);
							fillTrans3.setCycleCount(50);
							fillTrans3.setAutoReverse(true);
							fillTrans3.play();
							//DISK 4
							FillTransition fillTrans4 = new FillTransition(Duration.millis(1000));
							fillTrans4.setShape(hc4);
							fillTrans4.setFromValue(Color.BLACK);
							fillTrans4.setToValue(color);
							fillTrans4.setCycleCount(50);
							fillTrans4.setAutoReverse(true);
							fillTrans4.play();
							for(int q=0; q<7; q++){
								VBox vq = (VBox) pane.getChildren().get(q);
								vq.setOnMouseClicked(null);
							}
						}
					}
				}
				//DIAGONAL: LEFT TO RIGHT
				for(int di=0; di<4; di++){
					VBox dv1 = (VBox) pane.getChildren().get(di);
					VBox dv2 = (VBox) pane.getChildren().get(di+1);
					VBox dv3 = (VBox) pane.getChildren().get(di+2);
					VBox dv4 = (VBox) pane.getChildren().get(di+3);
					for(int dj=5; dj>2; dj--){
						Circle dc1 = (Circle) dv1.getChildren().get(dj);
						Circle dc2 = (Circle) dv2.getChildren().get(dj-1);
						Circle dc3 = (Circle) dv3.getChildren().get(dj-2);
						Circle dc4 = (Circle) dv4.getChildren().get(dj-3);
						if((dc1.getFill() == Color.YELLOW && dc2.getFill() == Color.YELLOW && dc3.getFill() == Color.YELLOW && dc4.getFill() == Color.YELLOW) || (dc1.getFill() == Color.RED && dc2.getFill() == Color.RED && dc3.getFill() == Color.RED && dc4.getFill() == Color.RED)){
							//FLASHING WIN
							//DISK 1
							FillTransition fillTrans1 = new FillTransition(Duration.millis(1000));
							fillTrans1.setShape(dc1);
							fillTrans1.setFromValue(Color.BLACK);
							fillTrans1.setToValue(color);
							fillTrans1.setCycleCount(50);
							fillTrans1.setAutoReverse(true);
							fillTrans1.play();
							//DISK 2
							FillTransition fillTrans2 = new FillTransition(Duration.millis(1000));
							fillTrans2.setShape(dc2);
							fillTrans2.setFromValue(Color.BLACK);
							fillTrans2.setToValue(color);
							fillTrans2.setCycleCount(50);
							fillTrans2.setAutoReverse(true);
							fillTrans2.play();
							//DISK 3
							FillTransition fillTrans3 = new FillTransition(Duration.millis(1000));
							fillTrans3.setShape(dc3);
							fillTrans3.setFromValue(Color.BLACK);
							fillTrans3.setToValue(color);
							fillTrans3.setCycleCount(50);
							fillTrans3.setAutoReverse(true);
							fillTrans3.play();
							//DISK 4
							FillTransition fillTrans4 = new FillTransition(Duration.millis(1000));
							fillTrans4.setShape(dc4);
							fillTrans4.setFromValue(Color.BLACK);
							fillTrans4.setToValue(color);
							fillTrans4.setCycleCount(50);
							fillTrans4.setAutoReverse(true);
							fillTrans4.play();
							for(int q=0; q<7; q++){
								VBox vq = (VBox) pane.getChildren().get(q);
								vq.setOnMouseClicked(null);
							}
						}
					}
				}
				//DIAGONAL: RIGHT TO LEFT
				for(int dri=6; dri>2; dri--){
					VBox drv1 = (VBox) pane.getChildren().get(dri);
					VBox drv2 = (VBox) pane.getChildren().get(dri-1);
					VBox drv3 = (VBox) pane.getChildren().get(dri-2);
					VBox drv4 = (VBox) pane.getChildren().get(dri-3);
					for(int drj=5; drj>2; drj--){
						Circle drc1 = (Circle) drv1.getChildren().get(drj);
						Circle drc2 = (Circle) drv2.getChildren().get(drj-1);
						Circle drc3 = (Circle) drv3.getChildren().get(drj-2);
						Circle drc4 = (Circle) drv4.getChildren().get(drj-3);
						if((drc1.getFill() == Color.YELLOW && drc2.getFill() == Color.YELLOW && drc3.getFill() == Color.YELLOW && drc4.getFill() == Color.YELLOW) || (drc1.getFill() == Color.RED && drc2.getFill() == Color.RED && drc3.getFill() == Color.RED && drc4.getFill() == Color.RED)){
							//FLASHING WIN
							//DISK 1
							FillTransition fillTrans1 = new FillTransition(Duration.millis(1000));
							fillTrans1.setShape(drc1);
							fillTrans1.setFromValue(Color.BLACK);
							fillTrans1.setToValue(color);
							fillTrans1.setCycleCount(50);
							fillTrans1.setAutoReverse(true);
							fillTrans1.play();
							//DISK 2
							FillTransition fillTrans2 = new FillTransition(Duration.millis(1000));
							fillTrans2.setShape(drc2);
							fillTrans2.setFromValue(Color.BLACK);
							fillTrans2.setToValue(color);
							fillTrans2.setCycleCount(50);
							fillTrans2.setAutoReverse(true);
							fillTrans2.play();
							//DISK 3
							FillTransition fillTrans3 = new FillTransition(Duration.millis(1000));
							fillTrans3.setShape(drc3);
							fillTrans3.setFromValue(Color.BLACK);
							fillTrans3.setToValue(color);
							fillTrans3.setCycleCount(50);
							fillTrans3.setAutoReverse(true);
							fillTrans3.play();
							//DISK 4
							FillTransition fillTrans4 = new FillTransition(Duration.millis(1000));
							fillTrans4.setShape(drc4);
							fillTrans4.setFromValue(Color.BLACK);
							fillTrans4.setToValue(color);
							fillTrans4.setCycleCount(50);
							fillTrans4.setAutoReverse(true);
							fillTrans4.play();
							for(int q=0; q<7; q++){
								VBox vq = (VBox) pane.getChildren().get(q);
								vq.setOnMouseClicked(null);
							}
						}
					}
				}
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

	public static void main(String[] args) {
		System.out.println("Running GUI...");
		launch(args);
	}
}
