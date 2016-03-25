package com.ingramy.mvptest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ingramy.mvptest.R;
import com.ingramy.mvptest.presenter.UserPresenter;

/**
 * Created by ycw on 2016/3/24.
 */
public class MainActivity extends Activity implements View.OnClickListener, IUserView {

    UserPresenter presenter;
    EditText id, first, last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.load).setOnClickListener(this);
        findViewById(R.id.show).setOnClickListener(this);
        id = (EditText) findViewById(R.id.id);
        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);
        presenter = new UserPresenter(this);
    }


    //    @Override
//    public int getID() {
//        return 0;
//    }
//
//    @Override
//    public String getFristName() {
//        return null;
//    }
//
//    @Override
//    public String getLastName() {
//        return null;
//    }
//
//    @Override
//    public void setFirstName(String firstName) {
//
//    }
//
//    @Override
//    public void setLastName(String lastName) {
//
//    }
//

    @Override
    public int getID() {
        return new Integer(id.getText().toString());
    }

    @Override
    public String getFristName() {
        return first.getText().toString();
    }

    @Override
    public String getLastName() {
        return last.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        first.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        last.setText(lastName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                try {
                    presenter.saveUser(Integer.valueOf(id.getText().toString().trim()), first.getText().toString().trim(), last.getText().toString().trim());
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "输入格式不对！！", Toast.LENGTH_LONG);
                }
                break;
            case R.id.load:
                try {
                    presenter.loadUser(Integer.valueOf(id.getText().toString().trim()));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "输入格式不对！！", Toast.LENGTH_LONG);
                }
                break;
            case R.id.show:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));


                break;
        }
    }
}
