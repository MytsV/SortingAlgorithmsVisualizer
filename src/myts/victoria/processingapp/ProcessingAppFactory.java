package myts.victoria.processingapp;

public class ProcessingAppFactory {

    static public ProcessingApp getApp() {
        return ProcessingApp.getInstance();
    }

}
