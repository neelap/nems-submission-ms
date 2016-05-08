package com.nems.ctx.ms.submission.controller;

import com.nems.ctx.ms.submission.domain.Submission;
import com.nems.ctx.ms.submission.domainevents.Sender;
import com.nems.ctx.ms.submission.repository.SubmissionRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by NE281900 on 4/27/2016.
 */
@RestController
@EnableBinding(Source.class)
public class SubmissionController {
    @Autowired
    DiscoveryClient client;

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    private MessageChannel output;


    @RequestMapping("/submissions")
    @HystrixCommand(fallbackMethod = "defaultgetSubmissions")
    public Iterable<Submission> getSubmissions() {
        //ServiceInstance localInstance = client.getLocalServiceInstance();
       // System.out.println(localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort());
        output.send(MessageBuilder.withPayload("Hello GET").build());
        return submissionRepository.findAll();
    }
    public Iterable<Submission> defaultgetSubmissions() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        System.out.println(localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort());
        return submissionRepository.findAll();
    }

    @RequestMapping("/submissions/{id}")
    public Submission getSubmission(@PathVariable int id) {
        return submissionRepository.findOne(id);
    }

    @RequestMapping(value = "/submissions", method= RequestMethod.POST)
    public Submission saveSubmission(@RequestBody Submission submission){
        output.send(MessageBuilder.withPayload("Hello POST").build());
        return submissionRepository.save(submission);
    }
}
