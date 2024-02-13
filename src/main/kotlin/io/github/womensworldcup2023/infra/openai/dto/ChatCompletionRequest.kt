package io.github.womensworldcup2023.infra.openai.dto

data class ChatCompletionRequest(
    val model: String,
    val messages: List<Message>
)