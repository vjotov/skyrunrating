package com.jotov.skyrunrating;

import org.modelmapper.ModelMapper;

public class ResultDtoUnitTest {

    private ModelMapper modelMapper = new ModelMapper();
// from http://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
//    @Test
//    public void whenConvertPostEntityToPostDto_thenCorrect() {
//        Post post = new Post();
//        post.setId(Long.valueOf(1));
//        post.setTitle(randomAlphabetic(6));
//        post.setUrl("www.test.com");
//
//        PostDto postDto = modelMapper.map(post, PostDto.class);
//        assertEquals(post.getId(), postDto.getId());
//        assertEquals(post.getTitle(), postDto.getTitle());
//        assertEquals(post.getUrl(), postDto.getUrl());
//    }
//
//    @Test
//    public void whenConvertPostDtoToPostEntity_thenCorrect() {
//        PostDto postDto = new PostDto();
//        postDto.setId(Long.valueOf(1));
//        postDto.setTitle(randomAlphabetic(6));
//        postDto.setUrl("www.test.com");
//
//        Post post = modelMapper.map(postDto, Post.class);
//        assertEquals(postDto.getId(), post.getId());
//        assertEquals(postDto.getTitle(), post.getTitle());
//        assertEquals(postDto.getUrl(), post.getUrl());
//    }
}
