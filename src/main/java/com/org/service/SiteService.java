package com.org.service;

import com.baomidou.mybatisplus.service.IService;
import com.org.entity.Site;

/**
 *  服务类
 */
public interface SiteService extends IService<Site> {

    Site getCurrentSite();

    void updateSite(Site site);
	
}
