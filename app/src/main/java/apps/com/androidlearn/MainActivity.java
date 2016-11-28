package apps.com.androidlearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private EditText edt_analytics_username, edt_analytics_pass;
    private Button btn_analytics_submit;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        edt_analytics_username = (EditText)findViewById(R.id.edt_analytics_username) ;
        edt_analytics_pass = (EditText)findViewById(R.id.edt_analytics_pass) ;
        btn_analytics_submit = (Button)findViewById(R.id.btn_analytics_submit) ;
        btn_analytics_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putString("username", edt_analytics_username.getText().toString());
                params.putString("password", edt_analytics_pass.getText().toString());
                mFirebaseAnalytics.setCurrentScreen(MainActivity.this, "SplashScreen", null);
                mFirebaseAnalytics.logEvent("Authentication", params);
                Toast.makeText(MainActivity.this, "Submited", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
