package com.sonu.FirstJobApp.job.impl;

import com.sonu.FirstJobApp.job.Job;
import com.sonu.FirstJobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
   private  List<Job>jobs=new ArrayList<>();
   private Long newId=1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(newId++);
      jobs.add(job);
    }

    @Override
    public Job finJobById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id))return job;
        }
        return null;
    }
}
