package com.project.JobApp.job;

import java.util.List;

public interface jobservice {
    List<job> findall();
    void createjob(job job);

    job getjobbyid(Long id);

    boolean deletejobbyid(Long id);

    boolean updatejobbyid(Long id, job updatedjob);
}
