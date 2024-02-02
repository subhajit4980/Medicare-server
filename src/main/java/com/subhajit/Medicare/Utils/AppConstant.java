package com.subhajit.Medicare.Utils;

public class AppConstant {
    public static final String[] PUBLIC_URLS = {
            "/home",
            "/api/auth/**",
            "/api/productUser/**",
            "/api/test/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"
    };
    public static final String[] USER_URLS = { "/api/public/**" };
    public static final String[] ADMIN_URLS = { "/api/admin/**" };
}
