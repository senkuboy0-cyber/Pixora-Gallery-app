package com.pixora.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

data class EndpointConfig(val baseUrl: String, val headers: Map<String, String> = emptyMap())

class PixoraNetworkFactory {
    fun retrofit(config: EndpointConfig): Retrofit = Retrofit.Builder().baseUrl(config.baseUrl).client(OkHttpClient.Builder().build()).build()
}
