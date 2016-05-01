package com.nems.ctx.ms.submission.clientservice;

import com.nems.ctx.ms.submission.domain.Submission;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by NE281900 on 5/1/2016.
 */
@FeignClient("get-submissions")
public interface SubmissionService {
    @RequestMapping(method = RequestMethod.GET, value = "/sub")
    public Iterable<Submission> getSubmissions();
}
