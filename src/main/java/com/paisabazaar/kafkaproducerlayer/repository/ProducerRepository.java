package com.paisabazaar.kafkaproducerlayer.repository;

import com.paisabazaar.kafkaproducerlayer.bean.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Contributed By: Tushar Mudgal
 * On: 8/5/19
 */
@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
