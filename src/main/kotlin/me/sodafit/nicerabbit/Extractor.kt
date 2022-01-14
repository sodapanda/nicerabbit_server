package me.sodafit.nicerabbit

import org.schabi.newpipe.extractor.NewPipe
import org.schabi.newpipe.extractor.stream.StreamInfo
import java.lang.Exception

class Extractor {
    fun bestVideoUrl(webPageUrl: String): String {
        var result = ""
        try {
            val streamInfo = StreamInfo.getInfo(NewPipe.getService(0), webPageUrl)
            println(streamInfo.videoStreams)
            result = streamInfo.videoStreams.firstOrNull() {
                it.quality == "hd720"
            }?.url ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }
}