package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by james on 12/7/15.
 */
public class ResultActivity extends AppCompatActivity {
    private final String text = "A vacation is when you take a trip to some" +
            " %s place with your %s family. Usually, you go to some place" +
            " that is near a %s or up on a %s. A good vacation place is one" +
            " where you can ride %s or play %s";
    private TextView mText;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mText = (TextView) findViewById(R.id.result_textview);
        mBackButton = (Button) findViewById(R.id.back_button);

        Intent passed = getIntent();
        List<String> fields = passed.getStringArrayListExtra("input");

        mText.setText(String.format(text, fields));

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
