package com.example.di.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.util.EncodingUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final String url = "http:\\www.institweet.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(MainActivity.this);
        button2.setOnClickListener(MainActivity.this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.button1:

                Intent intent = new Intent( MainActivity.this, ActivityWebView.class );
                intent.putExtra( "arg_url", url );
                startActivity( intent );

                break;
            case R.id.button2:

                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData( Uri.parse(url) );
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, "Instale un navegador",  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }
    }
}
