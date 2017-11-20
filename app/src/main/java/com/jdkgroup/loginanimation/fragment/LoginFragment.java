package com.jdkgroup.loginanimation.fragment;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.jdkgroup.loginanimation.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.jdkgroup.customview.StatusBarUtil;

public class LoginFragment extends Fragment {
    View form_login, imglogo, label_signup, darkoverlay;
    KenBurnsView kbv;
    ProgressBar pbar;
    View button_login, button_label, button_icon, ic_menu1, ic_menu2;
    private DisplayMetrics dm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        form_login = v.findViewById(R.id.form_login);
        imglogo = v.findViewById(R.id.fragmentloginLogo);
        kbv = v.findViewById(R.id.fragmentloginKenBurnsView1);
        darkoverlay = v.findViewById(R.id.fragmentloginView1);
        label_signup = v.findViewById(R.id.label_signup);

        pbar = v.findViewById(R.id.mainProgressBar1);
        button_icon = v.findViewById(R.id.button_icon);
        button_label = v.findViewById(R.id.button_label);

        dm = getResources().getDisplayMetrics();
        button_login = v.findViewById(R.id.button_login);
        button_login.setTag(0);
        pbar.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        StatusBarUtil.immersive(getActivity());
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RandomTransitionGenerator generator = new RandomTransitionGenerator(20000, new AccelerateDecelerateInterpolator());
        kbv.setTransitionGenerator(generator);

        //imglogo.animate().setStartDelay(4000).setDuration(2000).alpha(1).start();
        //imglogo.animate().setDuration(0).setStartDelay(0).rotation(85).alpha(1).start();
        //imglogo.animate().setDuration(2000).setInterpolator(new BounceInterpolator()).setStartDelay(6000).rotation(0).start();

        resetAnim(imglogo);
        imglogo.animate().setStartDelay(0).setDuration(0).scaleX(0).scaleY(0).start();
        imglogo.animate().setStartDelay(500).setDuration(2000).setInterpolator(new OvershootInterpolator()).scaleX(1).scaleY(1).start();
        imglogo.animate().setStartDelay(4000).setDuration(2000).translationY(0).alpha(1).scaleX(1).scaleY(1).start();

        darkoverlay.animate().setStartDelay(4000).setDuration(2000).alpha(0.6f).start();

        //label_signup.animate().setStartDelay(5000).setDuration(2000).alpha(1).start();
        resetAnim(label_signup);
        label_signup.animate().setStartDelay(7000).setDuration(2000).translationY(0).alpha(1).scaleX(1).scaleY(1).start();

        form_login.animate().translationY(dm.heightPixels).setStartDelay(0).setDuration(0).start();
        form_login.animate().translationY(0).setDuration(1500).alpha(1).setStartDelay(6000).start();

        button_login.animate().translationY(0).setDuration(1500).alpha(1).setStartDelay(6000).start();

        final ValueAnimator va = new ValueAnimator();
        va.setDuration(1500);
        va.setInterpolator(new DecelerateInterpolator());
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator p1) {
                RelativeLayout.LayoutParams button_login_lp = (RelativeLayout.LayoutParams) button_login.getLayoutParams();
                button_login_lp.width = Math.round(Float.valueOf(p1.getAnimatedValue().toString()));
                button_login.setLayoutParams(button_login_lp);
            }
        });

        button_login.animate().translationX(dm.widthPixels + button_login.getMeasuredWidth()).setDuration(0).setStartDelay(0).start();
        button_login.animate().translationX(0).setStartDelay(6500).setDuration(1500).setInterpolator(new OvershootInterpolator()).start();
        resetAnim(button_login);


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                pbar.animate().setStartDelay(300).setDuration(1000).alpha(1).start();

                button_label.animate().setDuration(0).setStartDelay(0).alpha(1).start();
                pbar.animate().setDuration(0).setStartDelay(0).alpha(0).start();
            }
        });
    }

    private void resetAnim(View v) {
        v.animate().setStartDelay(0).setDuration(1500).translationY(10).scaleX(1).scaleY(1).start();
    }
}
