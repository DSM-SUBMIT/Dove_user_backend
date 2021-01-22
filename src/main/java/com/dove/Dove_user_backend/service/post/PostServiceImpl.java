package com.dove.Dove_user_backend.service.post;

import com.dove.Dove_user_backend.entity.post.Post;
import com.dove.Dove_user_backend.entity.post.PostRepository;
import com.dove.Dove_user_backend.exception.PostNotFoundException;
import com.dove.Dove_user_backend.payload.request.PostRequest;
import com.dove.Dove_user_backend.payload.response.PostContentResponse;
import com.dove.Dove_user_backend.payload.response.PostListResponse;
import com.dove.Dove_user_backend.payload.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public PostListResponse viewList(Pageable page) {
        Page<Post> postPage = postRepository.findAllByOrderByEventDateDesc(page);
        List<PostResponse> postResponses = new ArrayList<>();

        for(Post post : postPage) {
            postResponses.add(
                    PostResponse.builder()
                            .clubName(post.getClubName())
                            .title(post.getTitle())
                            .writer(post.getWriter())
                            .date(post.getEventDate())
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
                .clubName(post.getClubName())
                .title(post.getTitle())
                .writer(post.getWriter())
                .description(post.getDescription())
                .date(post.getEventDate())
                .link(post.getLink())
                .build();
    }

    @Override
    public void post(PostRequest postRequest) {
        postRepository.save(
                Post.builder()
                        .clubName(postRequest.getClubName())
                        .title(postRequest.getTitle())
                        .writer(postRequest.getWriter())
                        .description(postRequest.getDescription())
                        .eventDate(LocalDate.parse(postRequest.getDate()))
                        .link(postRequest.getLink())
                        .build()
        );
    }
}
