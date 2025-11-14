package com.mooc.interfaces.miniblog;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MiniBlogApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PostRepository repository = new PostRepository();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nMiniBlog Menu:");
            System.out.println("1. Create Post");
            System.out.println("2. List Posts");
            System.out.println("3. Update Post");
            System.out.println("4. Delete Post");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                 choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option!");
                continue;
            }

            switch (choice) {
                case 1-> createPost();
                case 2 -> listPosts();
                case 3 -> updatePost();
                case 4 -> deletePost();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
        System.out.println("Goodbye!");
    }

    private static int readInt(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void createPost() {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        Post post = repository.createPost(title, description);
        System.out.println("Post created!");
    }

    private static void deletePost() {

        int choice = readInt("Delete by post by (1) ID or by (2) title: ");
        if (choice == -1) {
            System.out.println("Invalid choice!");
            return;
        }

        if (choice == 1) {
            int id = readInt("Enter id: ");
            if (id == -1) {
                System.out.println("Invalid id!");
            }

            boolean deleted = repository.deletePost(id);
            System.out.println(deleted ? "Post deleted!" : "Post not found!");

        }  else if (choice == 2) {
            System.out.println("Enter post title: ");
            String title = scanner.nextLine();

            List<Post> matchingPosts = repository.getAllPosts().stream().filter(p-> p.getTitle().equals(title)).toList();

            if (matchingPosts.isEmpty()) {
                System.out.println("Post not found!");

            } else if (matchingPosts.size() == 1) {
                repository.deletePost(matchingPosts.get(0).getId());
                System.out.println("Post deleted!");
            } else {
                System.out.println("Multiple posts found!");
                for (Post post : matchingPosts) {
                    System.out.println(post.getId() + " - " + post.getTitle());
                }
                int id = readInt("Enter Id to delete: ");

                if (id == -1) {
                    System.out.println("Invalid id!");
                    return;
                }
                boolean deleted = repository.deletePost(id);
                System.out.println(deleted ? "Post deleted!" : "Post not found!");
            }

        } else {
            System.out.println("Invalid choice!");
        }

    }

    private static void updatePost() {
        int id = readInt("Enter id: ");
        if (id == -1) {
            System.out.println("Invalid id!");
            return;
        }

        Optional<Post> post = repository.getPostById(id);
        if (post.isPresent()) {

            System.out.println("Enter title: ");
            String newTitle = scanner.nextLine();
            post.get().setTitle(newTitle);

            System.out.println("Enter description: ");
            String  newDescription = scanner.nextLine();
            post.get().setContent(newDescription);

            System.out.println("Post updated!");
        }

        else {System.out.println("Post not found!");}
    }

    private static void listPosts() {
        for (Post post : repository.getAllPosts()) {
            System.out.println("ID: " + post.getId());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Content: " + post.getContent());
            System.out.println("Date: " + post.getDate());
            System.out.println("------");
        }
    }
}
