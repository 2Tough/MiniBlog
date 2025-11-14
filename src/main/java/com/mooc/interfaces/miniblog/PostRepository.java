package com.mooc.interfaces.miniblog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private ArrayList<Post> posts;
    private int nextId = 1;

    public PostRepository() {
        this.posts = new ArrayList<>();

    }

    public Post createPost(String title, String content) {
        Post post = new Post(nextId++, title, content);
        posts.add(post);
        return post;
    }

    public Optional<Post> getPostById(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(posts);
    }

    public boolean updatePost(int id, String newTitle, String newContent) {
       Optional<Post> post = getPostById(id);
       if (post.isPresent()) {
           post.get().setTitle(newTitle);
           post.get().setContent(newContent);
           return true;
       }
       return false;
    }

    public boolean deletePost(int id) {
        return posts.removeIf(p -> p.getId() == id);
    }
}
