package com.devmedia.crud_clientes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.devmedia.crud_clientes")
@EnableWebMvc
public class RootConfig {
}
