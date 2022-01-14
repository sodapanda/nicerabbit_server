package me.sodafit.nicerabbit;

import me.sodafit.nicerabbit.newpipe.ExtractorDownloader;
import org.schabi.newpipe.extractor.NewPipe;

public class Main {
    public static void main(String[] args) {
        System.out.println("start server");

        NewPipe.init(new ExtractorDownloader());
        HttpServer httpServer = new HttpServer();
        httpServer.startServer();
    }
}
