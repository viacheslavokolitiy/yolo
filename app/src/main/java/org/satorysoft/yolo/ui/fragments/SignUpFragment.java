package org.satorysoft.yolo.ui.fragments;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import org.satorysoft.yolo.App;
import org.satorysoft.yolo.MainActivity;
import org.satorysoft.yolo.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SignUpFragment extends Fragment {
    private static final int TINT_COLOR = 0xfffccc;
    @Bind(R.id.edt_username)
    protected AppCompatEditText userNameField;

    @Bind(R.id.edt_password)
    protected AppCompatEditText userPasswordField;

    public static SignUpFragment newInstance(){
        return new SignUpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        ButterKnife.bind(this, view);

        userNameField.setHintTextColor(ContextCompat.getColor(App.getAppInstance(), android.R.color.white));
        userNameField.setTextColor(ContextCompat.getColor(App.getAppInstance(), android.R.color.white));

        userPasswordField.setHintTextColor(ContextCompat.getColor(App.getAppInstance(), android.R.color.white));
        userPasswordField.setTextColor(ContextCompat.getColor(App.getAppInstance(), android.R.color.white));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity.getSupportActionBar() != null;

        mainActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
