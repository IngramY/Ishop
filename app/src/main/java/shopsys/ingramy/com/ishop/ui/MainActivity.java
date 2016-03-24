package shopsys.ingramy.com.ishop.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import shopsys.ingramy.com.ishop.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(getString(R.string.dummy_text1));
    }
}
