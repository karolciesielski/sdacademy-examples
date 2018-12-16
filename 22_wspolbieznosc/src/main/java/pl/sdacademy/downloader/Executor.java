package pl.sdacademy.downloader;

public interface Executor {
    void execute (Runnable codeToExecute, TaskFinishedListener listener);
}
