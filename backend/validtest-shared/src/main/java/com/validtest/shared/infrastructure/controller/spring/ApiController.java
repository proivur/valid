package com.validtest.shared.infrastructure.controller.spring;

import com.validtest.shared.domain.DomainError;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public interface ApiController {

    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();

}
