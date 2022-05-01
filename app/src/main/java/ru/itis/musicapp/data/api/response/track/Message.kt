package ru.itis.musicapp.data.api.response.track

import ru.itis.musicapp.data.api.response.common.Header

data class Message(
    val body: Body,
    val header: Header
)
