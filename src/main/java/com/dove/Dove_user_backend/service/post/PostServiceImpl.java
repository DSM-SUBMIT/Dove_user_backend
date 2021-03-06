package com.dove.Dove_user_backend.service.post;

import com.dove.Dove_user_backend.dto.request.PostRequest;
import com.dove.Dove_user_backend.dto.response.PostContentResponse;
import com.dove.Dove_user_backend.dto.response.PostListResponse;
import com.dove.Dove_user_backend.dto.response.PostResponse;
import com.dove.Dove_user_backend.entity.post.Post;
import com.dove.Dove_user_backend.entity.post.PostRepository;
import com.dove.Dove_user_backend.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public void writePost(PostRequest postRequest) {
        postRepository.save(
                Post.builder()
                        .host(postRequest.getHost())
                        .writer(postRequest.getWriter())
                        .title(postRequest.getTitle())
                        .description(postRequest.getDescription())
                        .eventDate(LocalDate.parse(postRequest.getEventDate()))
                        .link(postRequest.getLink())
                        .createdAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .adminId("not admin")
                        .build()
        );
    }

    @Override
    public PostListResponse viewList(Pageable page) {
        Page<Post> postPage = postRepository.findAllByOrderByCreatedAtDesc(page);
        List<PostResponse> postResponses = new ArrayList<>();

        for(Post post : postPage) {
            postResponses.add(
                    PostResponse.builder()
                            .id(post.getId())
                            .host(post.getHost())
                            .title(post.getTitle())
                            .eventDate(post.getEventDate())
                            .build()
            );
        }

        return PostListResponse.builder()
                    .totalElements((int)postPage.getTotalElements())
                    .totalPages(postPage.getTotalPages())
                    .postResponses(postResponses)
                    .build();
    }

    @Override
    public PostContentResponse viewPost(Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        return PostContentResponse.builder()
                .host(post.getHost())
                .writer(post.getWriter())
                .title(post.getTitle())
                .description(post.getDescription())
                .eventDate(post.getEventDate())
                .link(post.getLink())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
