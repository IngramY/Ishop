package shopsys.ingramy.com.ishop.callback;

/**
 * @ClassName: OnMPCreatedListener.java
 * @Description: 媒体播放器创建完成
 * @author Daniel
 * @date 2016/3/17 10:28
 */
public interface MediaPlayerStatusListener {
    void onMediaPlayerCreated();
    void onCompletion();
}