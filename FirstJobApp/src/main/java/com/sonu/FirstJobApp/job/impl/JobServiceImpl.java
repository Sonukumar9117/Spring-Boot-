package com.sonu.FirstJobApp.job.impl;

import com.sonu.FirstJobApp.job.Job;
import com.sonu.FirstJobApp.job.JobRepository;
import com.sonu.FirstJobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//   private  List<Job>jobs=new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long newId=1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(newId++);
//      jobs.add(job);
        jobRepository.save(job);
    }

    @Override
    public Job finJobById(Long id) {
//        for(Job job:job){
//            if(job.getId().equals(id))return job;
//        }
        return jobRepository.findById(id).orElse(null);
//        return null;
    }

    @Override
    public boolean deleteById(Long id) {
//        Iterator<Job>iterator= jobs.iterator();
//        while(iterator.hasNext()){
//            Job job=iterator.next();
//            if(job.getId()==id){
//                iterator.remove();
//                return true;
//            }
//        }
        try {
            jobRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
//        for(int i=0;i< jobs.size();i++){
//            if(jobs.get(i).getId()==id){
//
//                jobs.get(i).setTitle(updatedJob.getTitle());
//                jobs.get(i).setDescription(updatedJob.getDescription());
//                jobs.get(i).setMaxSalary(updatedJob.getDescription());
//                jobs.get(i).setMinSalary(
//                        updatedJob.getMinSalary());
//                jobs.get(i).setLocation(updatedJob.getLocation());
//
//                return true;
//            }
//        }
        Optional<Job>jobOptional=jobRepository.findById(id);
        if(jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMaxSalary(updatedJob.getDescription());
                job.setMinSalary(
                        updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
        }
        return false;
    }
}
