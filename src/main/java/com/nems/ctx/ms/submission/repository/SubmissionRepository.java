package com.nems.ctx.ms.submission.repository;

import com.nems.ctx.ms.submission.domain.Submission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by NE281900 on 4/28/2016.
 */
@RestResource(path="submissions", rel="submission")
public interface SubmissionRepository extends CrudRepository<Submission, Integer> {
}
