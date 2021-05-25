package com.datawisher.spring.boot.elasticsearch.test;

import static java.util.Arrays.asList;

import com.datawisher.spring.boot.elasticsearch.domain.Article;
import com.datawisher.spring.boot.elasticsearch.repository.ArticleRepository;
import com.datawisher.spring.boot.elasticsearch.domain.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

    private final Author johnSmith = new Author("John Smith");
    private final Author johnDoe = new Author("John Doe");

    @Test
    public void testSave() {
        Article article = new Article("Spring Data Elasticsearch");
        article.setAuthors(asList(johnSmith, johnDoe));
        article.setTags(new String[]{"elasticsearch", "spring data"});
        articleRepository.save(article);

        article = new Article("Search engines");
        article.setAuthors(asList(johnDoe));
        article.setTags(new String[]{"search engines", "tutorial"});
        articleRepository.save(article);

        article = new Article("Second Article About Elasticsearch");
        article.setAuthors(asList(johnSmith));
        article.setTags(new String[]{"elasticsearch", "spring data"});
        articleRepository.save(article);

        article = new Article("Elasticsearch Tutorial");
        article.setAuthors(asList(johnDoe));
        article.setTags(new String[]{"elasticsearch"});
        articleRepository.save(article);
    }

    @Test
    public void testDeleteAll() {
        articleRepository.deleteAll();
    }

    @Test
    public void givenPersistedArticles_whenSearchByAuthorsName_thenRightFound() {
        final Page<Article> articleByAuthorName = articleRepository.findByAuthorsName(johnSmith.getName(), PageRequest
                .of(0, 10));
        long totalElements = articleByAuthorName.getTotalElements();
        System.out.println("totalElements = " + totalElements);
    }
}
