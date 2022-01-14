package me.sodafit.nicerabbit

import spark.Spark.*

class HttpServer {
    fun startServer() {
        port(8964)
        get("/extract") { request, response ->
            val webPageUrl = request.queryParams("url")
            val extractor = Extractor()
            extractor.bestVideoUrl(webPageUrl)
        }
    }
}