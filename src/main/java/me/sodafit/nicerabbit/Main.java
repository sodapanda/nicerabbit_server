package me.sodafit.nicerabbit;

import me.sodafit.nicerabbit.newpipe.DownloaderImpl;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.stream.StreamInfo;

public class Main {
    public static void main(String[] args) {
        System.out.println("start server");

        Main main = new Main();
        main.initNewPipe();
        main.getRealUrl("https://www.youtube.com/watch?v=1uDfnHoPq3w");
    }

    private void initNewPipe() {
        NewPipe.init(DownloaderImpl.init(null));
    }

    private void getRealUrl(String webpageUrl) {
        try {
            StreamInfo info = StreamInfo.getInfo(NewPipe.getService(0), webpageUrl);
            System.out.println(info.getVideoStreams().get(0).getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
