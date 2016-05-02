package com.nems.ctx.ms.submission.controller;

import com.nems.ctx.ms.submission.domain.Submission;
import com.nems.ctx.ms.submission.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NE281900 on 4/27/2016.
 */
@RestController
public class SubmissionController {
    @Autowired
    DiscoveryClient client;

    @Autowired
    SubmissionRepository submissionRepository;

    @RequestMapping("/submissions")
    public Iterable<Submission> getSubmissions() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        System.out.println(localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort());
        return submissionRepository.findAll();
    }

    @RequestMapping("/submissions/{id}")
    public Submission getSubmission(@PathVariable int id) {
        return submissionRepository.findOne(id);
    }
}
