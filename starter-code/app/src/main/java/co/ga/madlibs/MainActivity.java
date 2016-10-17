package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mAdj1;
    private EditText mAdj2;
    private EditText mNoun1;
    private EditText mNoun2;
    private EditText mAnimal;
    private EditText mGame;
    private Button mButton;

    private List<EditText> fields = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdj1 = (EditText) findViewById(R.id.adj1);
        mAdj2 = (EditText) findViewById(R.id.adj2);
        mNoun1 = (EditText) findViewById(R.id.noun1);
        mNoun2 = (EditText) findViewById(R.id.noun2);
        mAnimal = (EditText) findViewById(R.id.animal);
        mGame  = (EditText) findViewById(R.id.game);
        mButton = (Button) findViewById(R.id.button);

        fields.add(mAdj1);
        fields.add(mAdj2);
        fields.add(mNoun1);
        fields.add(mNoun2);
        fields.add(mAnimal);
        fields.add(mGame);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultAct = new Intent(MainActivity.this, ResultActivity.class);
                boolean cont = true;
                for (EditText field: fields ) {
                    String str = field.getText().toString();
                    if (str.equals("")){
                        field.setError("Fill field!");
                        cont = false;
                    } else if (cont){
                        resultAct.putExtra("input", str);
                        startActivity(resultAct);
                    }
                }
            }
        });
    }
}
