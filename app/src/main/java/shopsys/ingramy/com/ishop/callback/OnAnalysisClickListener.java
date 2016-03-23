package shopsys.ingramy.com.ishop.callback;

import com.zbzhixue.app.adapter.NoteListAdapter;

/**
 * @ClassName: OnAnalysisClickListener.java
 * @Description: 用于处理分析按钮点击回调
 * @author Daniel
 * @date 2016/3/9 16:27
 */
public interface OnAnalysisClickListener {

    // 点击添加笔记
    void onAddNoteClick(int itemId, NoteListAdapter noteListAdapter);

    // 点击视频分析
    void onVideoClick(String videoUrl);

    // 点击音频分析
    void onAudioClick(String audioUrl);
}