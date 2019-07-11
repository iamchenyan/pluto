package cn.pluto.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.pluto.admin.entity.ArticleCategory;
import cn.pluto.admin.exception.GlobalException;
import cn.pluto.admin.mapper.ArticleCategoryMapper;
import cn.pluto.admin.service.ArticleCategoryService;
import cn.pluto.common.service.impl.BaseServiceImpl;

/** 
* 
* @author 作者 chenyan
* @version 创建时间：2019年6月18日 下午5:54:34 
*/
@Service
@SuppressWarnings("all")
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategory> implements ArticleCategoryService {

	@Autowired
	private ArticleCategoryMapper articleCategoryMapper ;
	
	@Override
	@Transactional
	public void save(ArticleCategory articleCategory) {
		try {
			if(!exists(articleCategory)) {
				articleCategoryMapper.insert(articleCategory) ;
			}
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}
	}
	
	private boolean exists(ArticleCategory articleCategory) {
		return articleCategoryMapper.selectCount(articleCategory) > 0 ? true : false ;
	}
	
	@Override
	@Transactional
	public void deleteByArticleId(Long id) {
		try {
			if(!id.equals(null) && id != 0) {
				if(exists(new ArticleCategory(id, 0L))) {
					ArticleCategory articleCategory = new ArticleCategory();
                    articleCategory.setArticleId(id);
                    articleCategoryMapper.delete(articleCategory);
				}
			} else {
				throw new GlobalException("参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace() ;
			throw new GlobalException(e.getMessage()) ;
		}
	}
	
	@Override
    @Transactional
    public void deleteByCategoryId(Long id) {
        try {
            if (!id.equals(null) && id != 0) {
                if (exists(new ArticleCategory(0L, id))) {
                    ArticleCategory articleCategory = new ArticleCategory();
                    articleCategory.setCategoryId(id);
                    articleCategoryMapper.delete(articleCategory);
                }
            } else {
                throw new GlobalException("参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

}
