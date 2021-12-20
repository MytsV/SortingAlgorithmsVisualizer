package myts.victoria.processingapp;

import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.views.ProcessingView;

public interface IProcessingApp {

    void redraw(RedrawArguments arguments);

    void setView(ProcessingView<?> view);

}
