package com.example.demo.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {

	@Value("nacos://10.38.163.218:80")
	private String registryAddress;

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("produce-dubbo");
		applicationConfig.setQosPort(33333);
		return applicationConfig;
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(20880);
		// 服务端响应超时的时候，导致线程池满了，请求堆积，内存泄漏，需要在线程池满了之后直接返回失败
		// 1.设置dispatcher为message，MessageOnlyDispatcher
//		protocolConfig.setDispatcher("message");
//		// 2.扩大线程池
		protocolConfig.setThreads(1);
		return protocolConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(registryAddress);
		registryConfig.setRegister(false);
		return registryConfig;
	}
}