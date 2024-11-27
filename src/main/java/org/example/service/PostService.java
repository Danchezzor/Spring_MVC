package org.example.service;

import org.example.model.Post;
import org.example.repository.IPostRepository;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;

@Service
public class PostService {
    private final IPostRepository repository;

    public PostService(IPostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) throws NotActiveException {
        return repository.getById(id).orElseThrow(NotActiveException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
