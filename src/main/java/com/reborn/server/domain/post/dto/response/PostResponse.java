package com.reborn.server.domain.post.dto.response;

import com.reborn.server.domain.post.domain.CategoryTag;
import com.reborn.server.domain.post.domain.InterestTag;
import com.reborn.server.domain.post.domain.Post;
import com.reborn.server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {

    //author
    private Long authorId;
    private String authorNickName;
    private String authorProfileImg;
    private String authorRegion;
    private List<String> authorInterestTag;
    private String authorEmploymentStatus;
    private Integer authorRebornTemperature;

    //post
    private Long id;
    private String title;
    private String content;
    private String region;
    private String postImage;
    private Long likesCount;
    private LocalDateTime createdAt;
    private List<InterestTag> interestTags;
    private List<CategoryTag> categoryTags;

    private int commentCounts;

    public static PostResponse from(User author, Post post, List<InterestTag> interestTags, List<CategoryTag> categoryTags, int commentCounts) {
        return PostResponse.builder()
                .authorId(author.getId())
                .authorNickName(author.getNickName())
                .authorProfileImg(author.getProfileImg())
                .authorRegion(author.getRegion())
                .authorInterestTag(author.getInterestedField())
                .authorEmploymentStatus(author.getEmploymentStatus())
                .authorRebornTemperature(author.getRebornTemperature())
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .region(post.getRegion())
                .postImage(post.getPostImage())
                .likesCount(post.getLikesCount())
                .commentCounts(commentCounts)
                .createdAt(post.getCreatedAt())
                .interestTags(interestTags)
                .categoryTags(categoryTags)
                .build();
    }

    public static PostResponse of(Post post, int commentsCounts) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .authorNickName(post.getAuthor().getNickName())
                .region(post.getRegion())
                .likesCount(post.getLikesCount())
                .commentCounts(commentsCounts)
                .build();
    }
}
