package sample;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;

import java.awt.*;

public class MapPane extends Pane {
    private ToggleButton b1;
    private ToggleButton b2;
    private ToggleButton b3;
    private ToggleButton b4;
    private ToggleButton b5;
    private ToggleButton b6;
    private ToggleButton b7;
    private ToggleButton b8;
    private ToggleButton b9;
    private ToggleButton b10;
    final ToggleGroup group = new ToggleGroup();
    private Label label;
    private Circle circle;

    public ToggleGroup getGroup() { return group; }

    public MapPane() {
        double r=20;

        label = new Label("Pick Your Location");
        label.relocate(355, 10);
        label.setStyle("-fx-font: 16 arial; ");

        b1 = new ToggleButton("A");
        b1.setShape(new Circle(r));
        b1.setMinSize(2*r, 2*r);
        b1.setMaxSize(2*r, 2*r);
        b1.relocate(40, 40);
        b1.setToggleGroup(group);

        b2 = new ToggleButton("B");
        b2.setShape(new Circle(r));
        b2.setMinSize(2*r, 2*r);
        b2.setMaxSize(2*r, 2*r);
        b2.relocate(100, 170);
        b2.setToggleGroup(group);

        b3 = new ToggleButton("C");
        b3.setShape(new Circle(r));
        b3.setMinSize(2*r, 2*r);
        b3.setMaxSize(2*r, 2*r);
        b3.relocate(400, 40);
        b3.setToggleGroup(group);

        b4 = new ToggleButton("D");
        b4.setShape(new Circle(r));
        b4.setMinSize(2*r, 2*r);
        b4.setMaxSize(2*r, 2*r);
        b4.relocate(650, 420);
        b4.setToggleGroup(group);


        b5 = new ToggleButton("E");
        b5.setShape(new Circle(r));
        b5.setMinSize(2*r, 2*r);
        b5.setMaxSize(2*r, 2*r);
        b5.relocate(70, 380);
        b5.setToggleGroup(group);


        b6 = new ToggleButton("F");
        b6.setShape(new Circle(r));
        b6.setMinSize(2*r, 2*r);
        b6.setMaxSize(2*r, 2*r);
        b6.relocate(10, 280);
        b6.setToggleGroup(group);


        b7 = new ToggleButton("G");
        b7.setShape(new Circle(r));
        b7.setMinSize(2*r, 2*r);
        b7.setMaxSize(2*r, 2*r);
        b7.relocate(270, 140);
        b7.setToggleGroup(group);


        b8 = new ToggleButton("H");
        b8.setShape(new Circle(r));
        b8.setMinSize(2*r, 2*r);
        b8.setMaxSize(2*r, 2*r);
        b8.relocate(590, 300);
        b8.setToggleGroup(group);

        b9 = new ToggleButton("I");
        b9.setShape(new Circle(r));
        b9.setMinSize(2*r, 2*r);
        b9.setMaxSize(2*r, 2*r);
        b9.relocate(700, 60);
        b9.setToggleGroup(group);

        b10 = new ToggleButton("J");
        b10.setShape(new Circle(r));
        b10.setMinSize(2*r, 2*r);
        b10.setMaxSize(2*r, 2*r);
        b10.relocate(400, 350);
        b10.setToggleGroup(group);

        circle = new Circle(15);
        circle.relocate(380, 210);

        Label rest = new Label("Duma's Restaurant");
        rest.relocate(350, 240);

        getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10, circle, label, rest);
        this.setStyle("-fx-background-color: lightgreen ;");
    }


}
