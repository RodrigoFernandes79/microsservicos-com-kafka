package com.microsservices.estoque_ms.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@EnableKafka // Habilita o suporte ao Kafka dentro do Spring Boot
@Configuration // Indica que essa classe é de configuração e será carregada pelo Spring
public class KafkaConfig {
    private final static Integer PARTITION_COUNT = 1;
    private final static Integer REPLICA_COUNT = 1;
    // Definição das propriedades do Kafka que serão injetadas via application.properties:
    @Value("${spring.kafka.boostrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;
    @Value("${spring.kafka.topic.orchestrator}")
    private String orchestratorTopic;
    @Value("${spring.kafka.topic.estoque-sucess}")
    private String estoqueSucessTopic;
    @Value("${spring.kafka.topic.estoque-fail}")
    private String estoqueFailTopic;

    public KafkaConfig() {
    }

    /**
     * Construtor da classe.
     * O Spring injeta automaticamente os valores das propriedades definidas no application.properties ou application.yml.
     */
    public KafkaConfig(String bootstrapServers, String groupId, String autoOffsetReset, String orchestratorTopic, String estoqueSucessTopic, String estoqueFailTopic) {
        this.bootstrapServers = bootstrapServers;
        this.groupId = groupId;
        this.autoOffsetReset = autoOffsetReset;
        this.orchestratorTopic = orchestratorTopic;
        this.estoqueSucessTopic = estoqueSucessTopic;
        this.estoqueFailTopic = estoqueFailTopic;
    }

    /**
     * Cria e configura um consumidor Kafka.
     * O consumidor é responsável por ler mensagens dos tópicos.
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProps());
    }

    /**
     * Define as propriedades de configuração do consumidor Kafka.
     */
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        return props;
    }

    /**
     * Cria e configura um produtor Kafka.
     * O produtor é responsável por enviar mensagens para os tópicos.
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerProps());
    }

    /**
     * Define as propriedades de configuração do produtor Kafka.
     */
    private Map<String, Object> producerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    /**
     * KafkaTemplate é uma classe utilitária do Spring para facilitar a produção de mensagens no Kafka.
     * Ele usa a configuração do ProducerFactory.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    private NewTopic buildTopic(String name) {
        return TopicBuilder
                .name(name)
                .replicas(REPLICA_COUNT)
                .partitions(PARTITION_COUNT)
                .build();
    }

    @Bean
    public NewTopic orchestratorTopic() {
        return buildTopic(orchestratorTopic);
    }

    @Bean
    public NewTopic estoqueSucessTopic() {
        return buildTopic(estoqueSucessTopic);
    }

    @Bean
    public NewTopic estoqueFailTopic() {
        return buildTopic(estoqueFailTopic);
    }
}

