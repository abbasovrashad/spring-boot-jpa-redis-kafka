package com.paisabazaar.kafkaproducerlayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class RedisUtilsService {
    @Autowired
    private RedisTemplate<String, Object> template;

    public Object getValue(final String key) {
        return template.opsForValue().get(key);
    }

    public void setValue(final String key, final String value) {
        template.opsForValue().set(key, value);
    }

    public Object getProducers() {
        return this.getAllKeys("Producer_*");
    }

    private Object getAllKeys(String key) {
        RedisConnection redisConnection = template.getConnectionFactory().getConnection();
        Set<byte[]> redisKeys = redisConnection.keys(key.getBytes());
        List<String> keysList = new ArrayList<>();
        Iterator<byte[]> it = redisKeys.iterator();
        while (it.hasNext()) {
            byte[] data = it.next();
            keysList.add(new String(data, 0, data.length));
        }
        redisConnection.close();
        return keysList;
    }

}
