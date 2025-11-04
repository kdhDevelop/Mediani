package com.kdedevelop.mediani.adapter.out.auth.repository;

import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomSecurityContextRepository extends HttpSessionSecurityContextRepository {
}
