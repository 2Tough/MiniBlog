package com.mooc.interfaces.miniblog;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MiniBlogGUI extends Application {
    private PostRepository repository = new PostRepository();

    private Label titleLabel;
    private Button postButton;
    private Button listButton;
    private VBox postsContainer;

    @Override
    public void start(Stage stage) {
    VBox root = new VBox(10);

    titleLabel = new Label("MiniBlog");
    titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

    postButton = new Button("Create post");
    listButton = new Button("List posts");
    postButton.setStyle("-fx-font-size: 16px;");

    postsContainer = new VBox(5);

    root.getChildren().addAll(titleLabel, postButton, listButton, postsContainer);

    root.setAlignment(Pos.CENTER);

    Scene scene = new Scene(root, 600,400);
    stage.setTitle("MiniBlog");
    stage.setScene(scene);

    stage.show();

    postButton.setOnAction(e -> {createPost();});
    listButton.setOnAction(e-> {listPosts();});

    }

    private void createPost() {
        postsContainer.getChildren().clear();

        Label titleLabel = new Label("Title: ");
        TextField titleField = new TextField();

        Label contentLabel = new Label("Content: ");
        TextField contentField = new TextField();
        contentField.setPrefColumnCount(5);

        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            String title = titleField.getText();
            String content = contentField.getText();

            if(title != null || content != null) {
                repository.createPost(title, content);
                postsContainer.getChildren().clear();

            }
        });

        postsContainer.getChildren().addAll(titleLabel, titleField, contentLabel, contentField, submitButton);

    }

    private void listPosts() {
        postsContainer.getChildren().clear();

        repository.getAllPosts().forEach(post -> {
            System.out.println(post.getTitle());
            System.out.println(post.getContent());
            Label titleLabel = new Label(post.getTitle());
            Label contentLabel = new Label(post.getContent());

            postsContainer.getChildren().addAll(titleLabel, contentLabel);
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
