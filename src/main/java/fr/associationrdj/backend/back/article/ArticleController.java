package fr.associationrdj.backend.back.article;

import fr.associationrdj.backend.back.article.dto.ArticleDTOFindAll;
import fr.associationrdj.backend.back.article.dto.ArticleDTOTwoLastArticle;
import fr.associationrdj.backend.back.article.dto.UUIDDto;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
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
    @PostMapping("/img")
    public UUIDDto saveImage(@RequestParam("img") MultipartFile file)throws IOException{
        return new UUIDDto(articleService.saveImage(file));
    }
    @GetMapping("/img/{id}")
    public FileSystemResource getImage(@PathVariable("id") String id) {
        return articleService.getImage(id);
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
