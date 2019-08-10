package com.marsss.marsss_will_do.controller.short_notes;

import com.marsss.marsss_will_do.bean.short_notes.MyShortNotesBean;
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.exception.result.NullResultBeanException;
import com.marsss.marsss_will_do.entity.short_notes.MyShortNotes;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.service.short_notes.MyShortNotesService;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/apis/short_notes/my")
public class MyShortNotesController extends MyBaseController {
    @Autowired
    private UserAccountService userAccountService ;
    @Autowired
    private MyShortNotesService myShortNotesService ;

    @ApiOperation(value = "查询[我的便签]",notes = "查询[我的便签]")
    @PostMapping(value = "/get/all_short_notes")
    public MyBaseCommonResult doGetMyShortNotesByTokenId(HttpServletRequest request, String searchVal) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            List<MyShortNotesBean> beanList = myShortNotesService.doGetMyShortNotesByUserAccount(request,userAccount,searchVal);
            if(beanList == null){
                result.setCount(0);
            }   else {
                result.setResultList(beanList);
                result.setCount(beanList.size());
            }
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询[我的便签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "查询[我的便签]",notes = "查询[我的便签]")
    @PostMapping(value = "/get/by_id")
    public MyBaseCommonResult doGetMyShortNotesById(HttpServletRequest request, String id) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            MyShortNotesBean bean = myShortNotesService.doGetMyShortNotesById(request,userAccount,id);
            if(bean == null){
                throw new NullResultBeanException("查询的便签不存在！") ;
            }
            result.setBean(bean);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("查询[我的便签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "新增[我的便签]",notes = "新增[我的便签]")
    @PostMapping(value = "/add/short_notes")
    public MyBaseCommonResult doAddMyShortNotesByContent(HttpServletRequest request,MyShortNotesBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            MyShortNotesBean resultBean = myShortNotesService.doCreateMyShortNotes(request,bean) ;
            result.setBean(resultBean);
            result.setInfo("新增便签成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("新增[我的便签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "更新[我的便签]",notes = "更新[我的便签]")
    @PostMapping(value = "/update/short_notes")
    public MyBaseCommonResult doEditMyShortNotesByContent(HttpServletRequest request,MyShortNotesBean bean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            MyShortNotesBean resultBean = myShortNotesService.doUpdateMyShortNotes(request,bean) ;
            result.setBean(resultBean);
            result.setInfo("更新便签成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("更新[我的便签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "删除[我的便签]",notes = "根据id删除[我的便签]")
    @PostMapping(value = "/delete/by_id")
    public MyBaseCommonResult doDeleteMyShortNotesById(HttpServletRequest request,String shortNoteId) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = super.handleCheckIsUserAccountToken(request,true);
            myShortNotesService.doDeleteMyShortNotes(request,shortNoteId);
            result.setInfo("删除成功！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("删除[我的便签]失败"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

}
