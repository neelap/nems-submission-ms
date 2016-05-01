package com.nems.ctx.ms.submission.clientcontroller;

import com.nems.ctx.ms.submission.controller.SubmissionController;
import com.nems.ctx.ms.submission.domain.Submission;
import com.nems.ctx.ms.submission.loadbalancer.SubmissionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NE281900 on 5/1/2016.
 */
@RestController
@EnableFeignClients
public class SubmissionClientController {
    @Autowired
    SubmissionClient submissionClient;

    @RequestMapping("/")
    public Iterable<Submission> getSubmissions(){
        return submissionClient.getSubmissions();
    }
}
