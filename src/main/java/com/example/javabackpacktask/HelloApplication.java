package com.example.javabackpacktask;

import javafx.application.Application;


import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 750, 400);

        TextField inputField = new TextField();
        Button addButton = new Button("Добавить строку");

        Label resultLabel = new Label();
        resultLabel.setAlignment(Pos.CENTER);
        resultLabel.setVisible(false);

        VBox rowsContainer = new VBox(10);

        addButton.setOnAction(e -> {
            HBox row = new HBox(10);

            TextField textField1 = new TextField();
            TextField textField2 = new TextField();
            TextField textField3 = new TextField();

            Button removeButton = new Button("Удалить строку");
            removeButton.setOnAction(event -> {
                rowsContainer.getChildren().remove(row);
            });

            row.getChildren().addAll(new Label("Название:"), textField1, new Label("Вес:"), textField2, new Label("Цена:"), textField3, removeButton);
            rowsContainer.getChildren().add(row);
        });

        Button solveButton = new Button("Решить");


        solveButton.setOnAction(e -> {
            List<Item> items = new ArrayList<>();


            for (Node node : rowsContainer.getChildren()) {
                if (node instanceof HBox) {
                    HBox row = (HBox) node;

                    TextField textField1 = (TextField) row.getChildren().get(1); // Первое текстовое поле
                    TextField textField2 = (TextField) row.getChildren().get(3); // Второе текстовое поле
                    TextField textField3 = (TextField) row.getChildren().get(5); // Третье текстовое поле

                    String name = textField1.getText();
                    double weight = Double.parseDouble(textField2.getText());
                    double price = Double.parseDouble(textField3.getText());

                    items.add(new Item(name, weight, price));
                }
            }

            Backpack backpack = new Backpack(8);
            backpack.makeAllSets(items);
            System.out.println(items);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(backpack.getBestItems());
            resultLabel.setText("В рюкзак нужно: "+backpack.getBestItems().toString());
            resultLabel.setVisible(true);
        });

        root.getChildren().addAll(new Label("Задача о рюкзаке"), rowsContainer,addButton, solveButton,resultLabel);

        VBox.setMargin(addButton, new Insets(10, 0, 0, 0));
        VBox.setMargin(solveButton, new Insets(10, 0, 0, 0));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop() throws Exception {
        super.stop();
    }
}