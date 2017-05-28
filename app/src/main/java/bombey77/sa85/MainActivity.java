package bombey77.sa85;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        tv = (TextView) findViewById(R.id.tvResult);
        btn = (Button) findViewById(R.id.button);


    }

    public void onClick(View v) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runOnUiThread(run1);
                    TimeUnit.SECONDS.sleep(1);

                    tv.postDelayed(run2, 1000);

                    TimeUnit.SECONDS.sleep(3);
                    tv.post(run3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    Runnable run1 = new Runnable() {
        @Override
        public void run() {
            tv.setText("Run 1");
        }
    };

    Runnable run2 = new Runnable() {
        @Override
        public void run() {
            tv.setText("Run 2");
        }
    };

    Runnable run3 = new Runnable() {
        @Override
        public void run() {
            tv.setText("Run 3");
        }
    };
}
