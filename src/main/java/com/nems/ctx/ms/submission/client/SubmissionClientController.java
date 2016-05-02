package com.nems.ctx.ms.submission.client;

import com.nems.ctx.ms.submission.domain.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NE281900 on 5/2/2016.
 */
@RestController
public class SubmissionClientController {

    @Autowired SubmissionClient submissionClient;

    @RequestMapping("/sub")
    public Iterable<Submission> getSubmissions() {
        return submissionClient.getSubmissions();
    }

    @FeignClient("get-submissions")
    interface SubmissionClient {
        @RequestMapping(value = "/submissions", method = RequestMethod.GET)
        public Iterable<Submission> getSubmissions();
    }
}
