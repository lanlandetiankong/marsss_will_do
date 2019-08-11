package com.marsss.marsss_will_do.controller.tags;

import com.marsss.marsss_will_do.bean.tags.MyTagsBean;
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.exception.result.NullResultBeanException;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.tags.MyTagsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/apis/tags/my")
public class MyTagsController extends MyBaseController {
    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private MyTagsService myTagsService ;



    @ApiOperation(value = "查询[标签]",notes = "查询[标签]")
    @PostMapping(value = "/get/all_tags")
    public MyBaseCommonResult doGetMyTagsByTokenId(HttpServletRequest request, String searchVal) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            List<MyTagsBean> beanList = myTagsService.doGetMyTagsByUserAccount(request,userAccount,searchVal);
            if(beanList == null){
                result.setCount(0);
            }   else {
                result.setResultList(beanList);
                result.setCount(beanList.size());
            }
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询[标签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "查询[标签]",notes = "查询[标签]")
    @PostMapping(value = "/get/by_id")
    public MyBaseCommonResult doGetMyTagsById(HttpServletRequest request, String id) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            MyTagsBean bean = myTagsService.doGetMyTagsById(request,userAccount,id);
            if(bean == null){
                throw new NullResultBeanException("查询的标签不存在！") ;
            }
            result.setBean(bean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询[标签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "新增[标签]",notes = "新增[标签]")
    @PostMapping(value = "/add/by_form")
    public MyBaseCommonResult doAddMyTagsByContent(HttpServletRequest request,MyTagsBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            MyTagsBean resultBean = myTagsService.doCreateMyTags(request,bean) ;
            result.setBean(resultBean);
            result.setInfo("新增标签成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("新增[标签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "更新[标签]",notes = "更新[标签]")
    @PostMapping(value = "/update/by_form")
    public MyBaseCommonResult doEditMyTagsByContent(HttpServletRequest request,MyTagsBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            MyTagsBean resultBean = myTagsService.doUpdateMyTags(request,bean) ;
            result.setBean(resultBean);
            result.setInfo("更新标签成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("更新[标签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "删除[标签]",notes = "根据id删除[标签]")
    @PostMapping(value = "/delete/by_id")
    public MyBaseCommonResult doDeleteMyTagsById(HttpServletRequest request,String tagId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            myTagsService.doDeleteMyTags(request,tagId);
            result.setInfo("删除成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("删除[标签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }


}
