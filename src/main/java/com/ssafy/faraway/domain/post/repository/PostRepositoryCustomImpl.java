package com.ssafy.faraway.domain.post.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.member.entity.QMember;
import com.ssafy.faraway.domain.post.dto.res.PostListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.ssafy.faraway.domain.post.entity.QPost.*;
import static com.ssafy.faraway.domain.member.entity.QMember.*;

@RequiredArgsConstructor
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    private final JPQLQueryFactory queryFactory;

    @Override
    public Page<PostListResponseDto> findAllBySearchCondition(SearchCondition searchCondition, Pageable pageable) {
        List<PostListResponseDto> list = queryFactory
                .select(Projections.fields(PostListResponseDto.class,
                        post.id,
                        post.member.id,
                        post.member.loginId,
                        post.category,
                        post.title,
                        post.hit,
                        post.createdDate))
                .from(post)
                .join(member).fetchJoin()
                .where(isCondition(searchCondition.getKey(), searchCondition.getWord()))
                .orderBy(post.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = queryFactory
                .select(post.id)
                .from(post)
                .fetch()
                .size();
        return new PageImpl<>(list, pageable, count);
    }

    private BooleanExpression isCondition(String key, String word) {
        if (key.equals("title")) {
            return StringUtils.hasText(key) ? post.title.like(word) : null;
        } else {
            return StringUtils.hasText(key) ? post.content.like(word) : null;
        }
    }
}