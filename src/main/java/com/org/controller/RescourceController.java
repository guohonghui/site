package com.org.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.org.annotation.SysLog;
import com.org.entity.Rescource;
import com.org.service.RescourceService;
import com.org.utils.LayerData;
import com.org.utils.QiniuFileUtil;
import com.org.utils.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/system/rescource")
public class RescourceController {

    @Autowired
    protected RescourceService rescourceService;

    @GetMapping("list")
    @SysLog("跳转资源展示列表")
    public String list(){
        return "admin/system/rescource/list";
    }

    @RequiresPermissions("sys:rescource:list")
    @PostMapping("list")
    @ResponseBody
    public LayerData<Rescource> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                     ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<Rescource> layerData = new LayerData<>();
        EntityWrapper<Rescource> wrapper = new EntityWrapper<>();
        if(!map.isEmpty()){
            String hash = (String)map.get("hash");
            if(StringUtils.isNotBlank(hash)){
                wrapper.eq("hash",hash);
            }
            String source = (String)map.get("source");
            if(StringUtils.isNotBlank(source)){
                wrapper.eq("source",source);
            }
        }
        Page<Rescource> dataPage = rescourceService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setCount((int)dataPage.getTotal());
        layerData.setData(dataPage.getRecords());
        return layerData;
    }

    @RequiresPermissions("sys:rescource:delete")
    @PostMapping("delete")
    @SysLog("删除系统资源")
    @ResponseBody
    public RestResponse delete(@RequestParam("ids[]") List<Long> ids){
        if(ids == null || ids.size() == 0){
            return RestResponse.failure("删除ID不能为空");
        }
        List<Rescource> rescources = rescourceService.selectBatchIds(ids);
        if(rescources == null || rescources.size()==0){
            return RestResponse.failure("请求参数不正确");
        }
        for (Rescource rescource : rescources){
            QiniuFileUtil.deleteQiniuP(rescource.getWebUrl());
        }
        rescourceService.deleteBatchIds(ids);
        return RestResponse.success();
    }

}
