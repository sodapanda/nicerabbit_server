package me.sodafit.nicerabbit.newpipe;

import com.github.kevinsawicki.http.HttpRequest;
import org.jetbrains.annotations.NotNull;
import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Request;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExtractorDownloader extends Downloader {
    @Override
    public Response execute(@NotNull Request request) throws IOException, ReCaptchaException {
        String httpMethod = request.httpMethod();
        String url = request.url();
        Map<String, List<String>> headers = request.headers();
        byte[] dataToSend = request.dataToSend();

        try {
            HttpRequest realRequest = null;
            if (httpMethod.equals("GET")) {
                realRequest = HttpRequest.get(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0");
                for (String headerKey : headers.keySet()) {
                    List<String> headerValueList = headers.get(headerKey);
                    for (String headerValue : headerValueList) {
                        realRequest.header(headerKey, headerValue);
                    }
                }
            }
            if (httpMethod.equals("POST")) {
                realRequest = HttpRequest.post(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0");
                for (String headerKey : headers.keySet()) {
                    List<String> headerValueList = headers.get(headerKey);
                    for (String headerValue : headerValueList) {
                        realRequest.header(headerKey, headerValue);
                    }
                }
                if (dataToSend != null) {
                    realRequest = realRequest.send(dataToSend);
                }
            }

            if (realRequest == null) {
                System.out.println("realRequest is null");
                return null;
            }

            int code = realRequest.code();
            String message = realRequest.message();
            return new Response(code,
                    message,
                    realRequest.headers(),
                    realRequest.body(),
                    realRequest.url().toString());
        } catch (Exception e) {
            throw new IOException();
        }
    }
}
