package com.nems.ctx.ms.submission.clientcontroller;

import com.nems.ctx.ms.submission.domain.Submission;
import com.nems.ctx.ms.submission.clientservice.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NE281900 on 5/1/2016.
 */
@RestController
public class SubmissionClientController {
    @Autowired
    SubmissionService submissionService;

    @RequestMapping("/")
    public @ResponseBody
    Iterable<Submission> getSubmissions(){
        return submissionService.getSubmissions();
    }
}
