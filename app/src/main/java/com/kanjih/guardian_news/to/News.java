package com.kanjih.guardian_news.to;

import java.util.Date;

/**
 * Created by kneto on 3/7/17.
 *
 *  "id": "politics/2017/mar/07/theresa-may-heads-for-battle-with-mps-over-brexit-bill",
 "type": "article",
 "sectionId": "politics",
 "sectionName": "Politics",
 "webPublicationDate": "2017-03-07T22:15:10Z",
 "webTitle": "Theresa May heads for battle with MPs over Brexit bill",
 "webUrl": "https://www.theguardian.com/politics/2017/mar/07/theresa-may-heads-for-battle-with-mps-over-brexit-bill",
 "apiUrl": "https://content.guardianapis.com/politics/2017/mar/07/theresa-may-heads-for-battle-with-mps-over-brexit-bill",
 "isHosted": false
 */

public class News {
    private String id;
    private String type;
    private String sectionId;
    private String sectionName;
    private String webPublicationDate;
    private String webTitle;
    private String webUrl;
    private String apiUrl;
    private Boolean isHosted;

    public News(String id, String type, String sectionId, String sectionName, String webPublicationDate, String webTitle, String webUrl, String apiUrl, Boolean isHosted) {
        this.id = id;
        this.type = type;
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.webPublicationDate = webPublicationDate;
        this.webTitle = webTitle;
        this.webUrl = webUrl;
        this.apiUrl = apiUrl;
        this.isHosted = isHosted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Boolean getHosted() {
        return isHosted;
    }

    public void setHosted(Boolean hosted) {
        isHosted = hosted;
    }
}
