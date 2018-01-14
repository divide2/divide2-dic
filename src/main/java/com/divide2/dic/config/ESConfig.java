package com.divide2.dic.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by bvvy on 2018/1/14.
 * com.divide2.dic.config
 */
@Configuration
public class ESConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        return new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

    }


    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(TransportClient client) {
        return new ElasticsearchTemplate(client);
    }

}
