package com.nems.ctx.ms.submission.client;

import com.nems.ctx.ms.submission.domain.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/sub", method= RequestMethod.POST)
    public Submission saveSubmission(@RequestBody Submission submission){
      return submissionClient.saveSubmission(submission);
    }

    @FeignClient("get-submissions")
    interface SubmissionClient {
        @RequestMapping(value = "/submissions", method = RequestMethod.GET)
        public Iterable<Submission> getSubmissions();

        @RequestMapping(value = "/submissions", method= RequestMethod.POST)
        public Submission saveSubmission(@RequestBody Submission submission);
    }
}
