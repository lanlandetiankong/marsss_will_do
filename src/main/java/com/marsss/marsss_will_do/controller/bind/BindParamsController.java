package com.marsss.marsss_will_do.controller.bind;

import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyEnumResult;
import com.marsss.marsss_will_do.common.enums.project.ProjectHurryLevelEnum;
import com.marsss.marsss_will_do.common.enums.task.TaskHurryLevelEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apis/bind_param")
public class BindParamsController extends MyBaseController {

    /**
     * 项目紧急级别
     * @param request
     * @return
     */
    @PostMapping(value = "/project_hurry_level")
    public MyEnumResult bindProjectHurryLevel(HttpServletRequest request) {
        super.handleCheckIsUserAccountToken(request,false) ;
        MyEnumResult enumResult = new MyEnumResult() ;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>() ;
        for(ProjectHurryLevelEnum theEnum : ProjectHurryLevelEnum.values()){
            list.add(theEnum.toMap());
        }
        enumResult.setEnumList(list);
        enumResult.setSize(list.size());
        return enumResult ;
    }
    /**
     * 标签 紧急级别
     * @param request
     * @return
     */
    @PostMapping(value = "/tags_hurry_level")
    public MyEnumResult bindTagsHurryLevel(HttpServletRequest request) {
        super.handleCheckIsUserAccountToken(request,false) ;
        MyEnumResult enumResult = new MyEnumResult() ;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>() ;
        for(ProjectHurryLevelEnum theEnum : ProjectHurryLevelEnum.values()){
            list.add(theEnum.toMap());
        }
        enumResult.setEnumList(list);
        enumResult.setSize(list.size());
        return enumResult ;
    }

    /**
     * [任务] 级别
     * @param request
     * @return
     */
    @PostMapping(value = "/task_hurry_level")
    public MyEnumResult bindTaskHurryLevel(HttpServletRequest request) {
        super.handleCheckIsUserAccountToken(request,false) ;
        MyEnumResult enumResult = new MyEnumResult() ;
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>() ;
        for(TaskHurryLevelEnum theEnum : TaskHurryLevelEnum.values()){
            list.add(theEnum.toMap());
        }
        enumResult.setEnumList(list);
        enumResult.setSize(list.size());
        return enumResult ;
    }
}
