package opgaver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Opgave5 extends Application {
	private Pane drawPane;
	private TextField triangleOrder;

	private static final int SIZE_LENGTH = 470;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Sierpinski Triangle");
		GridPane pane = new GridPane();
		drawPane = new Pane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private void initContent(GridPane pane) {
		pane.setVgap(10);
		pane.setHgap(10);

		drawPane.setPrefSize(500, 500);
		pane.add(drawPane, 1, 0, 1, 4);

		Button drawSierPinski = new Button("Draw Sierpienski triangle");
		pane.add(drawSierPinski, 0, 0);
		drawSierPinski.setOnAction(event -> drawAction());

		triangleOrder = new TextField();
		pane.add(triangleOrder, 0, 1);
		triangleOrder.setText("0");

		Button clear = new Button("Clear");
		pane.add(clear, 0, 2);
		clear.setOnAction(event -> clearAction());

		GridPane buttonPane = new GridPane();

		Button zero = new Button("0");
		buttonPane.add(zero, 0, 0);
		zero.setOnAction(event -> drawAction(0));

		Button one = new Button("1");
		buttonPane.add(one, 1, 0);
		one.setOnAction(event -> drawAction(1));

		Button two = new Button("2");
		buttonPane.add(two, 2, 0);
		two.setOnAction(event -> drawAction(2));

		Button three = new Button("3");
		buttonPane.add(three, 0, 1);
		three.setOnAction(event -> drawAction(3));

		Button four = new Button("4");
		buttonPane.add(four, 1, 1);
		four.setOnAction(event -> drawAction(4));

		Button five = new Button("5");
		buttonPane.add(five, 2, 1);
		five.setOnAction(event -> drawAction(5));

		Button six = new Button("6");
		buttonPane.add(six, 0, 3);
		six.setOnAction(event -> drawAction(6));

		Button seven = new Button("7");
		buttonPane.add(seven, 1, 3);
		seven.setOnAction(event -> drawAction(7));

		Button eight = new Button("8");
		buttonPane.add(eight, 2, 3);
		eight.setOnAction(event -> drawAction(8));

		pane.add(buttonPane, 0, 3);
		buttonPane.setVgap(10);
		buttonPane.setHgap(10);
		buttonPane.setGridLinesVisible(true);
	}

	private void drawAction() {
		int orderOfTriangle = Integer.valueOf(triangleOrder.getText().trim());

		clearAction();

		helper2(orderOfTriangle, 10, 490, SIZE_LENGTH);
	}

	private void clearAction() {
		drawPane.getChildren().clear();
	}

	private void drawAction(int nOrder) {
		clearAction();

		helper2(nOrder, 10, 490, SIZE_LENGTH);
	}

	private void helper2(int n, double firstPointX, double firstPointY, double length) {
		if (n == 0) {
			double pointTwoX = firstPointX + length;
			double pointTwoY = firstPointY;
			double pointThreeX = firstPointX + (length / 2);

			double pointThreeY = pointTwoY - calcPointThreeY2(length, length / 2);

			Polygon polygon = new Polygon(firstPointX, firstPointY, pointTwoX, pointTwoY, pointThreeX, pointThreeY);
			drawPane.getChildren().add(polygon);
			polygon.setFill(Color.WHITE);
			polygon.setStroke(Color.BLACK);
		} else {
			helper2(n - 1, firstPointX, firstPointY, length / 2);
			helper2(n - 1, firstPointX + (length / 2), firstPointY, length / 2);
			helper2(n - 1, firstPointX + (length / 4), (firstPointY - calcPointThreeY2(length / 2, length / 4)),
					length / 2);
		}
	}

	private double calcPointThreeY2(double lengthHyp, double lengthKat) {
		return Math.sqrt(Math.pow(lengthHyp, 2) - Math.pow(lengthKat / 4, 2));
	}
}