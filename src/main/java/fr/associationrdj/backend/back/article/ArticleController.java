package fr.associationrdj.backend.back.article;

import fr.associationrdj.backend.back.article.dto.ArticleDTOFindAll;
import fr.associationrdj.backend.back.article.dto.ArticleDTOTwoLastArticle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @GetMapping("")
    public List<ArticleDTOFindAll> findAll(){
        return articleService.findAll();
    }
    @GetMapping("/{id}")
    public Article findById(@PathVariable("id") Long id){
        return articleService.findById(id);
    }
    @PostMapping("")
    public Article save(@RequestBody Article article){
        return articleService.save(article);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        articleService.deleteByid(id);
    }
    @PutMapping("/{id}")
    public Article updateById(@PathVariable("id") Long id, @RequestBody Article article){
        return articleService.updateById(id, article);
    }
    @GetMapping("/twolastarticles")
    public List<ArticleDTOTwoLastArticle> threeLastArticles(){
        return articleService.twoLastArticle();
    }
}
