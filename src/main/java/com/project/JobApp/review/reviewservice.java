package com.project.JobApp.review;

import java.util.List;

public interface reviewservice {
    List<review> getallreviews(Long companyid);
    boolean addreview(Long companyid,review review);
    review getreview(Long companyid,Long reviewid);
    boolean updatereview(Long companyid,Long reviewid,review review);

    boolean deletereview(Long companyid, Long reviewid);
}
