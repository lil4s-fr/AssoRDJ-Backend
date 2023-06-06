package fr.associationrdj.backend.back.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.article.dto.ArticleDTOFindAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpClient;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ObjectMapper objectMapper;

    public ArticleService(ArticleRepository articleRepository, ObjectMapper objectMapper) {
        this.articleRepository = articleRepository;
        this.objectMapper = objectMapper;
    }
    public List<ArticleDTOFindAll> findAll(){
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(article -> objectMapper.convertValue(article, ArticleDTOFindAll.class)).toList();
    }
    public Article findById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Article Not-Found") {
        });
    }
    public Article save(Article article){
        return articleRepository.save(article);
    }
    public void deleteByid(Long id){
        articleRepository.deleteById(id);
    }
    public Article update(Article article){
        Article articleActuel = articleRepository.findById(article.getId()).orElse(null);
        if (article.getId() != null){
            articleActuel.setTitre(article.getTitre());
            articleActuel.setCorps(article.getCorps());
            articleActuel.setCategories(article.getCategories());
            articleActuel.setUtilisateurs(article.getUtilisateurs());
            articleActuel.setDate_modif(article.getDate_modif());
            articleActuel.setLike_dislike(article.getLike_dislike());
            return articleRepository.save(article);
        }else{
            throw new RuntimeException("Article Not-Found");
        }
    }
}
