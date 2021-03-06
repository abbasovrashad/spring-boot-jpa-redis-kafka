package com.paisabazaar.kafkaproducerlayer.controller;

import com.paisabazaar.kafkaproducerlayer.bean.Producer;
import com.paisabazaar.kafkaproducerlayer.exception.ResourceNotFoundException;
import com.paisabazaar.kafkaproducerlayer.repository.ProducerRepository;
import com.paisabazaar.kafkaproducerlayer.service.ApplicationUtilsService;
import com.paisabazaar.kafkaproducerlayer.service.RedisUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Contributed By: Tushar Mudgal
 * On: 8/5/19
 */
@RestController
@RequestMapping("/PB_DATAPIPE_PRODUCER")
public class ProducerController {
    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    RedisUtilsService redisUtilsService;

    @Autowired
    ApplicationUtilsService applicationUtilsService;

    /**
     * Get all producers
     *
     * @return List list of Producers
     */
    @GetMapping("/producer")
    public List<Producer> getAllProducers() {
        // ## retrieve all from redis
        List<String> x = (List<String>) redisUtilsService.getProducers();

        System.out.println(x);

        return producerRepository.findAll();
    }

    /**
     * Create producer
     *
     * @param producer producer json input of type
     *                 {
     *                 "buName": "test",
     *                 "type": "test",
     *                 "purpose": "test",
     *                 "expiry": 123456789,
     *                 "retention": 500,
     *                 "topic": "test"
     *                 }
     * @return Producer created producer
     */
    @PostMapping("/producer")
    public Producer createProducer(@Valid @RequestBody Producer producer) {
        producer.setProducerId(UUID.randomUUID().toString());
        return producerRepository.save(producer);
    }

    @GetMapping("/producer/{id}")
    public Producer getProducerById(@PathVariable(value = "id") Long id) {
        return producerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producer", "id", id));
    }

    @PutMapping("/producer/{id}")
    public Producer updateProducer(@PathVariable(value = "id") Long id, @RequestBody Producer payload) {
        Producer p = producerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producer", "id", id));
        applicationUtilsService.copyNonNullProperties(payload, p);
        producerRepository.save(p);
        return p;
    }

}
