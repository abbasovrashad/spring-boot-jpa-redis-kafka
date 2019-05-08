package com.paisabazaar.kafkaproducerlayer.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Contributed By: Tushar Mudgal
 * On: 8/5/19
 */
@Entity
@Table(name = "producers")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"id", "createdAt", "updatedAt"}, allowGetters = true)
@DynamicUpdate
public class Producer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String producerId;

    @NotNull(message = "Please enter buName")
    private String buName;

    @NotNull(message = "Please enter type")
    private String type;

    @NotNull(message = "Please enter purpose")
    private String purpose;

    @NotNull(message = "Please enter topic")
    private String topic;

    @NotNull(message = "Please enter expiry")
    private Long expiry;

    @NotNull(message = "Please enter retention")
    private Integer retention;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    /**
     * Getters and Setters Below
     */

    public Producer() {}

    /**
     * Producer Constructor
     *
     * @param producerId
     * @param buName
     * @param type
     * @param purpose
     * @param topic
     * @param expiry
     * @param retention
     * @param createdAt
     * @param updatedAt
     */
    public Producer(@NotBlank String producerId, @NotBlank String buName, @NotBlank String type, @NotBlank String purpose, @NotBlank String topic, @NotBlank Long expiry, @NotBlank Integer retention, Date createdAt, Date updatedAt) {
        this.producerId = producerId;
        this.buName = buName;
        this.type = type;
        this.purpose = purpose;
        this.topic = topic;
        this.expiry = expiry;
        this.retention = retention;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    public Integer getRetention() {
        return retention;
    }

    public void setRetention(Integer retention) {
        this.retention = retention;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
