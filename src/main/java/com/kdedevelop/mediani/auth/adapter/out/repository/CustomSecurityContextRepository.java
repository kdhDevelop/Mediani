package com.kdedevelop.mediani.auth.adapter.out.repository;

import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomSecurityContextRepository extends HttpSessionSecurityContextRepository {
}
