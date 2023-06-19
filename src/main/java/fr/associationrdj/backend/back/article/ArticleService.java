package fr.associationrdj.backend.back.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.associationrdj.backend.back.article.dto.ArticleDTOFindAll;
import fr.associationrdj.backend.back.article.dto.ArticleDTOTwoLastArticle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ObjectMapper objectMapper;
    private LocalDate dateActuel;

    public ArticleService(ArticleRepository articleRepository, ObjectMapper objectMapper) {
        this.articleRepository = articleRepository;
        this.objectMapper = objectMapper;
    }
    /**
     * Retourne tous les articles.
     * @return la liste des articles
     */
    public List<ArticleDTOFindAll> findAll(){
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(article -> objectMapper.convertValue(article, ArticleDTOFindAll.class)).toList();
    }

    /**
     * Retourne un article par son identifiant.
     * @param id l'identifiant de l'article
     * @return l'article correspondant à l'identifiant
     * @throws ResponseStatusException si l'article n'est pas trouvé
     */
    public Article findById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Article Not-Found") {
        });
    }

    /**
     * Enregistre un nouvel article.
     * @param article l'article à enregistrer
     * @return l'article enregistré
     */
    public Article save(Article article){
        return articleRepository.save(article);
    }

    /**
     * Supprime un article par son identifiant.
     * @param id l'identifiant de l'article à supprimer
     */
    public void deleteByid(Long id){
        articleRepository.deleteById(id);
    }

    /**
     * Met à jour un article.
     * @param article l'article à mettre à jour
     * @param id l'identifiant de l'article
     * @return l'article mis à jour
     * @throws RuntimeException si l'article n'est pas trouvé
     */
    public Article updateById(Long id, Article article){
        Article articleActuel = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found for id: " + id));
        articleActuel.setTitre(article.getTitre() == null ? articleActuel.getTitre() : article.getTitre());
        articleActuel.setCorps(article.getCorps() == null ? articleActuel.getCorps() : article.getCorps());
        articleActuel.setCategories(article.getCategories() == null ? articleActuel.getCategories() : article.getCategories());
        articleActuel.setUtilisateurs(article.getUtilisateurs() == null ? articleActuel.getUtilisateurs() : article.getUtilisateurs());
        articleActuel.setDate_modif(article.getDate_modif() == null ? articleActuel.getDate_modif() : article.getDate_modif());
        articleActuel.setLike_dislike(article.getLike_dislike() == null ? articleActuel.getLike_dislike() : article.getLike_dislike());
        return articleRepository.save(articleActuel);
    }
    /**
     * Retourne les deux derniers articles.
     * @return la liste des deux derniers articles
     */
    public List<ArticleDTOTwoLastArticle> twoLastArticle() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDTOTwoLastArticle> articleActuel= articles.stream().map(article -> objectMapper.convertValue(article, ArticleDTOTwoLastArticle.class)).toList();
        List<ArticleDTOTwoLastArticle> articleTwoLast = new ArrayList<>();

        for (int i = articleActuel.size()-1; i > articleActuel.size() - 3 ; i--) {
            articleTwoLast.add(articleActuel.get(i));
        }
        return articleTwoLast;
    }
}
