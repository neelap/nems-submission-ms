package com.nems.ctx.ms.submission.loadbalancer;

import com.nems.ctx.ms.submission.domain.Submission;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by NE281900 on 5/1/2016.
 */
@FeignClient("get-submissions")
public interface SubmissionClient {
    @RequestMapping(method = RequestMethod.GET, value = "/manuscripts")
    List<Submission> getSubmissions();
}
