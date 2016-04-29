package com.nems.ctx.ms.submission.controller;

import com.nems.ctx.ms.submission.domain.Submission;
import com.nems.ctx.ms.submission.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NE281900 on 4/27/2016.
 */
@RestController
public class SubmissionController {
    @Autowired
    SubmissionRepository submissionRepository;

    @RequestMapping("/submissions")
    public Iterable<Submission> getSubmissions() {
        return submissionRepository.findAll();
    }

    @RequestMapping("/submissions/{id}")
    public Submission getSubmission(@PathVariable int id) {
        return submissionRepository.findOne(id);
    }
}
