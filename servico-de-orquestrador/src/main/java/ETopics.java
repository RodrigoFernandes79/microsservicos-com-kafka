public enum ETopics {
    //mapeando todos os topicos dos microsservicos no orquestrador
    START_SAGA("start-saga"),
    BASE_ORCHESTRATOR("orchestrator"),
    FINISH_FAIL("finish-fail"),
    PAGAMENTO_SUCESS("pagamento-sucess"),
    PAGAMENTO_FAIL("pagamento-fail"),
    ESTOQUE_SUCESS("estoque-sucess"),
    ESTOQUE_FAIL("estoque-fail"),
    PRODUTO_SUCESS("produto-sucess"),
    PRODUTO_FAIL("produto-fail"),
    NOTIFY_ENDING("notify-ending");
    private String topic;

    ETopics(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
